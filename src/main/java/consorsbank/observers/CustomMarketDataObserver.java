package consorsbank.observers;

import com.consorsbank.module.tapi.grpc.SecurityServiceGrpc.SecurityServiceStub;
import com.consorsbank.module.tapi.grpc.security.SecurityMarketDataReply;
import com.consorsbank.module.tapi.grpc.security.SecurityMarketDataRequest;
import com.consorsbank.module.tapi.observers.MarketDataDataObserver;

import java.util.function.Consumer;

public class CustomMarketDataObserver extends MarketDataDataObserver {

    private Consumer<SecurityMarketDataReply> onMarketDataUpdate;
    private Consumer<Throwable> onErrorCallback;
    private Runnable onCompleteCallback;

    public CustomMarketDataObserver(SecurityMarketDataRequest request, SecurityServiceStub securityServiceStub) {
        super(request, securityServiceStub);
    }

    public void setOnMarketDataUpdate(Consumer<SecurityMarketDataReply> onMarketDataUpdate) {
        this.onMarketDataUpdate = onMarketDataUpdate;
    }

    public void setOnError(Consumer<Throwable> onErrorCallback) {
        this.onErrorCallback = onErrorCallback;
    }

    public void setOnComplete(Runnable onCompleteCallback) {
        this.onCompleteCallback = onCompleteCallback;
    }

    @Override
    public void onNext(SecurityMarketDataReply response) {
        super.onNext(response); // Behalte die ursprüngliche Logik bei
        if (onMarketDataUpdate != null) {
            onMarketDataUpdate.accept(response);
        }
    }

    /**
     * Ruft die Fehlerbehandlung auf, ohne die Basismethode zu überschreiben.
     * @param throwable Der aufgetretene Fehler.
     */
    public void handleError(Throwable throwable) {
        if (onErrorCallback != null) {
            onErrorCallback.accept(throwable);
        }
    }

    @Override
    public void onCompleted() {
        super.onCompleted(); // Behalte die ursprüngliche Logik bei
        if (onCompleteCallback != null) {
            onCompleteCallback.run();
        }
    }
}
