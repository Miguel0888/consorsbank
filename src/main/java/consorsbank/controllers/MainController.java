package consorsbank.controllers;

import com.consorsbank.module.tapi.grpc.security.SecurityCode;
import com.consorsbank.module.tapi.grpc.security.SecurityCodeType;
import com.consorsbank.module.tapi.grpc.security.SecurityMarketDataReply;
import com.consorsbank.module.tapi.grpc.security.SecurityMarketDataRequest;
import com.consorsbank.module.tapi.grpc.security.SecurityWithStockExchange;
import com.consorsbank.module.tapi.grpc.stock.StockExchange;
import com.consorsbank.module.tapi.observers.MarketDataDataObserver;
import consorsbank.api.SecureMarketDataService;
import io.grpc.stub.StreamObserver;
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
        txtOutput.setText("Marktdaten werden geladen...\n");

        try {
            // Initialisiere den SecureMarketDataService mit Zertifikat
            SecureMarketDataService marketService = new SecureMarketDataService(
                    "localhost", // Host
                    40443,       // Port
                    "roots.pem"  // Pfad zum Zertifikat in resources
            );

            // Beispiel-Secret für die Authentifizierung
            String secret = "123456";

            // Login durchführen und Access-Token abrufen
            String accessToken = marketService.login(secret);

            if (accessToken == null || accessToken.isEmpty()) {
                txtOutput.appendText("Login fehlgeschlagen. Bitte überprüfe das Secret und die API-Konfiguration.\n");
                return;
            }
            txtOutput.appendText("Login erfolgreich! Access-Token erhalten.\n");

            // Eingaben für den SecurityMarketDataRequest
            String securityCodeStr = "710000"; // Beispiel-WKN für Mercedes
            SecurityCodeType securityCodeType = SecurityCodeType.WKN; // Typ: WKN
            String stockExchangeId = "OTC"; // Beispiel: OTC
            String currency = "EUR"; // Beispiel: EUR

            // Erstellen des SecurityMarketDataRequest
            SecurityCode securityCode = SecurityCode.newBuilder()
                    .setCode(securityCodeStr)
                    .setCodeType(securityCodeType)
                    .build();

            StockExchange stockExchange = StockExchange.newBuilder()
                    .setId(stockExchangeId)
                    .build();

            SecurityWithStockExchange securityWithStockExchange = SecurityWithStockExchange.newBuilder()
                    .setSecurityCode(securityCode)
                    .setStockExchange(stockExchange)
                    .build();

            SecurityMarketDataRequest request = SecurityMarketDataRequest.newBuilder()
                    .setAccessToken(accessToken)
                    .setSecurityWithStockexchange(securityWithStockExchange)
                    .setCurrency(currency)
                    .build();

            // Stream starten und Observer direkt implementieren
            marketService.streamMarketData(request, new MarketDataDataObserver(request, marketService.getSecurityServiceStub()) {
                @Override
                public void onNext(SecurityMarketDataReply response) {
                    if (response.getError() == null || "0".equals(response.getError().getCode())) {
                        String message = String.format("Erhaltene Marktdaten: Preis: %.2f, Datum: %s\n",
                                response.getLastPrice(), response.getLastDateTime());
                        txtOutput.appendText(message);
                    } else {
                        txtOutput.appendText("Fehler in der Antwort: " + response.getError().getMessage() + "\n");
                    }
                }

//                @Override
//                public void onError(Throwable t) {
//                    txtOutput.appendText("Fehler: " + t.getMessage() + "\n");
//                }

                @Override
                public void onCompleted() {
                    txtOutput.appendText("Marktdaten-Stream abgeschlossen.\n");
                }
            });

            // Bereinigung bei Shutdown
            Runtime.getRuntime().addShutdownHook(new Thread(marketService::close));

        } catch (Exception e) {
            txtOutput.appendText("Fehler beim Laden der Marktdaten: " + e.getMessage() + "\n");
        }
    }
}
