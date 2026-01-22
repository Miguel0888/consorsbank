package consorsbank.config.persistence;

import consorsbank.config.SecureMarketDataConfig;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.Base64;
import java.util.Properties;

@Component
public class UserHomeSecureMarketDataConfigStore implements SecureMarketDataConfigStore {

    private static final String DIRECTORY_NAME = ".consorsbank";
    private static final String FILE_NAME = "secure-market-data.properties";

    private static final String KEY_HOST = "host";
    private static final String KEY_PORT = "port";
    private static final String KEY_SECRET_BASE64 = "secret.base64";
    private static final String KEY_CERT_CONTENT_BASE64 = "certContent.base64";

    @Override
    public SecureMarketDataConfig loadOrNull() {
        Path filePath = configFilePath();
        if (!Files.exists(filePath)) {
            return null;
        }

        Properties properties = new Properties();
        try (InputStream in = Files.newInputStream(filePath, StandardOpenOption.READ)) {
            properties.load(in);
        } catch (IOException e) {
            throw new IllegalStateException("Failed to read config file: " + filePath, e);
        }

        String host = properties.getProperty(KEY_HOST);
        String portRaw = properties.getProperty(KEY_PORT);
        String secretB64 = properties.getProperty(KEY_SECRET_BASE64);
        String certB64 = properties.getProperty(KEY_CERT_CONTENT_BASE64);

        if (isBlank(host) || isBlank(portRaw) || isBlank(secretB64) || isBlank(certB64)) {
            return null;
        }

        int port;
        try {
            port = Integer.parseInt(portRaw.trim());
        } catch (NumberFormatException e) {
            return null;
        }

        String secret = decodeBase64ToString(secretB64);
        String certContent = decodeBase64ToString(certB64);

        if (isBlank(secret) || isBlank(certContent)) {
            return null;
        }

        return new SecureMarketDataConfig(host.trim(), port, certContent, secret);
    }

    @Override
    public void save(SecureMarketDataConfig config) {
        ensureDirectoryExists();

        Properties properties = new Properties();
        properties.setProperty(KEY_HOST, safe(config.getHost()));
        properties.setProperty(KEY_PORT, String.valueOf(config.getPort()));
        properties.setProperty(KEY_SECRET_BASE64, encodeStringToBase64(config.getSecret()));
        properties.setProperty(KEY_CERT_CONTENT_BASE64, encodeStringToBase64(config.getCertContent()));

        Path filePath = configFilePath();
        try (OutputStream out = Files.newOutputStream(
                filePath,
                StandardOpenOption.CREATE,
                StandardOpenOption.TRUNCATE_EXISTING,
                StandardOpenOption.WRITE
        )) {
            properties.store(out, "Consorsbank ActiveTrader Trading-API configuration");
        } catch (IOException e) {
            throw new IllegalStateException("Failed to write config file: " + filePath, e);
        }
    }

    private void ensureDirectoryExists() {
        Path dirPath = configDirectoryPath();
        try {
            Files.createDirectories(dirPath);
        } catch (IOException e) {
            throw new IllegalStateException("Failed to create config directory: " + dirPath, e);
        }
    }

    private Path configFilePath() {
        return configDirectoryPath().resolve(FILE_NAME);
    }

    private Path configDirectoryPath() {
        String userHome = System.getProperty("user.home");
        return Paths.get(userHome).resolve(DIRECTORY_NAME);
    }

    private String encodeStringToBase64(String value) {
        byte[] bytes = safe(value).getBytes(StandardCharsets.UTF_8);
        return Base64.getEncoder().encodeToString(bytes);
    }

    private String decodeBase64ToString(String base64) {
        try {
            byte[] decoded = Base64.getDecoder().decode(safe(base64));
            return new String(decoded, StandardCharsets.UTF_8);
        } catch (IllegalArgumentException e) {
            return "";
        }
    }

    private boolean isBlank(String value) {
        return value == null || value.trim().isEmpty();
    }

    private String safe(String value) {
        return value == null ? "" : value;
    }
}
