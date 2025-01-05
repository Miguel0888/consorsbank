package consorsbank.api;

import com.consorsbank.module.tapi.grpc.AccessServiceGrpc;
import com.consorsbank.module.tapi.grpc.SecurityServiceGrpc;
import io.grpc.ManagedChannel;
import io.grpc.netty.shaded.io.grpc.netty.GrpcSslContexts;
import io.grpc.netty.shaded.io.grpc.netty.NegotiationType;
import io.grpc.netty.shaded.io.grpc.netty.NettyChannelBuilder;

import javax.net.ssl.SSLException;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;

public class SecureMarketDataService {

    private final ManagedChannel channel;
    private final AccessServiceGrpc.AccessServiceBlockingStub accessServiceStub;
    private final SecurityServiceGrpc.SecurityServiceStub securityServiceStub;

    public SecureMarketDataService(String host, int port, Object certSource) throws SSLException {
        InputStream certStream = resolveCertificate(certSource);
        this.channel = initChannel(host, port, certStream);
        this.accessServiceStub = AccessServiceGrpc.newBlockingStub(channel);
        this.securityServiceStub = SecurityServiceGrpc.newStub(channel);
    }

    private InputStream resolveCertificate(Object certSource) {
        if (certSource instanceof File) {
            try {
                return new FileInputStream((File) certSource);
            } catch (Exception e) {
                throw new IllegalArgumentException("Fehler beim Lesen der Zertifikatsdatei.", e);
            }
        } else if (certSource instanceof InputStream) {
            return (InputStream) certSource;
        } else if (certSource instanceof String) {
            return new ByteArrayInputStream(((String) certSource).getBytes());
        } else {
            throw new IllegalArgumentException("Ungültige Zertifikatsquelle. Erlaubt sind File, InputStream oder String.");
        }
    }

    private ManagedChannel initChannel(String host, int port, InputStream certStream) throws SSLException {
        return NettyChannelBuilder.forAddress(host, port)
                .negotiationType(NegotiationType.TLS)
                .sslContext(GrpcSslContexts.forClient().trustManager(certStream).build())
                .build();
    }

    public AccessServiceGrpc.AccessServiceBlockingStub getAccessServiceStub() {
        return accessServiceStub;
    }

    public SecurityServiceGrpc.SecurityServiceStub getSecurityServiceStub() {
        return securityServiceStub;
    }

    public void close() {
        channel.shutdown();
    }
}
