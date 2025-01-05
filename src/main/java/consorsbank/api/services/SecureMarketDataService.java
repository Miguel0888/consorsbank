package consorsbank.api.services;

package com.consorsbank.services;

import com.consorsbank.module.tapi.grpc.SecurityServiceGrpc;
import com.consorsbank.module.tapi.grpc.security.SecurityMarketDataReply;
import com.consorsbank.module.tapi.grpc.security.SecurityMarketDataRequest;
import com.consorsbank.module.tapi.grpc.security.SecurityWithStockExchange;
import io.grpc.ManagedChannel;
import io.grpc.netty.shaded.io.grpc.netty.GrpcSslContexts;
import io.grpc.netty.shaded.io.grpc.netty.NettyChannelBuilder;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import javax.annotation.PreDestroy;
import javax.net.ssl.SSLException;
import java.io.ByteArrayInputStream;
import java.io.InputStream;

@Service
public class SecureMarketDataService {

    private final ManagedChannel channel;
    private final SecurityServiceGrpc.SecurityServiceBlockingStub securityServiceStub;

    public SecureMarketDataService(
            @Value("${grpc.server.host}") String host,
            @Value("${grpc.server.port}") int port,
            @Value("${grpc.server.cert}") String certContent,
            @Value("${grpc.server.secret}") String secret) throws SSLException {
        // Initialisiere den gRPC-Kanal mit Zertifikat
        InputStream certInputStream = new ByteArrayInputStream(certContent.getBytes());
        this.channel = NettyChannelBuilder.forAddress(host, port)
                .negotiationType(io.grpc.netty.shaded.io.grpc.netty.NegotiationType.TLS)
                .sslContext(GrpcSslContexts.forClient().trustManager(certInputStream).build())
                .build();

        this.securityServiceStub = SecurityServiceGrpc.newBlockingStub(channel);
    }

    public SecurityMarketDataReply getMarketData(String securityCode, String stockExchange) {
        // Erstelle das Anfrageobjekt
        SecurityWithStockExchange securityWithStockExchange = SecurityWithStockExchange.newBuilder()
                .setCode(securityCode)
                .setType("WKN") // Beispielwert, anpassen je nach Bedarf
                .setStockExchange(stockExchange)
                .build();

        SecurityMarketDataRequest request = SecurityMarketDataRequest.newBuilder()
                .setAccessToken("123456") // Dein Secret
                .setSecurityWithStockexchange(securityWithStockExchange)
                .build();

        // Sende die Anfrage und erhalte die Antwort
        return securityServiceStub.getSecurityMarketData(request);
    }

    @PreDestroy
    public void shutdown() {
        // Schließe den gRPC-Kanal beim Beenden des Services
        channel.shutdown();
    }
}
