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
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Date;

@Controller
public class ChartController implements WknSelectionAware {

    private static final int MAX_POINTS = 600;

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

        DefaultNumericAxis yAxis = new DefaultNumericAxis("Price");
        XYChart c = new XYChart(xAxis, yAxis);
        c.setTitle("Live Candlestick");
        return c;
    }

    private void appendTick(Stock stock) {
        if (stock == null) {
            return;
        }

        double last = stock.getLastPrice();
        if (last <= 0.0) {
            return;
        }

        Date ts = stock.getTimeStamp();
        if (ts == null) {
            ts = new Date();
        }

        double open = safePrice(stock.getOpenPrice(), last);
        double high = safePrice(stock.getHighPrice(), last);
        double low = safePrice(stock.getLowPrice(), last);
        double close = last;

        // If OHLC is not provided by stream, use last price as candle
        if (open <= 0.0) open = last;
        if (high <= 0.0) high = last;
        if (low <= 0.0) low = last;

        // Normalize high/low
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
    }

    private double safePrice(double candidate, double fallback) {
        return candidate > 0.0 ? candidate : fallback;
    }
}
