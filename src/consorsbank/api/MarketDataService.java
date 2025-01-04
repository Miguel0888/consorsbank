package consorsbank.api;

import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import consorsbank.proto.SecurityServiceGrpc;
import consorsbank.proto.SecurityMarketDataRequest;

public class MarketDataService {
    private final ManagedChannel channel;
    private final SecurityServiceGrpc.SecurityServiceBlockingStub securityStub;

    public MarketDataService(String host, int port) {
        this.channel = ManagedChannelBuilder.forAddress(host, port).usePlaintext().build();
        this.securityStub = SecurityServiceGrpc.newBlockingStub(channel);
    }

    public String getMarketData(String securityCode) {
        SecurityMarketDataRequest request = SecurityMarketDataRequest.newBuilder()
                .setSecurityCode(securityCode)
                .build();
        // Beispiel: Rückgabe von Marktdaten als String
        return securityStub.getMarketData(request).toString();
    }

    public void close() {
        channel.shutdown();
    }
}
