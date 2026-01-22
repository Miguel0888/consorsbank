package consorsbank.services;

import com.consorsbank.module.tapi.grpc.security.SecurityMarketDataReply;
import consorsbank.api.consorsbank.clients.grpc.MarketDataClient;
import consorsbank.api.consorsbank.mapper.StockMapper;
import consorsbank.model.Stock;
import consorsbank.model.Wkn;
import io.grpc.stub.StreamObserver;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;

@Service
public class SecureMarketDataService {

    private final MarketDataClient marketDataClient;
    private final StockMapper stockMapper;

    private final Map<Wkn, Stock> stockRepository = new ConcurrentHashMap<Wkn, Stock>();
    private final List<MarketDataListener> listeners = new CopyOnWriteArrayList<MarketDataListener>();

    public SecureMarketDataService(MarketDataClient marketDataClient, StockMapper stockMapper) {
        this.marketDataClient = marketDataClient;
        this.stockMapper = stockMapper;
    }

    public void addListener(MarketDataListener listener) {
        if (listener != null) {
            listeners.add(listener);
        }
    }

    public void removeListener(MarketDataListener listener) {
        listeners.remove(listener);
    }

    public void streamMarketData(final Wkn wkn, String stockExchangeId, String currency) {
        marketDataClient.streamMarketData(wkn.getValue(), stockExchangeId, currency, new StreamObserver<SecurityMarketDataReply>() {
            @Override
            public void onNext(SecurityMarketDataReply reply) {
                try {
                    Stock stock = stockMapper.mapToDomain(reply);
                    stockRepository.put(wkn, stock);
                    notifyListeners(wkn, stock);
                } catch (Exception e) {
                    System.err.println("Error mapping or updating stock: " + e.getMessage());
                    e.printStackTrace();
                }
            }

            @Override
            public void onError(Throwable t) {
                System.err.println("Error fetching market data: " + t.getMessage());
                t.printStackTrace();
            }

            @Override
            public void onCompleted() {
                System.out.println("Market data stream completed for WKN: " + wkn.getValue());
            }
        });
    }

    public Stock getStock(Wkn wkn) {
        return stockRepository.get(wkn);
    }

    private void notifyListeners(Wkn wkn, Stock stock) {
        for (MarketDataListener listener : listeners) {
            try {
                listener.onStockUpdated(wkn, stock);
            } catch (RuntimeException ignored) {
                // Ignore listener failures to keep stream alive
            }
        }
    }
}
