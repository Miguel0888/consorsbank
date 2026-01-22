package consorsbank.services.connection;

public final class ActiveTraderConnectionStatus {

    private final ActiveTraderConnectionState state;
    private final String message;

    public ActiveTraderConnectionStatus(ActiveTraderConnectionState state, String message) {
        this.state = state;
        this.message = message;
    }

    public ActiveTraderConnectionState getState() {
        return state;
    }

    public String getMessage() {
        return message;
    }

    public static ActiveTraderConnectionStatus of(ActiveTraderConnectionState state, String message) {
        return new ActiveTraderConnectionStatus(state, message);
    }
}
