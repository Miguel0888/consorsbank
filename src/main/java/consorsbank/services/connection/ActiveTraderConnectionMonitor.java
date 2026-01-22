package consorsbank.services.connection;

import com.consorsbank.module.tapi.grpc.AccessServiceGrpc;
import com.consorsbank.module.tapi.grpc.access.LoginReply;
import com.consorsbank.module.tapi.grpc.access.LoginRequest;
import com.consorsbank.module.tapi.grpc.common.Error;
import consorsbank.config.SecureMarketDataConfig;
import io.grpc.ManagedChannel;
import io.grpc.Status;
import io.grpc.StatusRuntimeException;
import io.grpc.netty.shaded.io.grpc.netty.GrpcSslContexts;
import io.grpc.netty.shaded.io.grpc.netty.NegotiationType;
import io.grpc.netty.shaded.io.grpc.netty.NettyChannelBuilder;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.net.ssl.SSLException;
import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.util.List;
import java.util.concurrent.*;

@Service
public class ActiveTraderConnectionMonitor {

    private final SecureMarketDataConfig config;

    private final ScheduledExecutorService scheduler;
    private final List<ActiveTraderConnectionListener> listeners;

    public ActiveTraderConnectionMonitor(SecureMarketDataConfig config) {
        this.config = config;
        this.scheduler = Executors.newSingleThreadScheduledExecutor(new ThreadFactory() {
            @Override
            public Thread newThread(Runnable r) {
                Thread t = new Thread(r, "active-trader-connection-monitor");
                t.setDaemon(true);
                return t;
            }
        });
        this.listeners = new CopyOnWriteArrayList<ActiveTraderConnectionListener>();
    }

    @PostConstruct
    public void start() {
        scheduler.scheduleWithFixedDelay(new Runnable() {
            @Override
            public void run() {
                publish(checkOnce());
            }
        }, 0, 5, TimeUnit.SECONDS);
    }

    @PreDestroy
    public void stop() {
        scheduler.shutdownNow();
    }

    public void addListener(ActiveTraderConnectionListener listener) {
        if (listener != null) {
            listeners.add(listener);
        }
    }

    public void removeListener(ActiveTraderConnectionListener listener) {
        listeners.remove(listener);
    }

    private void publish(ActiveTraderConnectionStatus status) {
        for (ActiveTraderConnectionListener listener : listeners) {
            try {
                listener.onStatusChanged(status);
            } catch (RuntimeException ignored) {
                // Ignore listener failure to keep monitor alive
            }
        }
    }

    private ActiveTraderConnectionStatus checkOnce() {
        if (isBlank(config.getHost()) || config.getPort() <= 0 || isBlank(config.getSecret()) || isBlank(config.getCertContent())) {
            return ActiveTraderConnectionStatus.of(
                    ActiveTraderConnectionState.NOT_CONFIGURED,
                    "Nicht konfiguriert (Host/Port/Secret/Zertifikat fehlen)"
            );
        }

        ManagedChannel channel = null;
        File certFile = null;

        try {
            publish(ActiveTraderConnectionStatus.of(ActiveTraderConnectionState.CONNECTING, "Verbinde..."));

            certFile = writeCertToTempFile(config.getCertContent());

            channel = NettyChannelBuilder.forAddress(config.getHost(), config.getPort())
                    .negotiationType(NegotiationType.TLS)
                    .sslContext(GrpcSslContexts.forClient().trustManager(certFile).build())
                    .build();

            AccessServiceGrpc.AccessServiceBlockingStub accessStub = AccessServiceGrpc.newBlockingStub(channel);

            LoginRequest request = LoginRequest.newBuilder()
                    .setSecret(config.getSecret())
                    .build();

            LoginReply reply = accessStub.login(request);

            Error error = reply.getError();
            if (error != null && error != Error.getDefaultInstance()) {
                return ActiveTraderConnectionStatus.of(
                        ActiveTraderConnectionState.AUTH_FAILED,
                        "Login fehlgeschlagen (Secret/TAPI Status prüfen)"
                );
            }

            if (isBlank(reply.getAccessToken())) {
                return ActiveTraderConnectionStatus.of(
                        ActiveTraderConnectionState.ERROR,
                        "Login ohne AccessToken (unerwartet)"
                );
            }

            return ActiveTraderConnectionStatus.of(
                    ActiveTraderConnectionState.CONNECTED,
                    "Verbunden (" + config.getHost() + ":" + config.getPort() + ")"
            );
        } catch (SSLException e) {
            return ActiveTraderConnectionStatus.of(
                    ActiveTraderConnectionState.TLS_FAILED,
                    "TLS Fehler (roots.pem / Hostname prüfen)"
            );
        } catch (StatusRuntimeException e) {
            Status.Code code = e.getStatus().getCode();
            if (code == Status.Code.UNAVAILABLE) {
                return ActiveTraderConnectionStatus.of(
                        ActiveTraderConnectionState.UNAVAILABLE,
                        "Nicht erreichbar (ActiveTrader läuft? Port korrekt?)"
                );
            }
            if (code == Status.Code.UNAUTHENTICATED || code == Status.Code.PERMISSION_DENIED) {
                return ActiveTraderConnectionStatus.of(
                        ActiveTraderConnectionState.AUTH_FAILED,
                        "Authentifizierung fehlgeschlagen"
                );
            }
            return ActiveTraderConnectionStatus.of(
                    ActiveTraderConnectionState.ERROR,
                    "gRPC Fehler: " + code.name()
            );
        } catch (RuntimeException e) {
            return ActiveTraderConnectionStatus.of(
                    ActiveTraderConnectionState.ERROR,
                    "Fehler: " + safeMessage(e)
            );
        } finally {
            shutdown(channel);
            deleteQuietly(certFile);
        }
    }

    private File writeCertToTempFile(String pemContent) {
        try {
            File tmp = File.createTempFile("active-trader-roots-", ".pem");
            Files.write(tmp.toPath(), pemContent.getBytes(StandardCharsets.UTF_8));
            tmp.deleteOnExit();
            return tmp;
        } catch (IOException e) {
            throw new IllegalStateException("Failed to write temp certificate", e);
        }
    }

    private void shutdown(ManagedChannel channel) {
        if (channel == null) {
            return;
        }
        channel.shutdownNow();
        try {
            channel.awaitTermination(2, TimeUnit.SECONDS);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }

    private void deleteQuietly(File file) {
        if (file == null) {
            return;
        }
        try {
            Files.deleteIfExists(file.toPath());
        } catch (IOException ignored) {
            // Ignore deletion failures
        }
    }

    private boolean isBlank(String value) {
        return value == null || value.trim().isEmpty();
    }

    private String safeMessage(Throwable t) {
        String msg = t.getMessage();
        return msg == null ? t.getClass().getSimpleName() : msg;
    }
}
