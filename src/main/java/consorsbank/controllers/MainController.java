package consorsbank.controllers;

import com.consorsbank.module.tapi.grpc.security.SecurityMarketDataReply;
import consorsbank.services.SecureMarketDataService;
import io.grpc.stub.StreamObserver;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.ToolBar;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import java.io.IOException;

@Controller
public class MainController {

    @FXML
    private Button btnLoadMarketData;

    @FXML
    private ToolBar toolbar;

    @FXML
    private Pane chartContainer; // Platzhalter für das Chart

    private Pane chartPane; // Bereich für das Chart (geladen durch ChartController)

    @FXML
    private TextArea txtOutput;

    @Autowired
    private SecureMarketDataService marketDataService;

    @FXML
    public void initialize() {

        // Toolbar-Button erstellen
        Button loadChartButton = new Button("📊 Load Chart");
        loadChartButton.setStyle("-fx-font-size: 14px;"); // Schriftgröße anpassen
        loadChartButton.setOnAction(event -> loadChart());

        // Button zur Toolbar hinzufügen
        toolbar.getItems().add(loadChartButton);

        btnLoadMarketData.setOnAction(event -> loadMarketData());
    }

    private void loadChart() {
        try {
            // Lade das Chart in den Platzhalter (chartContainer)
            FXMLLoader chartLoader = new FXMLLoader(getClass().getResource("/views/chart.fxml"));
            Pane chartPane = chartLoader.load();

            chartContainer.getChildren().clear(); // Vorherige Inhalte entfernen
            chartContainer.getChildren().add(chartPane); // Chart hinzufügen
            System.out.println("Chart wurde erfolgreich geladen.");
        } catch (IOException e) {
            e.printStackTrace();
        }

//        try {
//            // Lade die Dummy-View in den Platzhalter
//            FXMLLoader loader = new FXMLLoader(getClass().getResource("/views/dummy.fxml"));
//            Pane dummyPane = loader.load();
//
//            chartContainer.getChildren().clear(); // Vorherige Inhalte entfernen
//            chartContainer.getChildren().add(dummyPane); // Dummy-View hinzufügen
//            System.out.println("Dummy View wurde erfolgreich geladen.");
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
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
