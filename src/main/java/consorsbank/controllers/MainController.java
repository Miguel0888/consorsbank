package consorsbank.controllers;

import com.consorsbank.module.tapi.grpc.security.SecurityMarketDataReply;
import consorsbank.services.SecureMarketDataService;
import io.grpc.stub.StreamObserver;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class MainController {

    @FXML
    private Button btnLoadMarketData;

    @FXML
    private TextArea txtOutput;

    @Autowired
    private SecureMarketDataService marketDataService;

    @FXML
    public void initialize() {
        btnLoadMarketData.setOnAction(event -> loadMarketData());
    }

    private void loadMarketData() {
        txtOutput.setText("Marktdaten werden geladen...\n");

        String securityCode = "710000"; // Beispielcode
        String stockExchangeId = "OTC";
        String currency = "EUR";

        marketDataService.streamMarketData(securityCode, stockExchangeId, currency, new StreamObserver<>() {
            @Override
            public void onNext(SecurityMarketDataReply reply) {
                javafx.application.Platform.runLater(() -> txtOutput.appendText(reply.toString() + "\n"));
            }

            @Override
            public void onError(Throwable t) {
                javafx.application.Platform.runLater(() -> txtOutput.appendText("Fehler: " + t.getMessage() + "\n"));
            }

            @Override
            public void onCompleted() {
                javafx.application.Platform.runLater(() -> txtOutput.appendText("Marktdaten-Stream abgeschlossen.\n"));
            }
        });
    }
}
