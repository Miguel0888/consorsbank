package consorsbank;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {
        // Lade die master.fxml-Datei
        FXMLLoader loader = new FXMLLoader(getClass().getResource("views/master.fxml"));
        Parent root = loader.load();

        // Setze den Titel und die Scene
        primaryStage.setTitle("ConsorsBank");
        primaryStage.setScene(new Scene(root));
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
