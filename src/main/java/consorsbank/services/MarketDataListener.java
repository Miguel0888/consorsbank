package consorsbank.services;

import consorsbank.model.Stock;
import consorsbank.model.Wkn;

/**
 * Receive market data updates for a security.
 */
public interface MarketDataListener {

    /**
     * Handle an updated stock snapshot.
     *
     * @param wkn   security identifier
     * @param stock updated snapshot
     */
    void onStockUpdated(Wkn wkn, Stock stock);
}
