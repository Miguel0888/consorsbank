
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
import org.ta4j.core.indicators.bollinger.BollingerBandFacade;
import org.ta4j.core.indicators.bollinger.BollingerBandsLowerIndicator;
import org.ta4j.core.indicators.bollinger.BollingerBandsMiddleIndicator;
import org.ta4j.core.indicators.bollinger.BollingerBandsUpperIndicator;
import org.ta4j.core.indicators.helpers.ClosePriceIndicator;
import org.ta4j.core.indicators.pivotpoints.PivotPointIndicator;
import util.TestingUtils;
import consorsbank.model.chart.BarOhlcvAdapter;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.ta4j.core.indicators.pivotpoints.TimeLevel;

public class ChartController {

    @FXML
    private ToolBar toolbar;

    @FXML
    private ComboBox<String> chartTypeDropdown;

    @FXML
    private ComboBox<String> indicatorDropdown;

    @FXML
    private StackPane chartContainer;

    private Node currentChart;

    public void initialize() {
        // Werte setzen – das MUSS vor getValue() passieren!
        chartTypeDropdown.getItems().addAll("Candlestick");
        chartTypeDropdown.setValue("Candlestick");

        indicatorDropdown.getItems().addAll("SMA", "EMA", "RSI", "MACD", "BOLL", "PIVOT");
        indicatorDropdown.setValue("BOLL");

        // Optional: Stil
        chartTypeDropdown.setStyle("-fx-font-size: 13px;");
        indicatorDropdown.setStyle("-fx-font-size: 13px;");

        // Events setzen
        chartTypeDropdown.setOnAction(e -> updateChart());
        indicatorDropdown.setOnAction(e -> updateChart());

        // Starte mit initialer Anzeige
        updateChart();
    }


    public void updateChart() {
        chartContainer.getChildren().clear();

        String chartType = chartTypeDropdown.getValue();
        String indicator = indicatorDropdown.getValue();

        if ("Candlestick".equals(chartType)) {
            currentChart = createCandlestickChartWithStocks(indicator);
        }

        if (currentChart != null) {
            chartContainer.getChildren().add(currentChart);
        }
    }

    private Node createCandlestickChartWithStocks(String indicatorName){
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
//        addSMAOverlay(chart, bars, 14, "SMA 14");
//        addDebugGrid(chart);
        addIndicatorOverlay(chart, bars, indicatorName);

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


    private void addIndicatorOverlay(XYChart chart, List<BaseBar> bars, String indicatorName) {
        BarSeries series = new BaseBarSeries("TA4J Series");
        bars.forEach(series::addBar);

        int period = 14;
        double bollK = 2.0;

        var closePrice = new ClosePriceIndicator(series);

        // Bollinger optional vorbereiten
        BollingerBandFacade boll = null;
        if ("BOLL".equals(indicatorName)) {
            boll = new BollingerBandFacade(series, period, bollK);
        }

        // Pivot optional vorbereiten
        var pivot = "PIVOT".equals(indicatorName)
                ? new org.ta4j.core.indicators.pivotpoints.PivotPointIndicator(series, TimeLevel.DAY)
                : null;

        DoubleArrayList x = new DoubleArrayList();
        DoubleArrayList y1 = new DoubleArrayList(); // z. B. SMA, BOLL middle
        DoubleArrayList y2 = new DoubleArrayList(); // BOLL upper
        DoubleArrayList y3 = new DoubleArrayList(); // BOLL lower

        for (int i = 0; i < series.getBarCount(); i++) {
            long seconds = series.getBar(i).getEndTime().toEpochSecond();
            x.add(seconds);

            switch (indicatorName) {
                case "SMA" -> y1.add(new SMAIndicator(closePrice, period).getValue(i).doubleValue());
                case "EMA" -> y1.add(new org.ta4j.core.indicators.EMAIndicator(closePrice, period).getValue(i).doubleValue());
                case "RSI" -> y1.add(new org.ta4j.core.indicators.RSIIndicator(closePrice, period).getValue(i).doubleValue());
                case "MACD" -> y1.add(new org.ta4j.core.indicators.MACDIndicator(closePrice, 12, 26).getValue(i).doubleValue());
                case "PIVOT" -> y1.add(pivot.getValue(i).doubleValue());
                case "BOLL" -> {
                    y1.add(boll.middle().getValue(i).doubleValue());
                    y2.add(boll.upper().getValue(i).doubleValue());
                    y3.add(boll.lower().getValue(i).doubleValue());
                }
                default -> y1.add(0.0);
            }
        }

        double[] xArr = toArray(x);

        // Standardlinie zeichnen
        drawOverlay(chart, xArr, toArray(y1), indicatorName + " - main", "-fx-stroke: green; -fx-stroke-width: 2;");

        // BOLL: Extra-Linien
        if ("BOLL".equals(indicatorName)) {
            drawOverlay(chart, xArr, toArray(y2), "BOLL - upper", "-fx-stroke: orange; -fx-stroke-dash-array: 6 4;");
            drawOverlay(chart, xArr, toArray(y3), "BOLL - lower", "-fx-stroke: orange; -fx-stroke-dash-array: 6 4;");
        }
    }


    private double[] toArray(DoubleArrayList list) {
        return Arrays.copyOf(list.elements(), list.size());
    }


    private void addLineToChart(XYChart chart, DoubleArrayList x, DoubleArrayList y, String name, String color) {
        double[] xArr = Arrays.copyOf(x.elements(), x.size());
        double[] yArr = Arrays.copyOf(y.elements(), y.size());

        DefaultDataSet dataSet = new DefaultDataSet(name);
        dataSet.set(xArr, yArr);

        ReducingLineRenderer renderer = new ReducingLineRenderer();
        renderer.setMaxPoints(1000);
        renderer.setStyle("-fx-stroke: " + color + "; -fx-stroke-width: 2;");
        renderer.getDatasets().add(dataSet);

        chart.getRenderers().add(renderer);
    }


    private void drawOverlay(XYChart chart, double[] x, double[] y, String name, String style) {
        DefaultDataSet dataSet = new DefaultDataSet(name);
        dataSet.set(x, y);

        ReducingLineRenderer renderer = new ReducingLineRenderer();
        renderer.setMaxPoints(1000);
        renderer.setStyle(style);
        renderer.getDatasets().add(dataSet);

        chart.getRenderers().add(renderer);
    }


    private void addDebugGrid(XYChart chart) {
        GridRenderer grid = new GridRenderer(chart);
        grid.setDrawOnTop(true); // damit es sichtbar bleibt, egal was passiert
        chart.getRenderers().add(grid);
    }










}
