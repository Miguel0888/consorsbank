package consorsbank.services.connection;

public enum ActiveTraderConnectionState {
    NOT_CONFIGURED,
    CONNECTING,
    CONNECTED,
    AUTH_FAILED,
    TLS_FAILED,
    UNAVAILABLE,
    ERROR
}
