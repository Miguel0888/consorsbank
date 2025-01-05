package consorsbank.controllers;

import com.consorsbank.module.tapi.grpc.security.SecurityCodeType;
import com.consorsbank.module.tapi.grpc.security.SecurityMarketDataRequest;
import com.consorsbank.module.tapi.observers.MarketDataDataObserver;
import consorsbank.api.ChatGPTService;
import consorsbank.api.MarketDataService;
import consorsbank.observers.CustomMarketDataObserver;
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
            // Initialisiere den MarketDataService
            MarketDataService marketService = new MarketDataService("localhost", 40443);

            // Eingaben für den Stream
            String accessToken = "DEIN_ACCESS_TOKEN";
            String securityCodeStr = "WKN123456";
            SecurityCodeType securityCodeType = SecurityCodeType.WKN; // Beispiel: WKN
            String stockExchangeId = "OTC"; // Beispiel: OTC
            String currency = "EUR"; // Beispiel: EUR

            // Erstellen des SecurityMarketDataRequest
            SecurityMarketDataRequest request = marketService.createMarketDataRequest(
                    accessToken, securityCodeStr, securityCodeType, stockExchangeId, currency
            );

            // Starte den Stream mit CustomMarketDataObserver
            CustomMarketDataObserver customObserver = new CustomMarketDataObserver(
                    request,
                    marketService.getSecurityServiceStub()
            );

            // Füge die Callback-Logik hinzu
            customObserver.setOnMarketDataUpdate(data -> {
                String message = "Erhaltene Marktdaten: Preis: " + data.getLastPrice() +
                        " Datum: " + data.getLastDateTime() + "\n";
                txtOutput.appendText(message);
            });

            customObserver.setOnError(error -> txtOutput.appendText("Fehler: " + error.getMessage() + "\n"));
            customObserver.setOnComplete(() -> txtOutput.appendText("Marktdaten-Stream abgeschlossen.\n"));

            // Bereinigen bei Shutdown
            Runtime.getRuntime().addShutdownHook(new Thread(() -> {
                customObserver.close();
                marketService.close();
            }));

        } catch (Exception e) {
            txtOutput.setText("Fehler beim Laden der Marktdaten: " + e.getMessage());
        }
    }


}
