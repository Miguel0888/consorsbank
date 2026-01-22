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

    // Aggregate ticks into 1-minute candles (change to 300 for 5m, 900 for 15m, 86400 for daily)
    private static final long CANDLE_SECONDS = 60;

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
                    appendOrUpdateCandle(stock);
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

        // IMPORTANT: Do not set invalid CSS here; Node#setStyle expects CSS declarations.
        // chart.setStyle(FinancialTheme.Default.name()); // remove/avoid

        chart.setPrefSize(Region.USE_COMPUTED_SIZE, Region.USE_COMPUTED_SIZE);

        Node node = chart;
        chartContainer.getChildren().add(node);

        chart.invalidate();
    }

    private XYChart createCandlestickChart() {
        DefaultNumericAxis xAxis = new DefaultNumericAxis("Time");
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

        // Give autorange some padding if supported by the library version
        trySetAutoRangePadding(yAxis, 0.08);

        XYChart c = new XYChart(xAxis, yAxis);
        c.setTitle("Live Candlestick");
        return c;
    }

    private void appendOrUpdateCandle(Stock stock) {
        if (stock == null) {
            return;
        }

        double last = stock.getLastPrice();
        if (!isFinitePositive(last)) {
            return;
        }

        long tickEpochSeconds = resolveEpochSeconds(stock);
        if (tickEpochSeconds <= 0) {
            return;
        }

        long bucketStartSeconds = (tickEpochSeconds / CANDLE_SECONDS) * CANDLE_SECONDS;
        Date candleTs = new Date(bucketStartSeconds * 1000L);

        double openCandidate = stock.getOpenPrice();
        double highCandidate = stock.getHighPrice();
        double lowCandidate = stock.getLowPrice();

        double open = normalize(openCandidate, last);
        double high = normalize(highCandidate, last);
        double low = normalize(lowCandidate, last);
        double close = last;

        if (high < low) {
            double tmp = high;
            high = low;
            low = tmp;
        }

        // Aggregate: update last candle if it is in the same bucket
        if (ohlcv.size() > 0) {
            SimpleOhlcvItem lastItem = (SimpleOhlcvItem) ohlcv.getLastOrNull();
            if (lastItem != null) {
                long lastBucketSeconds = lastItem.getTimeStamp().getTime() / 1000L;
                if (lastBucketSeconds == bucketStartSeconds) {
                    // Keep open from first tick in bucket, update high/low/close
                    double aggOpen = lastItem.getOpen();
                    double aggHigh = Math.max(lastItem.getHigh(), high);
                    double aggLow = Math.min(lastItem.getLow(), low);
                    double aggClose = close;

                    SimpleOhlcvItem updated = new SimpleOhlcvItem(candleTs, aggOpen, aggHigh, aggLow, aggClose, 0.0);
                    ohlcv.replaceLast(updated);

                    refreshChartAndAxis(aggLow, aggHigh, aggClose);
                    return;
                }
            }
        }

        // New bucket -> add new candle
        SimpleOhlcvItem item = new SimpleOhlcvItem(candleTs, open, high, low, close, 0.0);
        ohlcv.add(item);

        if (ohlcv.size() > MAX_POINTS) {
            ohlcv.removeOldest(ohlcv.size() - MAX_POINTS);
        }

        refreshChartAndAxis(low, high, close);
    }

    private void refreshChartAndAxis(double low, double high, double last) {
        // If range is tiny (or equal), force a visible y-range
        if (yAxis != null) {
            double min = low;
            double max = high;

            if (!Double.isFinite(min) || !Double.isFinite(max)) {
                return;
            }

            if (max - min < 1e-6) {
                double pad = Math.max(0.01, last * 0.002); // 0.2% or at least 1 cent
                min = last - pad;
                max = last + pad;
            }

            tryForceAxisBounds(yAxis, min, max);
        }

        if (dataSet != null) {
            dataSet.setData(ohlcv);
        }
        if (chart != null) {
            chart.invalidate();
        }
    }

    private long resolveEpochSeconds(Stock stock) {
        // Prefer lastDateTime if present (more stable than "now")
        try {
            if (stock.getLastDateTime() != null) {
                return stock.getLastDateTime().atZone(ZoneId.systemDefault()).toEpochSecond();
            }
        } catch (RuntimeException ignored) {
            // ignore
        }

        try {
            Date ts = stock.getTimeStamp();
            if (ts != null) {
                return ts.getTime() / 1000L;
            }
        } catch (RuntimeException ignored) {
            // ignore
        }

        return System.currentTimeMillis() / 1000L;
    }

    private double normalize(double candidate, double fallback) {
        if (!isFinitePositive(candidate)) {
            return fallback;
        }
        return candidate;
    }

    private boolean isFinitePositive(double value) {
        return Double.isFinite(value) && value > 0.0;
    }

    private void trySetAutoRangePadding(Object axis, double paddingFraction) {
        // ChartFX has autoRangePaddingProperty in newer versions; use reflection to be version-safe
        invokeIfExists(axis, "setAutoRangePadding", new Class<?>[]{double.class}, new Object[]{paddingFraction});
    }

    private void tryForceAxisBounds(Object axis, double lower, double upper) {
        // Use reflection to avoid dependency on specific ChartFX/JavaFX method set
        invokeIfExists(axis, "setAutoRanging", new Class<?>[]{boolean.class}, new Object[]{false});
        boolean okLower = invokeIfExists(axis, "setLowerBound", new Class<?>[]{double.class}, new Object[]{lower});
        boolean okUpper = invokeIfExists(axis, "setUpperBound", new Class<?>[]{double.class}, new Object[]{upper});

        if (!okLower || !okUpper) {
            // Alternative method names sometimes used
            invokeIfExists(axis, "setMin", new Class<?>[]{double.class}, new Object[]{lower});
            invokeIfExists(axis, "setMax", new Class<?>[]{double.class}, new Object[]{upper});
        }
    }

    private boolean invokeIfExists(Object target, String method, Class<?>[] paramTypes, Object[] args) {
        if (target == null) {
            return false;
        }
        try {
            Method m = target.getClass().getMethod(method, paramTypes);
            m.invoke(target, args);
            return true;
        } catch (Exception ignored) {
            return false;
        }
    }
}
