package consorsbank.models.persistence;

import consorsbank.models.Stock;
import consorsbank.models.Wkn;

import java.util.HashMap;
import java.util.Map;

public class StockRepository {
    private Map<Wkn, Stock> stockMap = new HashMap<>();

    public void addStock(Stock stock) {
        stockMap.put(stock.getWkn(), stock);
    }

    public Stock getStock(Wkn wkn) {
        return stockMap.get(wkn);
    }

    public boolean containsStock(Wkn wkn) {
        return stockMap.containsKey(wkn);
    }
}