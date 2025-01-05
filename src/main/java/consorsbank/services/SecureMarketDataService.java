package consorsbank.services;

import com.consorsbank.module.tapi.grpc.AccessServiceGrpc;
import com.consorsbank.module.tapi.grpc.SecurityServiceGrpc;
import com.consorsbank.module.tapi.grpc.access.LoginReply;
import com.consorsbank.module.tapi.grpc.access.LoginRequest;
import com.consorsbank.module.tapi.grpc.security.SecurityCode;
import com.consorsbank.module.tapi.grpc.security.SecurityCodeType;
import com.consorsbank.module.tapi.grpc.security.SecurityMarketDataRequest;
import com.consorsbank.module.tapi.grpc.security.SecurityWithStockExchange;
import com.consorsbank.module.tapi.grpc.stock.StockExchange;
import consorsbank.config.SecureMarketDataConfig;
import io.grpc.ManagedChannel;
import io.grpc.netty.shaded.io.grpc.netty.GrpcSslContexts;
import io.grpc.netty.shaded.io.grpc.netty.NettyChannelBuilder;
import io.grpc.stub.StreamObserver;
import org.springframework.stereotype.Service;

import javax.net.ssl.SSLException;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.concurrent.TimeUnit;

@Service
public class SecureMarketDataService {

    private final ManagedChannel channel;
    private final AccessServiceGrpc.AccessServiceBlockingStub accessServiceStub;
    private final SecurityServiceGrpc.SecurityServiceStub securityServiceStub;

    public SecureMarketDataService(SecureMarketDataConfig config) throws SSLException {
        InputStream certInputStream = new ByteArrayInputStream(config.getCertContent().getBytes());

        this.channel = NettyChannelBuilder.forAddress(config.getHost(), config.getPort())
                .negotiationType(io.grpc.netty.shaded.io.grpc.netty.NegotiationType.TLS)
                .sslContext(GrpcSslContexts.forClient().trustManager(certInputStream).build())
                .build();

        this.accessServiceStub = AccessServiceGrpc.newBlockingStub(channel);
        this.securityServiceStub = SecurityServiceGrpc.newStub(channel);
    }

    public String login(String secret) {
        LoginRequest loginRequest = LoginRequest.newBuilder().setSecret(secret).build();
        LoginReply loginReply = accessServiceStub.login(loginRequest);

        if (loginReply.hasError()) {
            throw new IllegalStateException("Login fehlgeschlagen: " + loginReply.getError().getMessage());
        }

        return loginReply.getAccessToken();
    }

    public void streamMarketData(String accessToken, String securityCode, String stockExchangeId, String currency,
                                 StreamObserver<String> outputObserver) {

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
                .setAccessToken(accessToken)
                .setSecurityWithStockexchange(securityWithStockExchange)
                .setCurrency(currency)
                .build();

        securityServiceStub.streamMarketData(request, new StreamObserver<>() {
            @Override
            public void onNext(com.consorsbank.module.tapi.grpc.security.SecurityMarketDataReply reply) {
                outputObserver.onNext(reply.toString());
            }

            @Override
            public void onError(Throwable t) {
                outputObserver.onError(t);
            }

            @Override
            public void onCompleted() {
                outputObserver.onCompleted();
            }
        });
    }

    public void shutdown() throws InterruptedException {
        channel.shutdown().awaitTermination(5, TimeUnit.SECONDS);
    }
}
