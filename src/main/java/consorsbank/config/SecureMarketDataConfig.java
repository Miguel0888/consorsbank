package consorsbank.config;

public class SecureMarketDataConfig {
    private final String host;
    private final int port;
    private final String certContent;

    public SecureMarketDataConfig(String host, int port, String certContent) {
        this.host = host;
        this.port = port;
        this.certContent = certContent;
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
}
