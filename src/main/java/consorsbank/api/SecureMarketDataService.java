package consorsbank.api;

import io.grpc.ManagedChannel;
import io.grpc.netty.shaded.io.grpc.netty.GrpcSslContexts;
import io.grpc.netty.shaded.io.grpc.netty.NettyChannelBuilder;
import io.grpc.netty.shaded.io.grpc.netty.NegotiationType;

import javax.net.ssl.SSLException;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.InputStream;
import java.util.concurrent.TimeUnit;

public class SecureMarketDataService {
    private final ManagedChannel channel;

    /**
     * Konstruktor für den SecureMarketDataService
     *
     * @param host             Hostname des gRPC-Servers
     * @param port             Port des gRPC-Servers
     * @param certContent       Root-Zertifikat
     * @throws SSLException    Falls SSL-Initialisierung fehlschlägt
     */
    public SecureMarketDataService(String host, int port, String certContent) throws SSLException {
//        File certFile = new File(trustCertPath);
        InputStream certInputStream = new ByteArrayInputStream(certContent.getBytes());

        this.channel = NettyChannelBuilder.forAddress(host, port)
                .negotiationType(NegotiationType.TLS) // HTTP/2 mit TLS
                .sslContext(GrpcSslContexts.forClient().trustManager(certInputStream).build()) // Zertifikat laden
                .build();
    }

    public ManagedChannel getChannel() {
        return channel;
    }

    public void close() throws InterruptedException {
        channel.shutdown().awaitTermination(5, TimeUnit.SECONDS);
    }
}
