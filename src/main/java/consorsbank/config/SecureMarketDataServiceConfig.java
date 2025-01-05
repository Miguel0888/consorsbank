package consorsbank.config;

import consorsbank.services.SecureMarketDataService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

@Configuration
public class SecureMarketDataServiceConfig {

    private final ResourceLoader resourceLoader;

    public SecureMarketDataServiceConfig(ResourceLoader resourceLoader) {
        this.resourceLoader = resourceLoader;
    }

    @Bean
    public SecureMarketDataConfig secureMarketDataConfig() throws IOException {
        // Lade die Datei roots.pem aus den Ressourcen
        Resource resource = resourceLoader.getResource("classpath:roots.pem");

        // Lese den Inhalt der Datei
        String certContent = Files.readString(Path.of(resource.getURI()));

        // Gebe den Inhalt auf der Konsole aus
        System.out.println("Inhalt der roots.pem:");
        System.out.println(certContent);

        // Erstelle die Konfiguration
        return new SecureMarketDataConfig("localhost", 40443, certContent, "123456");
    }
}
