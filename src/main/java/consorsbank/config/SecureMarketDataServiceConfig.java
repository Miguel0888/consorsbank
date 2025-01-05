package consorsbank.config;

import org.springframework.beans.factory.annotation.Value;
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

    @Value("${secure-market-data.host}")
    private String host;

    @Value("${secure-market-data.port}")
    private int port;

    @Value("${secure-market-data.secret}")
    private String secret;

    @Value("${secure-market-data.cert-content:}") // Optional, leerer String als Default
    private String certContent;

    @Value("${secure-market-data.cert-file:roots.pem}") // Default auf roots.pem in classpath
    private String certFile;

    @Bean
    public SecureMarketDataConfig secureMarketDataConfig() throws IOException {
        String effectiveCertContent;

        if (certContent == null || certContent.isEmpty()) {
            // Zertifikat aus der Datei laden
            Resource resource = resourceLoader.getResource("classpath:" + certFile);
            if (!resource.exists()) {
                throw new IllegalArgumentException("Zertifikatsdatei nicht gefunden: " + certFile);
            }
            effectiveCertContent = Files.readString(Path.of(resource.getURI()));
        } else {
            // Zertifikat direkt aus der YAML-Datei verwenden
            effectiveCertContent = certContent;
        }

        // Ausgabe des Zertifikats zur Überprüfung
        System.out.println("Inhalt des Zertifikats:");
        System.out.println(effectiveCertContent);

        // Rückgabe der Konfiguration
        return new SecureMarketDataConfig(host, port, effectiveCertContent, secret);
    }
}
