package util;

import consorsbank.model.Stock;
import io.fair_acc.dataset.spi.financial.api.ohlcv.IOhlcvItem;
import org.ta4j.core.BaseBar;

import java.time.Duration;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class TestingUtils {
    public static List<BaseBar> generateTestBars(int days) {
        List<BaseBar> bars = new ArrayList<>();
        LocalDateTime base = LocalDateTime.now().minusDays(days);
        double price = 100.0;

        for (int i = 0; i < days; i++) {
            LocalDateTime time = base.plusDays(i);
            double open = price + Math.random() * 2 - 1;
            double close = open + Math.random() * 2 - 1;
            double high = Math.max(open, close) + Math.random();
            double low = Math.min(open, close) - Math.random();
            double volume = 1000 + Math.random() * 5000;

            BaseBar bar = new BaseBar(
                    Duration.ofDays(1),
                    time.atZone(ZoneId.systemDefault()),
                    open, high, low, close, volume
            );
            bars.add(bar);
            price = close;
        }

        return bars;
    }


}
