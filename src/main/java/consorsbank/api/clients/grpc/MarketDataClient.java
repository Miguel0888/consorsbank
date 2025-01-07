package consorsbank.api.clients.grpc;

import com.consorsbank.module.tapi.grpc.AccessServiceGrpc;
import com.consorsbank.module.tapi.grpc.SecurityServiceGrpc;
import com.consorsbank.module.tapi.grpc.access.LoginReply;
import com.consorsbank.module.tapi.grpc.access.LoginRequest;
import com.consorsbank.module.tapi.grpc.security.SecurityMarketDataReply;
import com.consorsbank.module.tapi.grpc.security.SecurityMarketDataRequest;
import com.consorsbank.module.tapi.grpc.security.SecurityWithStockExchange;
import com.consorsbank.module.tapi.grpc.security.SecurityCode;
import com.consorsbank.module.tapi.grpc.security.SecurityCodeType;
import com.consorsbank.module.tapi.grpc.stock.StockExchange;
import consorsbank.config.SecureMarketDataConfig;
import io.grpc.ManagedChannel;
import io.grpc.netty.shaded.io.grpc.netty.GrpcSslContexts;
import io.grpc.netty.shaded.io.grpc.netty.NettyChannelBuilder;
import io.grpc.stub.StreamObserver;
import org.springframework.stereotype.Component;

import javax.net.ssl.SSLException;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.concurrent.TimeUnit;

@Component
public class MarketDataClient {

    private final ManagedChannel channel;
    private final AccessServiceGrpc.AccessServiceBlockingStub accessServiceStub;
    private final SecurityServiceGrpc.SecurityServiceStub securityServiceStub;
    private String accessToken;

    public MarketDataClient(SecureMarketDataConfig config) throws SSLException {
        InputStream certInputStream = new ByteArrayInputStream(config.getCertContent().getBytes());

        this.channel = NettyChannelBuilder.forAddress(config.getHost(), config.getPort())
                .negotiationType(io.grpc.netty.shaded.io.grpc.netty.NegotiationType.TLS)
                .sslContext(GrpcSslContexts.forClient().trustManager(certInputStream).build())
                .build();

        this.accessServiceStub = AccessServiceGrpc.newBlockingStub(channel);
        this.securityServiceStub = SecurityServiceGrpc.newStub(channel);

        performLogin(config.getSecret());
    }

    private void performLogin(String secret) {
        LoginRequest loginRequest = LoginRequest.newBuilder().setSecret(secret).build();
        LoginReply loginReply = accessServiceStub.login(loginRequest);

        if (loginReply.hasError()) {
            throw new IllegalStateException("Login fehlgeschlagen: " + loginReply.getError().getMessage());
        }

        this.accessToken = loginReply.getAccessToken();
    }

    public void streamMarketData(String securityCode, String stockExchangeId, String currency, StreamObserver<SecurityMarketDataReply> observer) {
        SecurityCode securityCodeObj = SecurityCode.newBuilder()
                .setCode(securityCode)
                .setCodeType(SecurityCodeType.WKN)
                .build();

        StockExchange stockExchange = StockExchange.newBuilder()
                .setId(stockExchangeId)
                .build();

        SecurityWithStockExchange securityWithStockExchange = SecurityWithStockExchange.newBuilder()
                .setSecurityCode(securityCodeObj)
                .setStockExchange(stockExchange)
                .build();

        SecurityMarketDataRequest request = SecurityMarketDataRequest.newBuilder()
                .setAccessToken(this.accessToken)
                .setSecurityWithStockexchange(securityWithStockExchange)
                .setCurrency(currency)
                .build();

        securityServiceStub.streamMarketData(request, observer);
    }

    public void shutdown() throws InterruptedException {
        channel.shutdown().awaitTermination(5, TimeUnit.SECONDS);
    }
}
