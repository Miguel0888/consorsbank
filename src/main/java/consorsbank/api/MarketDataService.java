package consorsbank.api;

import com.consorsbank.module.tapi.grpc.security.SecurityMarketDataRequest;
import com.consorsbank.module.tapi.grpc.security.SecurityWithStockExchange;
import com.consorsbank.module.tapi.grpc.security.SecurityCode;
import com.consorsbank.module.tapi.grpc.security.SecurityCodeType;
import com.consorsbank.module.tapi.grpc.SecurityServiceGrpc;
import com.consorsbank.module.tapi.grpc.stock.StockExchange;
import com.consorsbank.module.tapi.observers.MarketDataDataObserver;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;

public class MarketDataService {

    private final ManagedChannel channel;
    private final SecurityServiceGrpc.SecurityServiceStub securityServiceStub;

    public MarketDataService(String host, int port) {
        // Create the gRPC channel
        this.channel = ManagedChannelBuilder.forAddress(host, port)
                .usePlaintext() // Disable TLS for simplicity
                .build();

        // Initialize the SecurityServiceStub
        this.securityServiceStub = SecurityServiceGrpc.newStub(channel);
    }

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


    /**
     * Shuts down the gRPC channel.
     */
    public void close() {
        channel.shutdown();
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

    public SecurityServiceGrpc.SecurityServiceStub getSecurityServiceStub() {
        return this.securityServiceStub;
    }

}
