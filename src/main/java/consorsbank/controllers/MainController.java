package consorsbank.controllers;

import com.consorsbank.module.tapi.grpc.access.LoginReply;
import com.consorsbank.module.tapi.grpc.access.LoginRequest;
import com.consorsbank.module.tapi.grpc.security.SecurityCode;
import com.consorsbank.module.tapi.grpc.security.SecurityCodeType;
import com.consorsbank.module.tapi.grpc.security.SecurityMarketDataRequest;
import com.consorsbank.module.tapi.grpc.security.SecurityWithStockExchange;
import com.consorsbank.module.tapi.grpc.stock.StockExchange;
import com.consorsbank.module.tapi.observers.MarketDataDataObserver;
import consorsbank.api.SecureMarketDataService;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
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
            String certContent = "-----BEGIN CERTIFICATE-----\n" +
                    "MIIDHDCCAgSgAwIBAgIJAJl/VY/LhDO7MA0GCSqGSIb3DQEBCwUAMDUxCzAJBgNVBAYTAkRFMRIw\n" +
                    "EAYDVQQHEwlOdWVybmJlcmcxEjAQBgNVBAMTCWxvY2FsaG9zdDAeFw0yNTAxMDUwMzI3NTFaFw0y\n" +
                    "NzAxMDUwMzI3NTFaMDUxCzAJBgNVBAYTAkRFMRIwEAYDVQQHEwlOdWVybmJlcmcxEjAQBgNVBAMT\n" +
                    "CWxvY2FsaG9zdDCCASIwDQYJKoZIhvcNAQEBBQADggEPADCCAQoCggEBAKxMakA7wRuU+g+80Ja+\n" +
                    "iW9RVMRFX3E+vY4OCm8ot2jXI+llyzNjbU6RaDmUhMIcepmdwfRDPlFhLKM/cznPFGsKfaJtBLhy\n" +
                    "GQT1Vo75wN4xEfs+egB5qXpDxqO/cZu0CeMajE5A//szZ4jNqtgXOmRxI76bSMpBhhyt1jNgycx4\n" +
                    "5GEd5eikHscqv44pFAdpCjlmtJeLpXrZCvQrE/8vzkAH6PMucnSBG9Pmizig2YN1JO1F3PW1xU8K\n" +
                    "lJEFGrHT0wH7iVbLxnyO+825hvGOYfP6Ga7DHPiWZT+RypCi8vwhIhKyCwI8RRvZUfX47igMrD4b\n" +
                    "XBO2K7tpjvSjwEbDOJUCAwEAAaMvMC0wDAYDVR0TBAUwAwEB/zAdBgNVHQ4EFgQUrsnaPFzvEdo3\n" +
                    "YvEV3BKHMpfkb+IwDQYJKoZIhvcNAQELBQADggEBADzRA6DdLgemJoTjgAKuzTppkRVHSYSVGjBy\n" +
                    "7gjOcmA+Bgm6ulj+oiYc7kGFMdAp+ycObvgkCrfWWoZ3cwMhUsQ49eZg4LtO13Q0zTESOIudMDqb\n" +
                    "ajoze70H0Y6lprTBYQuD5AWgrbROjw+FI0eqQ5haD+VxM9KS/PK8yhDdw5mZKn3FWP6tnjZHDms+\n" +
                    "6cNjqJC4vg5DM+9VZIG2UZxt4ZHbH3zwywtDpSCeiTj4gy4FU+qYsyZQuM0R4uSWhzEgrjbH67AV\n" +
                    "mMzagIdvVSQmgYuQoO9qGjrx8ZrQ+uh1/gd+tRTBL9gYd5XfXXagZ9DXPrsRUWtRifwpOTm4Lusn\n" +
                    "cgQ=\n" +
                    "-----END CERTIFICATE-----";

            String secret = "123456";

            // Initialisiere den SecureMarketDataService
            SecureMarketDataService marketService = new SecureMarketDataService("localhost", 40443, certContent);

            // Login durchführen
            LoginRequest loginRequest = LoginRequest.newBuilder().setSecret(secret).build();
            LoginReply loginReply = marketService.getAccessServiceStub().login(loginRequest);

            if (loginReply.getError() != null && !loginReply.getError().equals(com.consorsbank.module.tapi.grpc.common.Error.getDefaultInstance())) {
                txtOutput.appendText("Login fehlgeschlagen: " + loginReply.getError().getMessage() + "\n");
                return;
            }

            String accessToken = loginReply.getAccessToken();
            txtOutput.appendText("Login erfolgreich! Access-Token erhalten.\n");

            // Eingaben für den SecurityMarketDataRequest
            SecurityCode securityCode = SecurityCode.newBuilder().setCode("710000").setCodeType(SecurityCodeType.WKN).build();
            StockExchange stockExchange = StockExchange.newBuilder().setId("OTC").build();
            SecurityWithStockExchange securityWithStockExchange = SecurityWithStockExchange.newBuilder().setSecurityCode(securityCode).setStockExchange(stockExchange).build();

            SecurityMarketDataRequest request = SecurityMarketDataRequest.newBuilder().setAccessToken(accessToken).setSecurityWithStockexchange(securityWithStockExchange).setCurrency("EUR").build();

            MarketDataDataObserver observer = new MarketDataDataObserver(request, marketService.getSecurityServiceStub());
            observer.onCompleted();

            txtOutput.appendText("Marktdaten-Stream abgeschlossen.\n");

        } catch (Exception e) {
            txtOutput.appendText("Fehler beim Laden der Marktdaten: " + e.getMessage() + "\n");
        }
    }

    @FXML
    private void showAboutDialog(ActionEvent actionEvent) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Über");
        alert.setHeaderText("ConsorsBank Dashboard");
        alert.setContentText("Diese Anwendung ermöglicht den Zugriff auf Marktdaten über die ConsorsBank Trading API.");
        alert.showAndWait();
    }

    @FXML
    private void exitApplication(ActionEvent actionEvent) {
        System.exit(0);
    }
}
