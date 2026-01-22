package consorsbank.services.connection;

public interface ActiveTraderConnectionListener {

    /**
     * Handle updated connection status.
     *
     * @param status current status
     */
    void onStatusChanged(ActiveTraderConnectionStatus status);
}
