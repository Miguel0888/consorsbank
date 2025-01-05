package consorsbank;

import consorsbank.controllers.MainController;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ConsorsBankApplication implements CommandLineRunner {

    private final MainController mainController;

    public ConsorsBankApplication(MainController mainController) {
        this.mainController = mainController;
    }

    public static void main(String[] args) {
        SpringApplication.run(ConsorsBankApplication.class, args);
    }

    @Override
    public void run(String... args) {
        System.out.println("Starte Aktionen im MainController...");
        mainController.executeActions();
    }
}
