package consorsbank.model.chart;

import io.fair_acc.dataset.spi.financial.api.attrs.AttributeModel;
import io.fair_acc.dataset.spi.financial.api.ohlcv.IOhlcvItem;
import org.ta4j.core.BaseBar;

import java.util.Date;

public class BarOhlcvAdapter implements IOhlcvItem {

    private final BaseBar bar;
    private final AttributeModel addon = new SimpleAttributeModel();

    public BarOhlcvAdapter(BaseBar bar) {
        this.bar = bar;
    }

    @Override
    public Date getTimeStamp() {
        return Date.from(bar.getEndTime().toInstant());
    }

    @Override
    public double getOpen() {
        return bar.getOpenPrice().doubleValue();
    }

    @Override
    public double getHigh() {
        return bar.getHighPrice().doubleValue();
    }

    @Override
    public double getLow() {
        return bar.getLowPrice().doubleValue();
    }

    @Override
    public double getClose() {
        return bar.getClosePrice().doubleValue();
    }

    @Override
    public double getVolume() {
        return bar.getVolume().doubleValue(); // <- keine Kollision mehr!
    }

    @Override
    public double getOpenInterest() {
        return 0;
    }

    @Override
    public AttributeModel getAddon() {
        return addon;
    }

    @Override
    public AttributeModel getAddonOrCreate() {
        return addon;
    }
}
