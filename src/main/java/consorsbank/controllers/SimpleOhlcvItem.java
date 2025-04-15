
package consorsbank.controllers;

import io.fair_acc.dataset.spi.financial.api.attrs.AttributeModel;
import io.fair_acc.dataset.spi.financial.api.attrs.AttributeModelAware;
import io.fair_acc.dataset.spi.financial.api.ohlcv.IOhlcvItem;

import java.util.Date;

public class SimpleOhlcvItem implements IOhlcvItem {
    private final Date timestamp;
    private final double open;
    private final double high;
    private final double low;
    private final double close;
    private final double volume;
    private final double openInterest;

    public SimpleOhlcvItem(Date timestamp, double open, double high, double low, double close, double volume) {
        this(timestamp, open, high, low, close, volume, 0.0);
    }

    public SimpleOhlcvItem(Date timestamp, double open, double high, double low, double close, double volume, double openInterest) {
        this.timestamp = timestamp;
        this.open = open;
        this.high = high;
        this.low = low;
        this.close = close;
        this.volume = volume;
        this.openInterest = openInterest;
    }

    @Override
    public Date getTimeStamp() {
        return timestamp;
    }

    @Override
    public double getOpen() {
        return open;
    }

    @Override
    public double getHigh() {
        return high;
    }

    @Override
    public double getLow() {
        return low;
    }

    @Override
    public double getClose() {
        return close;
    }

    @Override
    public double getVolume() {
        return volume;
    }

    @Override
    public double getOpenInterest() {
        return openInterest;
    }

    @Override
    public AttributeModel getAddon() {
        return null;
    }

    @Override
    public AttributeModel getAddonOrCreate() {
        return null;
    }
}
