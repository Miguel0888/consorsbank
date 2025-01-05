package consorsbank.controllers;

import com.consorsbank.module.tapi.grpc.security.SecurityMarketDataReply;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;

import java.util.logging.Level;
import java.util.logging.Logger;

public class MainController {

    @FXML
    private Button btnLoadMarketData;
    @FXML
    private TextArea txtOutput;
    @FXML
    private TextArea txtRawData;
    @FXML
    private TableView<MarketDataRow> marketDataTable;
    @FXML
    private TableColumn<MarketDataRow, String> columnField;
    @FXML
    private TableColumn<MarketDataRow, String> columnValue;

    private final ObservableList<MarketDataRow> marketData = FXCollections.observableArrayList();

    @FXML
    public void initialize() {
        // Set up the TableView columns
        columnField.setCellValueFactory(new PropertyValueFactory<>("field"));
        columnValue.setCellValueFactory(new PropertyValueFactory<>("value"));

        marketDataTable.setItems(marketData);

        btnLoadMarketData.setOnAction(event -> loadMarketData());
    }

    private void loadMarketData() {
        Logger.getLogger("io.grpc").setLevel(Level.FINE);
        txtOutput.setText("Marktdaten werden geladen...\n");

        try {
            // Simulated response from the market data observer
            SecurityMarketDataReply response = simulateMarketDataResponse();

            // Clear previous data
            marketData.clear();

            // Populate table and raw data
            StringBuilder rawData = new StringBuilder();
            response.getAllFields().entrySet().forEach(entry -> {
                String fieldName = entry.getKey().getName();
                String value = entry.getValue().toString();
                marketData.add(new MarketDataRow(fieldName, value));
                rawData.append(fieldName).append(": ").append(value).append("\n");
            });

            txtRawData.setText(rawData.toString());
            txtOutput.appendText("Marktdaten erfolgreich geladen.\n");

        } catch (Exception e) {
            txtOutput.appendText("Fehler beim Laden der Marktdaten: " + e.getMessage() + "\n");
        }
    }

    private SecurityMarketDataReply simulateMarketDataResponse() {
        // Mock response for demonstration purposes
        return SecurityMarketDataReply.newBuilder()
                .setLastPrice(52.34)
                .setCurrency("EUR")
                .setHighPrice(53.94)
                .build();
    }

    public void showAboutDialog() {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Über");
        alert.setHeaderText("ConsorsBank Dashboard");
        alert.setContentText("Version 1.0\nEntwickelt von ConsorsBank.");
        alert.showAndWait();
    }

    public void exitApplication() {
        System.exit(0);
    }

    public static class MarketDataRow {
        private final String field;
        private final String value;

        public MarketDataRow(String field, String value) {
            this.field = field;
            this.value = value;
        }

        public String getField() {
            return field;
        }

        public String getValue() {
            return value;
        }
    }
}
