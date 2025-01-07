package consorsbank.controllers;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;
import org.springframework.stereotype.Controller;

@Controller
public class DummyController {

    @FXML
    private Pane dummyContainer;

    @FXML
    private Label dummyLabel;

    @FXML
    public void initialize() {
        dummyLabel.setText("Dummy View Loaded Successfully!");
        System.out.println("DummyController initialized");
    }
}
