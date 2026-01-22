package consorsbank.controllers;

import consorsbank.config.SecureMarketDataConfig;
import consorsbank.config.persistence.SecureMarketDataConfigStore;
import consorsbank.controllers.dialogs.TradingApiSettingsDialog;
import consorsbank.services.SecureMarketDataService;
import consorsbank.services.connection.ActiveTraderConnectionListener;
import consorsbank.services.connection.ActiveTraderConnectionMonitor;
import consorsbank.services.connection.ActiveTraderConnectionState;
import consorsbank.services.connection.ActiveTraderConnectionStatus;
import consorsbank.model.Wkn;
import consorsbank.util.SpringFXMLLoader;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.*;
import javafx.scene.layout.StackPane;
import org.springframework.stereotype.Controller;

import javax.annotation.PreDestroy;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

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

    @FXML
    private Label lblConnectionStatus;

    @FXML
    private ProgressIndicator piConnection;

    private Button loadChartButton;

    private final SecureMarketDataService marketDataService;
    private final SpringFXMLLoader springFXMLLoader;

    private final SecureMarketDataConfigStore configStore;
    private final SecureMarketDataConfig currentConfig;

    private final ActiveTraderConnectionMonitor connectionMonitor;

    private final ActiveTraderConnectionListener uiConnectionListener = new ActiveTraderConnectionListener() {
        @Override
        public void onStatusChanged(final ActiveTraderConnectionStatus status) {
            Platform.runLater(new Runnable() {
                @Override
                public void run() {
                    renderConnectionStatus(status);
                }
            });
        }
    };

    public MainController(SecureMarketDataService marketDataService,
                          SpringFXMLLoader springFXMLLoader,
                          SecureMarketDataConfigStore configStore,
                          SecureMarketDataConfig currentConfig,
                          ActiveTraderConnectionMonitor connectionMonitor) {
        this.marketDataService = marketDataService;
        this.springFXMLLoader = springFXMLLoader;
        this.configStore = configStore;
        this.currentConfig = currentConfig;
        this.connectionMonitor = connectionMonitor;
    }

    @FXML
    public void initialize() {
        initializeWknDropdown();
        initializeToolbar();
        initializeActions();
        initializeConnectionStatus();
    }

    @PreDestroy
    public void onDestroy() {
        // Remove listener to avoid leaking UI references
        connectionMonitor.removeListener(uiConnectionListener);
    }

    @FXML
    public void openTradingApiSettings() {
        SecureMarketDataConfig initial = loadInitialConfigForDialog();

        TradingApiSettingsDialog dialog = new TradingApiSettingsDialog(txtOutput.getScene().getWindow(), initial);
        Optional<SecureMarketDataConfig> result = dialog.showAndWait();

        if (result.isPresent()) {
            configStore.save(result.get());
            showInfo(
                    "Einstellungen gespeichert",
                    "Die Trading-API Einstellungen wurden gespeichert.\nBitte starte die Anwendung neu, damit sie wirksam werden."
            );
        }
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
        loadChartButton.setOnAction(event -> loadChartAndStartStreaming());

        toolbar.getItems().add(loadChartButton);
    }

    private void initializeActions() {
        // Route the old button to the same behavior to keep UX consistent
        if (btnLoadMarketData != null) {
            btnLoadMarketData.setOnAction(event -> loadChartAndStartStreaming());
        }
    }

    private void initializeConnectionStatus() {
        if (lblConnectionStatus != null) {
            lblConnectionStatus.setText("Starte...");
        }
        if (piConnection != null) {
            piConnection.setVisible(false);
        }
        connectionMonitor.addListener(uiConnectionListener);
    }

    private void renderConnectionStatus(ActiveTraderConnectionStatus status) {
        if (lblConnectionStatus != null) {
            lblConnectionStatus.setText(status.getMessage());
        }
        if (piConnection != null) {
            piConnection.setVisible(status.getState() == ActiveTraderConnectionState.CONNECTING);
        }
    }

    private void loadChartAndStartStreaming() {
        Wkn wkn = selectedWknOrShowError();
        if (wkn == null) {
            return;
        }

        Parent chartRoot = loadChartWithSpringController(wkn);
        if (chartRoot == null) {
            return;
        }

        chartContainer.getChildren().clear();
        chartContainer.getChildren().add(chartRoot);

        startStreamingFor(wkn);
    }

    private Parent loadChartWithSpringController(Wkn wkn) {
        try {
            FXMLLoader loader = springFXMLLoader.load("/views/chart.fxml");
            Parent root = loader.load();

            Object controller = loader.getController();
            if (controller instanceof WknSelectionAware) {
                ((WknSelectionAware) controller).setSelectedWkn(wkn);
            }

            return root;
        } catch (IOException e) {
            txtOutput.setText("Chart konnte nicht geladen werden: " + safeMessage(e));
            e.printStackTrace();
            return null;
        }
    }

    private void startStreamingFor(Wkn wkn) {
        // Start stream to feed the chart controller listener
        txtOutput.setText("Starte Stream für WKN " + wkn.getValue() + "...\n");

        // Keep defaults for now; later drive these from UI
        String stockExchangeId = "OTC";
        String currency = "EUR";

        marketDataService.streamMarketData(wkn, stockExchangeId, currency);
    }

    private Wkn selectedWknOrShowError() {
        String wknValue = wknDropdown.getValue();
        if (wknValue == null || wknValue.trim().isEmpty()) {
            showError("Keine WKN ausgewählt", "Bitte zuerst im Dropdown eine WKN auswählen.");
            return null;
        }
        return new Wkn(wknValue.trim());
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

    private void showError(String title, String message) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle(title);
        alert.setHeaderText(title);
        alert.setContentText(message);
        alert.initOwner(txtOutput.getScene().getWindow());
        alert.showAndWait();
    }

    private String safeMessage(Throwable t) {
        String msg = t.getMessage();
        return msg == null ? t.getClass().getSimpleName() : msg;
    }
}
