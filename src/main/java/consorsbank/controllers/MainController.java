package consorsbank.controllers;

import com.consorsbank.module.tapi.grpc.AccessServiceGrpc;
import com.consorsbank.module.tapi.grpc.SecurityServiceGrpc;
import com.consorsbank.module.tapi.grpc.access.LoginReply;
import com.consorsbank.module.tapi.grpc.access.LoginRequest;
import com.consorsbank.module.tapi.grpc.security.SecurityCode;
import com.consorsbank.module.tapi.grpc.security.SecurityCodeType;
import com.consorsbank.module.tapi.grpc.security.SecurityMarketDataReply;
import com.consorsbank.module.tapi.grpc.security.SecurityMarketDataRequest;
import com.consorsbank.module.tapi.grpc.security.SecurityWithStockExchange;
import com.consorsbank.module.tapi.grpc.stock.StockExchange;
import com.consorsbank.module.tapi.observers.MarketDataDataObserver;
import consorsbank.api.SecureMarketDataService;
import io.grpc.ManagedChannel;
import io.grpc.stub.StreamObserver;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;

import java.util.logging.Level;
import java.util.logging.Logger;

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
        Logger.getLogger("io.grpc").setLevel(Level.FINE);

        txtOutput.setText("Marktdaten werden geladen...\n");

        try {
            // Initialisiere den SecureMarketDataService
            SecureMarketDataService marketService = new SecureMarketDataService(
                    "localhost", // Host
                    40443,       // Port
                    "src/main/resources/roots.pem" // Pfad zum Zertifikat
            );

            // Beispiel-Secret für die Authentifizierung
            String secret = "123456";

            // Login durchführen
            ManagedChannel channel = marketService.getChannel();
            AccessServiceGrpc.AccessServiceBlockingStub accessServiceStub = AccessServiceGrpc.newBlockingStub(channel);

            LoginRequest loginRequest = LoginRequest.newBuilder().setSecret(secret).build();
            LoginReply loginReply = accessServiceStub.login(loginRequest);

            if (loginReply.getError() != null && !loginReply.getError().equals(com.consorsbank.module.tapi.grpc.common.Error.getDefaultInstance())) {
                txtOutput.appendText("Login fehlgeschlagen: " + loginReply.getError().getMessage() + "\n");
                return;
            }

            String accessToken = loginReply.getAccessToken();
            txtOutput.appendText("Login erfolgreich! Access-Token erhalten.\n");

            // Eingaben für den SecurityMarketDataRequest
            String securityCodeStr = "710000"; // Beispiel-WKN
            SecurityCodeType securityCodeType = SecurityCodeType.WKN;
            String stockExchangeId = "OTC";
            String currency = "EUR";

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

            SecurityServiceGrpc.SecurityServiceStub securityServiceStub = SecurityServiceGrpc.newStub(channel);

            MarketDataDataObserver observer = new MarketDataDataObserver(request, securityServiceStub);
            observer.onCompleted();

            txtOutput.appendText("Marktdaten-Stream abgeschlossen.\n");

        } catch (Exception e) {
            txtOutput.appendText("Fehler beim Laden der Marktdaten: " + e.getMessage() + "\n");
        }
    }

}
