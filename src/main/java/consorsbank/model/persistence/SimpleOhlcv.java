package consorsbank.model.persistence;

import io.fair_acc.dataset.spi.financial.api.attrs.AttributeModel;
import io.fair_acc.dataset.spi.financial.api.ohlcv.IOhlcv;
import io.fair_acc.dataset.spi.financial.api.ohlcv.IOhlcvItem;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

public class SimpleOhlcv implements IOhlcv {
    private final List<IOhlcvItem> items = new ArrayList<>();

    public void add(IOhlcvItem item) {
        items.add(item);
    }

    public void addAll(Collection<? extends IOhlcvItem> items) {
        this.items.addAll(items);
    }

    @Override
    public IOhlcvItem getOhlcvItem(int index) {
        return items.get(index);
    }

    @Override
    public int size() {
        return items.size();
    }

    @Override
    public Iterator<IOhlcvItem> iterator() {
        return items.iterator();
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
