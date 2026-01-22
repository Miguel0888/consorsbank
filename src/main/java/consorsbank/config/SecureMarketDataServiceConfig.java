package consorsbank.config;

import consorsbank.config.persistence.SecureMarketDataConfigStore;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;

@Configuration
public class SecureMarketDataServiceConfig {

    private final ResourceLoader resourceLoader;
    private final SecureMarketDataConfigStore configStore;

    public SecureMarketDataServiceConfig(ResourceLoader resourceLoader, SecureMarketDataConfigStore configStore) {
        this.resourceLoader = resourceLoader;
        this.configStore = configStore;
    }

    @Value("${secure-market-data.host}")
    private String host;

    @Value("${secure-market-data.port}")
    private int port;

    @Value("${secure-market-data.secret}")
    private String secret;

    @Value("${secure-market-data.cert-content:}")
    private String certContent;

    @Value("${secure-market-data.cert-file:roots.pem}")
    private String certFile;

    @Bean
    public SecureMarketDataConfig secureMarketDataConfig() throws IOException {
        SecureMarketDataConfig storedConfig = configStore.loadOrNull();
        if (storedConfig != null) {
            return storedConfig;
        }

        String effectiveCertContent;
        if (certContent == null || certContent.isEmpty()) {
            Resource resource = resourceLoader.getResource("classpath:" + certFile);
            if (!resource.exists()) {
                throw new IllegalArgumentException("Zertifikatsdatei nicht gefunden: " + certFile);
            }
            byte[] bytes = Files.readAllBytes(Paths.get(resource.getURI()));
            effectiveCertContent = new String(bytes, StandardCharsets.UTF_8);
        } else {
            effectiveCertContent = certContent;
        }

        return new SecureMarketDataConfig(host, port, effectiveCertContent, secret);
    }
}
