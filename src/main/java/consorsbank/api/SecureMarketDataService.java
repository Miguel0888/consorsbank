package consorsbank.api;

import io.grpc.ManagedChannel;
import io.grpc.netty.shaded.io.grpc.netty.GrpcSslContexts;
import io.grpc.netty.shaded.io.grpc.netty.NettyChannelBuilder;
import io.grpc.netty.shaded.io.grpc.netty.NegotiationType;

import javax.net.ssl.SSLException;
import java.io.File;

public class SecureMarketDataService {
    private final ManagedChannel channel;

    /**
     * Konstruktor für den SecureMarketDataService
     *
     * @param host             Hostname des gRPC-Servers
     * @param port             Port des gRPC-Servers
     * @param trustCertPath    Pfad zum Root-Zertifikat
     * @throws SSLException    Falls SSL-Initialisierung fehlschlägt
     */
    public SecureMarketDataService(String host, int port, String trustCertPath) throws SSLException {
        File certFile = new File(trustCertPath);
        if (!certFile.exists() || !certFile.isFile()) {
            throw new IllegalArgumentException("Das Zertifikat unter " + trustCertPath + " wurde nicht gefunden.");
        }

        this.channel = NettyChannelBuilder.forAddress(host, port)
                .negotiationType(NegotiationType.TLS) // HTTP/2 mit TLS
                .sslContext(GrpcSslContexts.forClient().trustManager(certFile).build()) // Zertifikat laden
                .build();
    }

    public ManagedChannel getChannel() {
        return channel;
    }

    public void close() {
        if (channel != null) {
            channel.shutdown();
        }
    }
}
