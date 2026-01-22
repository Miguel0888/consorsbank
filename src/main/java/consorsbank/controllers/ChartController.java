package consorsbank.controllers;

import consorsbank.model.Stock;
import consorsbank.model.Wkn;
import consorsbank.services.MarketDataListener;
import consorsbank.services.SecureMarketDataService;
import io.fair_acc.chartfx.XYChart;
import io.fair_acc.chartfx.axes.AxisLabelFormatter;
import io.fair_acc.chartfx.axes.TickUnitSupplier;
import io.fair_acc.chartfx.axes.spi.DefaultNumericAxis;
import io.fair_acc.chartfx.axes.spi.format.DefaultTickUnitSupplier;
import io.fair_acc.chartfx.plugins.Zoomer;
import io.fair_acc.chartfx.renderer.spi.financial.CandleStickRenderer;
import io.fair_acc.chartfx.renderer.spi.financial.FinancialTheme;
import io.fair_acc.dataset.spi.financial.OhlcvDataSet;
import io.fair_acc.dataset.spi.fastutil.DoubleArrayList;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.ComboBox;
import javafx.scene.control.ToolBar;
import javafx.scene.layout.Region;
import javafx.scene.layout.StackPane;
import org.springframework.stereotype.Controller;

import javax.annotation.PreDestroy;
import java.lang.reflect.Method;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Date;

@Controller
public class ChartController implements WknSelectionAware {

    private static final int MAX_POINTS = 600;

    // Keep the first valid candle visible without manual zooming
    private static final long INITIAL_WINDOW_PAST_SECONDS = 6 * 60 * 60;   // 6 hours back
    private static final long INITIAL_WINDOW_FUTURE_SECONDS = 10 * 60;     // 10 minutes forward

    // Reject timestamps that look like epoch/placeholder
    private static final long MIN_VALID_EPOCH_MILLIS = 946684800000L; // 2000-01-01T00:00:00Z

    @FXML
    private ToolBar toolbar;

    @FXML
    private ComboBox<String> chartTypeDropdown;

    @FXML
    private ComboBox<String> indicatorDropdown;

    @FXML
    private StackPane chartContainer;

    private final SecureMarketDataService marketDataService;

    private final SimpleOhlcv ohlcv = new SimpleOhlcv();
    private OhlcvDataSet dataSet;
    private XYChart chart;

    private DefaultNumericAxis xAxis;
    private DefaultNumericAxis yAxis;

    private volatile Wkn selectedWkn;

    private final MarketDataListener listener = new MarketDataListener() {
        @Override
        public void onStockUpdated(Wkn wkn, Stock stock) {
            if (selectedWkn == null || wkn == null || !selectedWkn.getValue().equals(wkn.getValue())) {
                return;
            }
            Platform.runLater(new Runnable() {
                @Override
                public void run() {
                    appendTick(stock);
                }
            });
        }
    };

    public ChartController(SecureMarketDataService marketDataService) {
        this.marketDataService = marketDataService;
    }

    public void initialize() {
        chartTypeDropdown.getItems().addAll("Candlestick");
        chartTypeDropdown.setValue("Candlestick");

        indicatorDropdown.getItems().addAll("SMA", "EMA", "RSI", "MACD", "BOLL", "PIVOT");
        indicatorDropdown.setValue("BOLL");

        chartTypeDropdown.setOnAction(e -> rebuildChart());
        indicatorDropdown.setOnAction(e -> rebuildChart());

        marketDataService.addListener(listener);

        rebuildChart();
    }

    @PreDestroy
    public void onDestroy() {
        marketDataService.removeListener(listener);
    }

    @Override
    public void setSelectedWkn(Wkn wkn) {
        this.selectedWkn = wkn;
        this.ohlcv.clear();
        rebuildChart();
    }

    private void rebuildChart() {
        chartContainer.getChildren().clear();

        String chartType = chartTypeDropdown.getValue();
        if (!"Candlestick".equals(chartType)) {
            return;
        }

        this.chart = createCandlestickChart();

        this.dataSet = new OhlcvDataSet("Live Market Data");
        this.dataSet.setData(ohlcv);

        chart.getRenderers().setAll(new CandleStickRenderer());
        chart.getDatasets().setAll(dataSet);

        chart.getPlugins().add(new Zoomer());
        chart.setStyle(FinancialTheme.Default.name());

        chart.setPrefSize(Region.USE_COMPUTED_SIZE, Region.USE_COMPUTED_SIZE);

        Node node = chart;
        chartContainer.getChildren().add(node);
    }

    private XYChart createCandlestickChart() {
        this.xAxis = new DefaultNumericAxis("Time");
        xAxis.setAxisLabelFormatter(new AxisLabelFormatter() {

            private DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM");

            @Override
            public Number fromString(String s) {
                return null;
            }

            @Override
            public TickUnitSupplier getTickUnitSupplier() {
                return new DefaultTickUnitSupplier();
            }

            @Override
            public void setTickUnitSupplier(TickUnitSupplier tickUnitSupplier) {
                // No-op
            }

            @Override
            public javafx.beans.property.ObjectProperty<TickUnitSupplier> tickUnitSupplierProperty() {
                return new javafx.beans.property.SimpleObjectProperty<TickUnitSupplier>();
            }

            @Override
            public String toString(Number value) {
                long seconds = value.longValue();
                LocalDateTime time = Instant.ofEpochSecond(seconds)
                        .atZone(ZoneId.systemDefault())
                        .toLocalDateTime();
                return formatter.format(time);
            }

            @Override
            public void updateFormatter(DoubleArrayList ticks, double scale) {
                if (ticks.isEmpty()) {
                    return;
                }
                double min = ticks.getDouble(0);
                double max = ticks.getDouble(ticks.size() - 1);
                double rangeInHours = (max - min) / 3600.0;

                if (rangeInHours < 1) {
                    formatter = DateTimeFormatter.ofPattern("HH:mm:ss");
                } else if (rangeInHours < 24) {
                    formatter = DateTimeFormatter.ofPattern("HH:mm");
                } else if (rangeInHours < 24 * 7) {
                    formatter = DateTimeFormatter.ofPattern("dd.MM HH:mm");
                } else {
                    formatter = DateTimeFormatter.ofPattern("dd.MM.yy");
                }
            }
        });

        this.yAxis = new DefaultNumericAxis("Price");

        XYChart c = new XYChart(xAxis, yAxis);
        c.setTitle("Live Candlestick");
        return c;
    }

    private void appendTick(Stock stock) {
        if (stock == null) {
            return;
        }

        double last = stock.getLastPrice();
        if (!isValidPrice(last)) {
            return;
        }

        Date ts = safeTimestamp(stock);
        if (!isValidTimestamp(ts)) {
            return;
        }

        double open = normalizePrice(stock.getOpenPrice(), last);
        double high = normalizePrice(stock.getHighPrice(), last);
        double low = normalizePrice(stock.getLowPrice(), last);
        double close = last;

        if (high < low) {
            double tmp = high;
            high = low;
            low = tmp;
        }

        SimpleOhlcvItem item = new SimpleOhlcvItem(ts, open, high, low, close, 0.0);
        ohlcv.add(item);

        if (ohlcv.size() > MAX_POINTS) {
            ohlcv.removeOldest(ohlcv.size() - MAX_POINTS);
        }

        if (dataSet != null) {
            dataSet.setData(ohlcv);
        }

        if (ohlcv.size() == 1) {
            ensureInitialWindowVisible(ts);
        }
    }

    private Date safeTimestamp(Stock stock) {
        try {
            return stock.getTimeStamp();
        } catch (Exception ignored) {
            return null;
        }
    }

    private boolean isValidTimestamp(Date ts) {
        return ts != null && ts.getTime() >= MIN_VALID_EPOCH_MILLIS;
    }

    private boolean isValidPrice(double value) {
        return Double.isFinite(value) && value > 0.0;
    }

    private double normalizePrice(double candidate, double fallback) {
        if (!Double.isFinite(candidate) || candidate <= 0.0) {
            return fallback;
        }
        return candidate;
    }

    private void ensureInitialWindowVisible(Date center) {
        // ChartFX axis API differs a bit across versions; use reflection to avoid compile-time breakage.
        long centerSeconds = center.getTime() / 1000L;
        double lower = (double) (centerSeconds - INITIAL_WINDOW_PAST_SECONDS);
        double upper = (double) (centerSeconds + INITIAL_WINDOW_FUTURE_SECONDS);

        AxisWindow.tryApply(xAxis, lower, upper);
    }

    private static final class AxisWindow {

        private AxisWindow() {
            // Utility class
        }

        static void tryApply(Object axis, double lower, double upper) {
            if (axis == null) {
                return;
            }

            // Try common patterns: setAutoRanging(false) + setLowerBound/setUpperBound
            invokeIfExists(axis, "setAutoRanging", new Class<?>[]{boolean.class}, new Object[]{false});
            boolean applied = invokeIfExists(axis, "setLowerBound", new Class<?>[]{double.class}, new Object[]{lower})
                    && invokeIfExists(axis, "setUpperBound", new Class<?>[]{double.class}, new Object[]{upper});

            if (!applied) {
                // Alternative names occasionally used by non-JavaFX axes
                invokeIfExists(axis, "setMin", new Class<?>[]{double.class}, new Object[]{lower});
                invokeIfExists(axis, "setMax", new Class<?>[]{double.class}, new Object[]{upper});
            }

            // Force refresh workaround: slightly nudge bounds and restore (seen in ChartFX discussions)
            Double currentLower = (Double) invokeIfExistsWithReturn(axis, "getLowerBound");
            Double currentUpper = (Double) invokeIfExistsWithReturn(axis, "getUpperBound");
            if (currentLower != null && currentUpper != null) {
                invokeIfExists(axis, "setLowerBound", new Class<?>[]{double.class}, new Object[]{currentLower - 1});
                invokeIfExists(axis, "setUpperBound", new Class<?>[]{double.class}, new Object[]{currentUpper + 1});
                invokeIfExists(axis, "setLowerBound", new Class<?>[]{double.class}, new Object[]{currentLower});
                invokeIfExists(axis, "setUpperBound", new Class<?>[]{double.class}, new Object[]{currentUpper});
            }
        }

        private static boolean invokeIfExists(Object target, String method, Class<?>[] paramTypes, Object[] args) {
            try {
                Method m = target.getClass().getMethod(method, paramTypes);
                m.invoke(target, args);
                return true;
            } catch (Exception ignored) {
                return false;
            }
        }

        private static Object invokeIfExistsWithReturn(Object target, String method) {
            try {
                Method m = target.getClass().getMethod(method);
                return m.invoke(target);
            } catch (Exception ignored) {
                return null;
            }
        }
    }
}
