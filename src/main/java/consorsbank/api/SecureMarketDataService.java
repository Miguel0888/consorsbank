package consorsbank.api;

import com.consorsbank.module.tapi.grpc.AccessServiceGrpc;
import com.consorsbank.module.tapi.grpc.SecurityServiceGrpc;
import com.consorsbank.module.tapi.grpc.access.LoginReply;
import com.consorsbank.module.tapi.grpc.access.LoginRequest;
import com.consorsbank.module.tapi.grpc.security.SecurityMarketDataRequest;
import com.consorsbank.module.tapi.observers.MarketDataDataObserver;
import io.grpc.ManagedChannel;
import io.grpc.netty.shaded.io.grpc.netty.NettyChannelBuilder;
import io.grpc.netty.shaded.io.netty.handler.ssl.SslContext;
import io.grpc.netty.shaded.io.netty.handler.ssl.SslContextBuilder;

import javax.net.ssl.SSLException;
import java.io.InputStream;

public class SecureMarketDataService {

    private final ManagedChannel channel;
    private final AccessServiceGrpc.AccessServiceBlockingStub accessServiceStub;
    private final SecurityServiceGrpc.SecurityServiceStub securityServiceStub;

    /**
     * Konstruktor zur Initialisierung des gRPC-Kanals mit TLS.
     *
     * @param host             Hostname der API (z. B. "localhost")
     * @param port             Port der API (z. B. 40443)
     * @param certResourcePath Pfad zum Zertifikat im Ressourcen-Ordner (z. B. "roots.pem")
     * @throws SSLException Wenn das SSL-Zertifikat fehlerhaft ist
     */
    public SecureMarketDataService(String host, int port, String certResourcePath) throws SSLException {
        // Lade das Zertifikat aus den Ressourcen
        InputStream certInputStream = getClass().getClassLoader().getResourceAsStream(certResourcePath);
        if (certInputStream == null) {
            throw new IllegalArgumentException("Zertifikat nicht gefunden: " + certResourcePath);
        }

        // Erstelle den SslContext mit dem Zertifikat
        SslContext sslContext = SslContextBuilder.forClient()
                .trustManager(certInputStream)
                .build();

        // Erstelle den gRPC-Kanal
        this.channel = NettyChannelBuilder.forAddress(host, port)
                .sslContext(sslContext)
                .build();

        // Initialisiere die Stubs
        this.accessServiceStub = AccessServiceGrpc.newBlockingStub(channel);
        this.securityServiceStub = SecurityServiceGrpc.newStub(channel);
    }

    /**
     * Führt den Login aus und gibt einen Access-Token zurück.
     *
     * @param secret Das Secret, das in der Trading API-Konfiguration definiert wurde.
     * @return Der Access-Token als String, wenn erfolgreich; andernfalls `null`.
     */
    public String login(String secret) {
        // Erstelle das LoginRequest-Objekt
        LoginRequest loginRequest = LoginRequest.newBuilder()
                .setSecret(secret)
                .build();

        try {
            // Sende die Login-Anfrage und erhalte die Antwort
            LoginReply loginReply = accessServiceStub.login(loginRequest);

            // Überprüfen auf Fehler
            if (loginReply.hasError()) {
                System.err.println("Login fehlgeschlagen: " + loginReply.getError().getMessage());
                return null;
            }

            // Access-Token zurückgeben
            return loginReply.getAccessToken();
        } catch (Exception e) {
            System.err.println("Login-Fehler: " + e.getMessage());
            return null;
        }
    }

    /**
     * Startet einen Marktdaten-Stream.
     *
     * @param request  Die Anfrage mit allen benötigten Informationen.
     * @param observer Der Observer zur Verarbeitung der Daten.
     */
    public void streamMarketData(SecurityMarketDataRequest request, MarketDataDataObserver observer) {
        // Starte den Stream über den SecurityServiceStub
        securityServiceStub.streamMarketData(request, observer);
    }

    /**
     * Schließt den gRPC-Kanal.
     */
    public void close() {
        channel.shutdown();
    }

    /**
     * Gibt den SecurityServiceStub zurück, falls er direkt benötigt wird.
     *
     * @return SecurityServiceGrpc.SecurityServiceStub
     */
    public SecurityServiceGrpc.SecurityServiceStub getSecurityServiceStub() {
        return securityServiceStub;
    }
}
