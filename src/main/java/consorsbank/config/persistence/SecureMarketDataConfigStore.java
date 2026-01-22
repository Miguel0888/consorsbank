package consorsbank.config.persistence;

import consorsbank.config.SecureMarketDataConfig;

/**
 * Persist and load {@link SecureMarketDataConfig}.
 */
public interface SecureMarketDataConfigStore {

    /**
     * Load the persisted configuration.
     *
     * @return the persisted configuration or null if none exists
     */
    SecureMarketDataConfig loadOrNull();

    /**
     * Save the configuration.
     *
     * @param config configuration to persist
     */
    void save(SecureMarketDataConfig config);
}
