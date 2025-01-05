package consorsbank.api;

import com.consorsbank.module.tapi.grpc.SecurityServiceGrpc;
import com.consorsbank.module.tapi.grpc.security.SecurityCode;
import com.consorsbank.module.tapi.grpc.security.SecurityCodeType;
import com.consorsbank.module.tapi.grpc.security.SecurityMarketDataRequest;
import com.consorsbank.module.tapi.grpc.security.SecurityWithStockExchange;
import com.consorsbank.module.tapi.grpc.stock.StockExchange;
import com.consorsbank.module.tapi.observers.MarketDataDataObserver;
import io.grpc.ManagedChannel;
import io.grpc.netty.shaded.io.grpc.netty.NettyChannelBuilder;
import io.grpc.netty.shaded.io.netty.handler.ssl.SslContext;
import io.grpc.netty.shaded.io.netty.handler.ssl.SslContextBuilder;

import javax.net.ssl.SSLException;
import java.io.InputStream;

public class SecureMarketDataService {

    private final ManagedChannel channel;
    private final SecurityServiceGrpc.SecurityServiceStub securityServiceStub;

    public SecureMarketDataService(String host, int port, String certResourcePath) throws SSLException {
        // Lade das Zertifikat aus dem Ressourcenordner
        InputStream certInputStream = getClass().getClassLoader().getResourceAsStream(certResourcePath);
        if (certInputStream == null) {
            throw new IllegalArgumentException("Certificate file not found: " + certResourcePath);
        }

        // Erstelle den SslContext mit dem geladenen Zertifikat
        SslContext sslContext = SslContextBuilder.forClient()
                .trustManager(certInputStream) // Zertifikat einbinden
                .build();

        // Erstelle den gRPC-Kanal mit TLS
        // Kanal mit Netty-TCNATIVE und HTTP/2 Unterstützung
        System.setProperty("io.grpc.netty.shaded.io.netty.handler.ssl.debug", "all");
        this.channel = NettyChannelBuilder.forAddress(host, port)
                .sslContext(sslContext) // TLS aktivieren
                .negotiationType(io.grpc.netty.shaded.io.grpc.netty.NegotiationType.TLS) // Aktiviert HTTP/2
                .build();

        // Initialisiere den SecurityServiceStub
        this.securityServiceStub = SecurityServiceGrpc.newStub(channel);
    }

    public ManagedChannel getChannel() {
        return channel;
    }

    public void close() {
        channel.shutdown();
    }

    public SecurityServiceGrpc.SecurityServiceStub getSecurityServiceStub() {
        return this.securityServiceStub;
    }

    ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////

    /**
     * Starts a market data stream.
     *
     * @param accessToken The API access token.
     * @param securityCodeStr The security code (e.g., WKN or ISIN).
     * @param securityCodeType The type of the security code.
     * @param stockExchangeId The stock exchange ID.
     * @param currency The desired currency (e.g., "USD").
     * @return A MarketDataDataObserver instance for handling the stream.
     */
    public MarketDataDataObserver streamMarketData(
            String accessToken,
            String securityCodeStr,
            SecurityCodeType securityCodeType,
            String stockExchangeId,
            String currency) {

        // Erstellen eines SecurityCode-Objekts
        SecurityCode securityCode = SecurityCode.newBuilder()
                .setCode(securityCodeStr) // Setze den Security-Code (z. B. WKN oder ISIN)
                .setCodeType(securityCodeType) // Setze den Code-Typ (z. B. WKN, ISIN)
                .build();

        // Erstellen eines StockExchange-Objekts
        StockExchange stockExchange = StockExchange.newBuilder()
                .setId(stockExchangeId) // Setze die Stock Exchange ID
                .build();

        // Erstellen des SecurityWithStockExchange-Objekts
        SecurityWithStockExchange securityWithStockExchange = SecurityWithStockExchange.newBuilder()
                .setSecurityCode(securityCode) // Hier wird das SecurityCode-Objekt übergeben
                .setStockExchange(stockExchange) // Hier wird das StockExchange-Objekt übergeben
                .build();

        // Build the SecurityMarketDataRequest
        SecurityMarketDataRequest request = SecurityMarketDataRequest.newBuilder()
                .setAccessToken(accessToken)
                .setSecurityWithStockexchange(securityWithStockExchange)
                .setCurrency(currency == null ? "" : currency)
                .build();

        // Create and return the MarketDataDataObserver
        return new MarketDataDataObserver(request, securityServiceStub);
    }

    public SecurityMarketDataRequest createMarketDataRequest(
            String accessToken,
            String securityCodeStr,
            SecurityCodeType securityCodeType,
            String stockExchangeId,
            String currency
    ) {
        // Erstellen eines SecurityCode-Objekts
        SecurityCode securityCode = SecurityCode.newBuilder()
                .setCode(securityCodeStr) // Setze den Security-Code (z. B. WKN oder ISIN)
                .setCodeType(securityCodeType) // Setze den Code-Typ (z. B. WKN, ISIN)
                .build();

        // Erstellen eines StockExchange-Objekts
        StockExchange stockExchange = StockExchange.newBuilder()
                .setId(stockExchangeId) // Setze die Stock Exchange ID
                .build();

        // Erstellen des SecurityWithStockExchange-Objekts
        SecurityWithStockExchange securityWithStockExchange = SecurityWithStockExchange.newBuilder()
                .setSecurityCode(securityCode) // Hier wird das SecurityCode-Objekt übergeben
                .setStockExchange(stockExchange) // Hier wird das StockExchange-Objekt übergeben
                .build();

        // Build the SecurityMarketDataRequest
        return SecurityMarketDataRequest.newBuilder()
                .setAccessToken(accessToken)
                .setSecurityWithStockexchange(securityWithStockExchange)
                .setCurrency(currency == null ? "" : currency)
                .build();
    }
}
