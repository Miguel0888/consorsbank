package consorsbank.controllers;

import com.consorsbank.module.tapi.grpc.security.SecurityMarketDataReply;
import consorsbank.services.SecureMarketDataService;
import io.grpc.stub.StreamObserver;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextArea;
import javafx.scene.control.ToolBar;
import javafx.scene.layout.BorderPane;
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

    @Autowired
    private SecureMarketDataService marketDataService;

    @FXML
    public void initialize() {
        // DAX-Werte in das Dropdown hinzufügen
        List<String> daxWkns = Arrays.asList("710000", "846900", "578580", "823212", "514000");
        wknDropdown.getItems().addAll(daxWkns);

        // Toolbar-Button erstellen
        Button loadChartButton = new Button("📊 Load Chart");
        loadChartButton.setStyle("-fx-font-size: 14px;"); // Schriftgröße anpassen
        loadChartButton.setOnAction(event -> loadChart());
        // Standardmäßig keine Auswahl
        wknDropdown.setValue(null);

        // Button zur Toolbar hinzufügen
        toolbar.getItems().add(loadChartButton);

        btnLoadMarketData.setOnAction(event -> loadMarketData());
    }

    private void loadChart() {
        try {
            FXMLLoader chartLoader = new FXMLLoader(getClass().getResource("/views/chart.fxml"));
            Pane chartPane = chartLoader.load();

            chartContainer.getChildren().clear();
            chartContainer.getChildren().add(chartPane); // StackPane passt sich automatisch an
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void loadMarketData() {
        String securityCode = wknDropdown.getValue();

        if (securityCode == null) {
            txtOutput.setText("Bitte eine WKN auswählen.\n");
            return;
        }

        txtOutput.setText("Marktdaten werden für WKN " + securityCode + " geladen...\n");

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
