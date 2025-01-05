package consorsbank.observers;

import com.consorsbank.module.tapi.grpc.SecurityServiceGrpc.SecurityServiceStub;
import com.consorsbank.module.tapi.grpc.security.SecurityMarketDataReply;
import com.consorsbank.module.tapi.grpc.security.SecurityMarketDataRequest;

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
        System.out.println("Response received: " + response); // Debug-Ausgabe
        super.onNext(response);
        if (onMarketDataUpdate != null) {
            onMarketDataUpdate.accept(response);
        }
    }

//    @Override
//    public void onError(Throwable t) {
//        System.err.println("Error occurred: " + t.getMessage()); // Debug-Ausgabe
//        super.onError(t);
//        if (onErrorCallback != null) {
//            onErrorCallback.accept(t);
//        }
//    }

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
        System.out.println("Stream completed"); // Debug-Ausgabe
        super.onCompleted();
        if (onCompleteCallback != null) {
            onCompleteCallback.run();
        }
    }
}
