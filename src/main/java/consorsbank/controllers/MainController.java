package consorsbank.controllers;

import consorsbank.services.SecureMarketDataService;
import io.grpc.stub.StreamObserver;
import org.springframework.stereotype.Controller;

@Controller
public class MainController {

    private final SecureMarketDataService marketDataService;

    public MainController(SecureMarketDataService marketDataService) {
        this.marketDataService = marketDataService;
    }

    public void executeActions() {
        try {
            // Login und Token abrufen
            String secret = "123456"; // Beispiel-Secret
            String accessToken = marketDataService.login(secret);
            System.out.println("Login erfolgreich! Access-Token: " + accessToken);

            // Marktdaten abrufen
            String securityCode = "710000"; // Beispiel-WKN
            String stockExchangeId = "OTC";
            String currency = "EUR";

            System.out.println("Starte Marktdaten-Streaming...");
            marketDataService.streamMarketData(accessToken, securityCode, stockExchangeId, currency, new StreamObserver<>() {
                @Override
                public void onNext(String data) {
                    System.out.println("Empfangene Marktdaten: " + data);
                }

                @Override
                public void onError(Throwable t) {
                    System.err.println("Fehler beim Abrufen der Marktdaten: " + t.getMessage());
                }

                @Override
                public void onCompleted() {
                    System.out.println("Marktdaten-Streaming abgeschlossen.");
                }
            });

        } catch (Exception e) {
            System.err.println("Fehler im Controller: " + e.getMessage());
        }
    }
}
