package consorsbank.services;

import com.consorsbank.module.tapi.grpc.security.SecurityMarketDataReply;
import consorsbank.api.consorsbank.clients.grpc.MarketDataClient;
import consorsbank.model.Stock;
import consorsbank.model.Wkn;
import consorsbank.api.consorsbank.mapper.StockMapper;
import io.grpc.stub.StreamObserver;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class SecureMarketDataService {

    private final MarketDataClient MarketDataClient;
    private final StockMapper stockMapper;
    private final Map<Wkn, Stock> stockRepository = new HashMap<>();

    public SecureMarketDataService(MarketDataClient MarketDataClient, StockMapper stockMapper) {
        this.MarketDataClient = MarketDataClient;
        this.stockMapper = stockMapper;
    }

    public void streamMarketData(Wkn wkn, String stockExchangeId, String currency) {
        MarketDataClient.streamMarketData(wkn.getValue(), stockExchangeId, currency, new StreamObserver<>() {
            @Override
            public void onNext(SecurityMarketDataReply reply) {
                try {
                    // Map the reply to the domain model using the StockMapper
                    Stock stock = stockMapper.mapToDomain(reply);

                    // Update the stock repository
                    stockRepository.put(wkn, stock);

                    // Log updated stock
                    System.out.println("Stock updated: " + stock);
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
}
