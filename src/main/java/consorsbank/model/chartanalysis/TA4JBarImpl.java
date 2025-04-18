package consorsbank.model.chartanalysis;

import org.ta4j.core.Bar;
import org.ta4j.core.num.Num;

import java.time.Duration;
import java.time.LocalDateTime;
import java.time.ZonedDateTime;

// ToDo: Implement the Bar interface from TA4J
public class TA4JBarImpl implements Bar {
    private final LocalDateTime key;
    private final double open;
    private final double high;
    private final double low;
    private final double close;
    private final double volume;

    public TA4JBarImpl(LocalDateTime key, double open, double high, double low, double close, double volume) {
        this.key = key;
        this.open = open;
        this.high = high;
        this.low = low;
        this.close = close;
        this.volume = volume;
    }

    @Override
    public Duration getTimePeriod() {
        return null;
    }

    @Override
    public ZonedDateTime getBeginTime() {
        return null;
    }

    @Override
    public ZonedDateTime getEndTime() {
        return null;
    }

    @Override
    public Num getOpenPrice() {
        return null;
    }

    @Override
    public Num getHighPrice() {
        return null;
    }

    @Override
    public Num getLowPrice() {
        return null;
    }

    @Override
    public Num getClosePrice() {
        return null;
    }

    @Override
    public Num getVolume() {
        return null;
    }

    @Override
    public Num getAmount() {
        return null;
    }

    @Override
    public long getTrades() {
        return 0;
    }

    @Override
    public void addTrade(Num num, Num num1) {

    }

    @Override
    public void addPrice(Num num) {

    }
}
