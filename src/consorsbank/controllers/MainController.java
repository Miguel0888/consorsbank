package consorsbank.controllers;

import consorsbank.api.ChatGPTService;
import consorsbank.api.MarketDataService;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;

public class MainController {

    @FXML
    private Button btnLoadMarketData;

    @FXML
    private TextArea txtOutput;

    @FXML
    public void initialize() {
        btnLoadMarketData.setOnAction(event -> loadMarketData());
    }

    private void loadMarketData() {
        txtOutput.setText("Marktdaten werden geladen...");
        try {
            MarketDataService marketService = new MarketDataService("localhost", 40443);
            String marketData = marketService.getMarketData("WKN123456");

            ChatGPTService chatGPTService = new ChatGPTService();
            String analysis = chatGPTService.sendMessage("Analysiere diese Daten: " + marketData);

            txtOutput.setText("Marktdaten:\n" + marketData + "\n\nAnalyse:\n" + analysis);
            marketService.close();
        } catch (Exception e) {
            txtOutput.setText("Fehler: " + e.getMessage());
        }
    }

}
