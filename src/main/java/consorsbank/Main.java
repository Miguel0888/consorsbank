package consorsbank;

import consorsbank.util.SpringFXMLLoader;
import javafx.application.Application;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ApplicationContext;

public class Main extends Application {

    private ApplicationContext springContext;

    @Override
    public void init() throws Exception {
        // Starte Spring Context
        springContext = new SpringApplicationBuilder(ConsorsBankApplication.class).run();
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        // Lade FXML über SpringFXMLLoader
        SpringFXMLLoader fxmlLoader = springContext.getBean(SpringFXMLLoader.class);
        Parent root = fxmlLoader.load("/views/main.fxml").load();

        primaryStage.setTitle("ConsorsBank Dashboard");
        primaryStage.setScene(new Scene(root));
        primaryStage.setMaximized(true);
        primaryStage.show();
    }

    @Override
    public void stop() throws Exception {
        // Schließe Spring Context beim Beenden der Anwendung
//        springContext.close(); // Todo: Fix this!
    }

    public static void main(String[] args) {
        launch(args);
    }
}
