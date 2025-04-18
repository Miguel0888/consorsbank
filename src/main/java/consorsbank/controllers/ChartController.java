
package consorsbank.controllers;

import io.fair_acc.chartfx.axes.spi.format.DefaultTickUnitSupplier;
import io.fair_acc.chartfx.XYChart;
import io.fair_acc.chartfx.axes.AxisLabelFormatter;
import io.fair_acc.chartfx.axes.TickUnitSupplier;
import io.fair_acc.chartfx.axes.spi.DefaultNumericAxis;
import io.fair_acc.chartfx.plugins.Zoomer;
import io.fair_acc.chartfx.renderer.spi.GridRenderer;
import io.fair_acc.chartfx.renderer.spi.ReducingLineRenderer;
import io.fair_acc.chartfx.renderer.spi.financial.CandleStickRenderer;
import io.fair_acc.chartfx.renderer.spi.financial.FinancialTheme;
import io.fair_acc.dataset.spi.DefaultDataSet;
import io.fair_acc.dataset.spi.fastutil.DoubleArrayList;
import io.fair_acc.dataset.spi.financial.OhlcvDataSet;
import io.fair_acc.dataset.spi.financial.api.ohlcv.IOhlcvItem;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.ComboBox;
import javafx.scene.control.ToolBar;
import javafx.scene.layout.Region;
import javafx.scene.layout.StackPane;
import org.ta4j.core.BarSeries;
import org.ta4j.core.BaseBar;
import org.ta4j.core.BaseBarSeries;
import org.ta4j.core.indicators.SMAIndicator;
import org.ta4j.core.indicators.helpers.ClosePriceIndicator;
import util.TestingUtils;
import consorsbank.model.chart.BarOhlcvAdapter;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class ChartController {

    @FXML
    private ToolBar toolbar;

    @FXML
    private ComboBox<String> chartTypeDropdown;

    @FXML
    private StackPane chartContainer;

    private Node currentChart;

    public void initialize() {
        chartTypeDropdown.getItems().addAll("Candlestick");
        chartTypeDropdown.setOnAction(event -> updateChart());

        chartTypeDropdown.setValue("Candlestick");
        updateChart();
    }

    public void updateChart() {
        String selectedType = chartTypeDropdown.getValue();
        chartContainer.getChildren().clear();

        if ("Candlestick".equals(selectedType)) {
            currentChart = createCandlestickChartWithStocks();
        }

        if (currentChart != null) {
            chartContainer.getChildren().add(currentChart);
        }
    }

    private Node createCandlestickChartWithStocks() {
        DefaultNumericAxis xAxis = new DefaultNumericAxis("Time");
        xAxis.setAxisLabelFormatter(new AxisLabelFormatter() {
            private DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM");

            @Override public Number fromString(String s) { return null; }

            @Override public TickUnitSupplier getTickUnitSupplier() {
                return new DefaultTickUnitSupplier();
            }

            @Override public void setTickUnitSupplier(TickUnitSupplier tickUnitSupplier) {}

            @Override public ObjectProperty<TickUnitSupplier> tickUnitSupplierProperty() {
                return new SimpleObjectProperty<>();
            }

            @Override public String toString(Number value) {
                long seconds = value.longValue(); // <-- ACHTUNG: Sekundengenau!
                LocalDateTime time = Instant.ofEpochSecond(seconds)
                        .atZone(ZoneId.systemDefault())
                        .toLocalDateTime();
                return formatter.format(time);
            }

            @Override public void updateFormatter(DoubleArrayList ticks, double scale) {
                if (ticks.isEmpty()) return;
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
        XYChart chart = new XYChart(xAxis, yAxis);
        chart.setTitle("Candlestick Chart mit Stock-Daten");

        List<BaseBar> bars = TestingUtils.generateTestBars(30);
        List<IOhlcvItem> items = bars.stream()
                .map(BarOhlcvAdapter::new)
                .map(item -> (IOhlcvItem) item)
                .collect(Collectors.toList());

        SimpleOhlcv ohlcv = new SimpleOhlcv();
        ohlcv.addAll(items);

        OhlcvDataSet dataSet = new OhlcvDataSet("Stock Dataset");
        dataSet.setData(ohlcv);

        chart.getRenderers().setAll(new CandleStickRenderer());
        chart.getDatasets().setAll(dataSet);

        // 🔥 SMA hinzufügen for Testing
        addSMAOverlay(chart, bars, 14, "SMA 14");

        addDebugGrid(chart);

        chart.getPlugins().add(new Zoomer());
        chart.setStyle(FinancialTheme.Default.name());

        chart.setPrefSize(Region.USE_COMPUTED_SIZE, Region.USE_COMPUTED_SIZE);
        return chart;
    }

    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

    private void addSMAOverlay(XYChart chart, List<BaseBar> bars, int period, String name) {
        // TA4J-Serie aufbauen
        BarSeries series = new BaseBarSeries("SMA Series");
        bars.forEach(series::addBar);

        // SMA berechnen
        SMAIndicator sma = new SMAIndicator(new ClosePriceIndicator(series), period);

        // Zeit und SMA-Werte extrahieren
        DoubleArrayList x = new DoubleArrayList();
        DoubleArrayList y = new DoubleArrayList();

        for (int i = 0; i < series.getBarCount(); i++) {
            long seconds = series.getBar(i).getEndTime().toEpochSecond(); // ACHTUNG: in Sekunden!
            x.add(seconds);
            y.add(sma.getValue(i).doubleValue());
        }

        // In Arrays umwandeln
        double[] xArr = Arrays.copyOf(x.elements(), x.size());
        double[] yArr = Arrays.copyOf(y.elements(), y.size());

        // Dataset anlegen
        DefaultDataSet dataSet = new DefaultDataSet(name);
        dataSet.set(xArr, yArr);

        // Renderer vorbereiten
        ReducingLineRenderer lineRenderer = new ReducingLineRenderer();
        lineRenderer.setMaxPoints(1000);
        lineRenderer.setStyle("-fx-stroke: blue; -fx-stroke-width: 2;"); // Auffälliges Blau

        // Dataset direkt zuweisen (‼️)
        lineRenderer.getDatasets().add(dataSet);

        // Zum Chart hinzufügen
        chart.getRenderers().add(lineRenderer);
    }



    private void addDebugGrid(XYChart chart) {
        GridRenderer grid = new GridRenderer(chart);
        grid.setDrawOnTop(true); // damit es sichtbar bleibt, egal was passiert
        chart.getRenderers().add(grid);
    }










}
