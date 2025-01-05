package consorsbank.config;

public class SecureMarketDataConfig {
    private final String host;
    private final int port;
    private final String certContent;
    private final String secret;

    public SecureMarketDataConfig(String host, int port, String certContent, String secret) {
        this.host = host;
        this.port = port;
        this.certContent = certContent;
        this.secret = secret;
    }

    public String getHost() {
        return host;
    }

    public int getPort() {
        return port;
    }

    public String getCertContent() {
        return certContent;
    }

    public String getSecret() {
        return secret;
    }
}
