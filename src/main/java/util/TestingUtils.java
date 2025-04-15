package util;

import consorsbank.models.Stock;
import io.fair_acc.dataset.spi.financial.api.ohlcv.IOhlcvItem;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class TestingUtils {
    public static List<IOhlcvItem> generateTestStocks(int days) {
        List<IOhlcvItem> stocks = new ArrayList<>();
        LocalDateTime base = LocalDateTime.now().minusDays(days);

        double price = 100.0;
        for (int i = 0; i < days; i++) {
            LocalDateTime dateTime = base.plusDays(i);
            double open = price + Math.random() * 2 - 1;
            double close = open + Math.random() * 2 - 1;
            double high = Math.max(open, close) + Math.random();
            double low = Math.min(open, close) - Math.random();
            double volume = 1000 + Math.random() * 5000;

            Date date = java.sql.Timestamp.valueOf(dateTime);
            stocks.add(new Stock(date, open, high, low, close, volume));
            price = close; // next open near last close
        }

        return stocks;
    }

}
