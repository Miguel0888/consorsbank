package consorsbank.controllers.dialogs;

import consorsbank.config.SecureMarketDataConfig;
import javafx.event.ActionEvent;
import javafx.geometry.Insets;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.stage.FileChooser;
import javafx.stage.Window;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.util.Optional;

public final class TradingApiSettingsDialog {

    private final Dialog<SecureMarketDataConfig> dialog;
    private final TextField hostField;
    private final TextField portField;
    private final PasswordField secretField;
    private final Label certFileLabel;

    private String certContent;

    public TradingApiSettingsDialog(Window owner, SecureMarketDataConfig initialConfig) {
        this.dialog = new Dialog<SecureMarketDataConfig>();
        this.dialog.setTitle("Trading-API Einstellungen");
        this.dialog.setHeaderText("ActiveTrader Trading-API konfigurieren");
        this.dialog.initOwner(owner);

        ButtonType saveButtonType = new ButtonType("Speichern", ButtonBar.ButtonData.OK_DONE);
        this.dialog.getDialogPane().getButtonTypes().addAll(saveButtonType, ButtonType.CANCEL);

        this.hostField = new TextField(defaultIfBlank(initialConfig.getHost(), "localhost"));
        this.portField = new TextField(String.valueOf(defaultIfBlankPort(initialConfig.getPort(), 40443)));
        this.secretField = new PasswordField();
        this.secretField.setText(defaultIfBlank(initialConfig.getSecret(), ""));

        this.certContent = defaultIfBlank(initialConfig.getCertContent(), "");
        this.certFileLabel = new Label(certContent.isEmpty() ? "(keine Datei gewählt)" : "(vorhanden)");

        GridPane grid = new GridPane();
        grid.setHgap(10);
        grid.setVgap(10);
        grid.setPadding(new Insets(15, 15, 15, 15));

        int row = 0;
        grid.add(new Label("Host"), 0, row);
        grid.add(hostField, 1, row++);

        grid.add(new Label("Port"), 0, row);
        grid.add(portField, 1, row++);

        grid.add(new Label("Secret"), 0, row);
        grid.add(secretField, 1, row++);

        Button chooseCertButton = new Button("roots.pem auswählen...");
        chooseCertButton.setOnAction(this::onChooseCert);

        grid.add(new Label("Trust-Zertifikat"), 0, row);
        grid.add(chooseCertButton, 1, row++);
        grid.add(certFileLabel, 1, row++);

        Label hint = new Label("Hinweis: Änderungen werden nach einem Neustart der Anwendung wirksam.");
        hint.setWrapText(true);
        grid.add(hint, 0, row, 2, 1);

        dialog.getDialogPane().setContent(grid);

        dialog.setResultConverter(buttonType -> {
            if (!saveButtonType.equals(buttonType)) {
                return null;
            }
            return buildConfigOrShowValidationError();
        });

        Button saveButton = (Button) dialog.getDialogPane().lookupButton(saveButtonType);
        saveButton.addEventFilter(ActionEvent.ACTION, event -> {
            SecureMarketDataConfig result = buildConfigOrShowValidationError();
            if (result == null) {
                event.consume();
            }
        });
    }

    public Optional<SecureMarketDataConfig> showAndWait() {
        return dialog.showAndWait();
    }

    private void onChooseCert(ActionEvent event) {
        FileChooser chooser = new FileChooser();
        chooser.setTitle("roots.pem auswählen");
        chooser.getExtensionFilters().add(new FileChooser.ExtensionFilter("PEM (*.pem)", "*.pem"));
        File selected = chooser.showOpenDialog(dialog.getDialogPane().getScene().getWindow());
        if (selected == null) {
            return;
        }

        try {
            byte[] bytes = Files.readAllBytes(selected.toPath());
            this.certContent = new String(bytes, StandardCharsets.UTF_8);
            this.certFileLabel.setText(selected.getAbsolutePath());
        } catch (IOException e) {
            showError("Zertifikat konnte nicht gelesen werden", e.getMessage());
        }
    }

    private SecureMarketDataConfig buildConfigOrShowValidationError() {
        String host = safeTrim(hostField.getText());
        String portRaw = safeTrim(portField.getText());
        String secret = safeTrim(secretField.getText());

        if (host.isEmpty()) {
            showError("Ungültige Eingabe", "Host darf nicht leer sein.");
            return null;
        }

        int port;
        try {
            port = Integer.parseInt(portRaw);
        } catch (NumberFormatException e) {
            showError("Ungültige Eingabe", "Port muss eine Zahl sein.");
            return null;
        }

        if (port <= 0 || port > 65535) {
            showError("Ungültige Eingabe", "Port muss zwischen 1 und 65535 liegen.");
            return null;
        }

        if (secret.isEmpty()) {
            showError("Ungültige Eingabe", "Secret darf nicht leer sein.");
            return null;
        }

        if (safeTrim(certContent).isEmpty()) {
            showError("Ungültige Eingabe", "Bitte roots.pem auswählen (Export aus ActiveTrader).");
            return null;
        }

        return new SecureMarketDataConfig(host, port, certContent, secret);
    }

    private void showError(String title, String message) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle(title);
        alert.setHeaderText(title);
        alert.setContentText(message);
        alert.initOwner(dialog.getDialogPane().getScene().getWindow());
        alert.showAndWait();
    }

    private String safeTrim(String value) {
        return value == null ? "" : value.trim();
    }

    private String defaultIfBlank(String value, String fallback) {
        return safeTrim(value).isEmpty() ? fallback : safeTrim(value);
    }

    private int defaultIfBlankPort(int value, int fallback) {
        return value <= 0 ? fallback : value;
    }
}
