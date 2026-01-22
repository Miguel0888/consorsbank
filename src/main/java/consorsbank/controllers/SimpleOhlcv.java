package consorsbank.controllers;

import io.fair_acc.dataset.spi.financial.api.attrs.AttributeModel;
import io.fair_acc.dataset.spi.financial.api.ohlcv.IOhlcv;
import io.fair_acc.dataset.spi.financial.api.ohlcv.IOhlcvItem;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class SimpleOhlcv implements IOhlcv {

    private final List<IOhlcvItem> items = new ArrayList<IOhlcvItem>();

    public void add(IOhlcvItem item) {
        items.add(item);
    }

    public void addAll(List<IOhlcvItem> newItems) {
        items.addAll(newItems);
    }

    public void clear() {
        items.clear();
    }

    public void removeOldest(int count) {
        if (count <= 0) {
            return;
        }
        int removeCount = Math.min(count, items.size());
        for (int i = 0; i < removeCount; i++) {
            items.remove(0);
        }
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
    public AttributeModel getAddon() {
        return null;
    }

    @Override
    public AttributeModel getAddonOrCreate() {
        return null;
    }

    @Override
    public Iterator<IOhlcvItem> iterator() {
        return items.iterator();
    }
}
