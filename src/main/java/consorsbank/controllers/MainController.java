package consorsbank.controllers;

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

    @FXML
    public void initialize() {
        initializeWknDropdown();
        initializeToolbar();
        initializeActions();
    }

    @FXML
    public void openTradingApiSettings() {
        // Keep your existing implementation here (dialog + save)
        // This method is referenced from FXML menu item.
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
        // Optional: keep existing button working, but route it to the same behavior.
        if (btnLoadMarketData != null) {
            btnLoadMarketData.setOnAction(event -> loadChartAndStartStreaming());
        }
    }

    private void loadChartAndStartStreaming() {
        Wkn selectedWkn = selectedWknOrShowError();
        if (selectedWkn == null) {
            return;
        }

        Pane chartPane = loadChartPaneOrShowError();
        if (chartPane == null) {
            return;
        }

        chartContainer.getChildren().clear();
        chartContainer.getChildren().add(chartPane);

        // Tell the chart controller the selected WKN (if it supports it)
        applySelectedWknToChartController(selectedWkn);

        // Start market data stream after chart is present
        startStreamingFor(selectedWkn);
    }

    private Pane loadChartPaneOrShowError() {
        try {
            FXMLLoader chartLoader = new FXMLLoader(getClass().getResource("/views/chart.fxml"));
            Pane chartPane = chartLoader.load();

            Object controller = chartLoader.getController();
            storeChartController(controller);

            return chartPane;
        } catch (IOException e) {
            showError("Chart konnte nicht geladen werden", safeMessage(e));
            return null;
        }
    }

    private Object lastChartController;

    private void storeChartController(Object controller) {
        this.lastChartController = controller;
    }

    private void applySelectedWknToChartController(Wkn wkn) {
        if (lastChartController instanceof WknSelectionAware) {
            ((WknSelectionAware) lastChartController).setSelectedWkn(wkn);
        }
    }

    private void startStreamingFor(Wkn wkn) {
        txtOutput.setText("Starte Stream für WKN " + wkn.getValue() + "...\n");

        // TODO: Replace with real exchange/currency selection from UI later
        String stockExchangeId = "OTC";
        String currency = "EUR";

        marketDataService.streamMarketData(wkn, stockExchangeId, currency);

        // Temporary feedback: show the first incoming update in txtOutput
        new Thread(new Runnable() {
            @Override
            public void run() {
                pollOnceAndRenderStock(wkn);
            }
        }, "market-data-first-update").start();
    }

    private void pollOnceAndRenderStock(Wkn wkn) {
        try {
            while (true) {
                Stock stock = marketDataService.getStock(wkn);
                if (stock != null) {
                    Platform.runLater(new Runnable() {
                        @Override
                        public void run() {
                            txtOutput.setText(stock.toString());
                        }
                    });
                    break;
                }
                Thread.sleep(250);
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }

    private Wkn selectedWknOrShowError() {
        String wknRaw = wknDropdown.getValue();
        if (wknRaw == null || wknRaw.trim().isEmpty()) {
            showError("Keine WKN ausgewählt", "Bitte zuerst im Dropdown eine WKN auswählen.");
            return null;
        }
        return new Wkn(wknRaw.trim());
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
