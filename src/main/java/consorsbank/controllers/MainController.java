package consorsbank.controllers;

import consorsbank.model.Wkn;
import consorsbank.services.SecureMarketDataService;
import consorsbank.util.SpringFXMLLoader;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextArea;
import javafx.scene.control.ToolBar;
import javafx.scene.layout.StackPane;
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

    private final SecureMarketDataService marketDataService;
    private final SpringFXMLLoader springFXMLLoader;

    private Button loadChartButton;

    public MainController(SecureMarketDataService marketDataService, SpringFXMLLoader springFXMLLoader) {
        this.marketDataService = marketDataService;
        this.springFXMLLoader = springFXMLLoader;
    }

    @FXML
    public void initialize() {
        List<String> daxWkns = Arrays.asList("710000", "846900", "578580", "823212", "514000");
        wknDropdown.getItems().addAll(daxWkns);
        wknDropdown.setValue(null);

        loadChartButton = new Button("📊 Load Chart");
        loadChartButton.setStyle("-fx-font-size: 14px;");
        loadChartButton.setOnAction(event -> loadChartAndStartStream());

        toolbar.getItems().add(loadChartButton);

        if (btnLoadMarketData != null) {
            btnLoadMarketData.setOnAction(event -> loadChartAndStartStream());
        }
    }

    @FXML
    public void openTradingApiSettings() {
        // Keep your existing implementation
    }

    @FXML
    public void onExit() {
        Platform.exit();
        System.exit(0);
    }

    private void loadChartAndStartStream() {
        String wknValue = wknDropdown.getValue();
        if (wknValue == null || wknValue.trim().isEmpty()) {
            txtOutput.setText("Bitte eine WKN auswählen.\n");
            return;
        }

        Wkn wkn = new Wkn(wknValue.trim());

        Parent chartRoot = loadChart(wkn);
        if (chartRoot == null) {
            return;
        }

        chartContainer.getChildren().clear();
        chartContainer.getChildren().add(chartRoot);

        startStreamingFor(wkn);
    }

    private Parent loadChart(Wkn wkn) {
        try {
            FXMLLoader loader = springFXMLLoader.load("/views/chart.fxml");
            Parent root = loader.load();

            Object controller = loader.getController();
            if (controller instanceof WknSelectionAware) {
                ((WknSelectionAware) controller).setSelectedWkn(wkn);
            }

            return root;
        } catch (IOException e) {
            e.printStackTrace();
            txtOutput.setText("Chart konnte nicht geladen werden: " + e.getMessage());
            return null;
        }
    }

    private void startStreamingFor(Wkn wkn) {
        txtOutput.setText("Starte Stream für WKN " + wkn.getValue() + "...\n");

        String stockExchangeId = "OTC";
        String currency = "EUR";

        marketDataService.streamMarketData(wkn, stockExchangeId, currency);
    }
}
