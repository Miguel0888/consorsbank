package consorsbank.controllers;

import consorsbank.config.SecureMarketDataConfig;
import consorsbank.config.persistence.SecureMarketDataConfigStore;
import consorsbank.controllers.dialogs.TradingApiSettingsDialog;
import consorsbank.model.Stock;
import consorsbank.model.Wkn;
import consorsbank.services.SecureMarketDataService;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextArea;
import javafx.scene.control.ToolBar;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

@Controller
public class MainController {

    @FXML
    private ComboBox<String> wknDropdown;

    @FXML
    private Button btnLoadMarketData;

    @FXML
    private ToolBar toolbar;

    @FXML
    private StackPane chartContainer;

    @FXML
    private TextArea txtOutput;

    private Button loadChartButton;

    @Autowired
    private SecureMarketDataService marketDataService;

    @Autowired
    private SecureMarketDataConfigStore configStore;

    @Autowired
    private SecureMarketDataConfig currentConfig;

    @FXML
    public void initialize() {
        initializeWknDropdown();
        initializeToolbar();
        initializeActions();
    }

    @FXML
    public void openTradingApiSettings() {
        SecureMarketDataConfig initial = loadInitialConfigForDialog();

        TradingApiSettingsDialog dialog = new TradingApiSettingsDialog(txtOutput.getScene().getWindow(), initial);
        dialog.showAndWait().ifPresent(config -> {
            configStore.save(config);
            showInfo(
                    "Einstellungen gespeichert",
                    "Die Trading-API Einstellungen wurden gespeichert.\nBitte starte die Anwendung neu, damit sie wirksam werden."
            );
        });
    }

    @FXML
    public void onExit() {
        Platform.exit();
        System.exit(0);
    }

    private void initializeWknDropdown() {
        List<String> daxWkns = Arrays.asList("710000", "846900", "578580", "823212", "514000");
        wknDropdown.getItems().addAll(daxWkns);
        wknDropdown.setValue(null);
    }

    private void initializeToolbar() {
        loadChartButton = new Button("📊 Load Chart");
        loadChartButton.setStyle("-fx-font-size: 14px;");
        loadChartButton.setOnAction(event -> loadChart());

        toolbar.getItems().add(loadChartButton);
    }

    private void initializeActions() {
        btnLoadMarketData.setOnAction(event -> loadMarketData());
    }

    private void loadChart() {
        try {
            FXMLLoader chartLoader = new FXMLLoader(getClass().getResource("/views/chart.fxml"));
            Pane chartPane = chartLoader.load();

            chartContainer.getChildren().clear();
            chartContainer.getChildren().add(chartPane);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void loadMarketData() {
        String securityCode = wknDropdown.getValue();

        if (securityCode == null) {
            txtOutput.setText("Bitte eine WKN auswählen.\n");
            return;
        }

        txtOutput.setText("Marktdaten werden für WKN " + securityCode + " geladen...\n");

        Wkn wkn = new Wkn(securityCode);
        String stockExchangeId = "OTC";
        String currency = "EUR";

        marketDataService.streamMarketData(wkn, stockExchangeId, currency);

        new Thread(() -> pollOnceAndRenderStock(wkn)).start();
    }

    private void pollOnceAndRenderStock(Wkn wkn) {
        try {
            while (true) {
                Stock stock = marketDataService.getStock(wkn);
                if (stock != null) {
                    Platform.runLater(() -> txtOutput.setText(stock.toString()));
                    break;
                }
                Thread.sleep(500);
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }

    private SecureMarketDataConfig loadInitialConfigForDialog() {
        SecureMarketDataConfig stored = configStore.loadOrNull();
        if (stored != null) {
            return stored;
        }
        return currentConfig;
    }

    private void showInfo(String title, String message) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle(title);
        alert.setHeaderText(title);
        alert.setContentText(message);
        alert.initOwner(txtOutput.getScene().getWindow());
        alert.showAndWait();
    }
}
