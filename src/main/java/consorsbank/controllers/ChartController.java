
package consorsbank.controllers;

import consorsbank.models.Stock;
import io.fair_acc.chartfx.XYChart;
import io.fair_acc.chartfx.axes.spi.DefaultNumericAxis;
import io.fair_acc.chartfx.plugins.Zoomer;
import io.fair_acc.chartfx.renderer.spi.financial.CandleStickRenderer;
import io.fair_acc.chartfx.renderer.spi.financial.FinancialTheme;
import io.fair_acc.dataset.spi.financial.OhlcvDataSet;
import io.fair_acc.dataset.spi.financial.api.ohlcv.IOhlcvItem;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.ComboBox;
import javafx.scene.control.ToolBar;
import javafx.scene.layout.Region;
import javafx.scene.layout.StackPane;
import util.TestingUtils;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

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
        DefaultNumericAxis yAxis = new DefaultNumericAxis("Price");

        XYChart chart = new XYChart(xAxis, yAxis);
        chart.setTitle("Candlestick Chart mit Stock-Daten");

        // Beispieldaten – später durch echte Kursdaten ersetzen
        List<IOhlcvItem> stocks = TestingUtils.generateTestStocks(30); // 30 Tage z.B.

        // Dataset befüllen
        SimpleOhlcv ohlcv = new SimpleOhlcv();
        ohlcv.addAll(stocks); // stocks ist List<Stock>, und Stock implements IOhlcvItem

        OhlcvDataSet dataSet = new OhlcvDataSet("Stock Dataset");
        dataSet.setData(ohlcv);

        chart.getRenderers().setAll(new CandleStickRenderer());
        chart.getDatasets().setAll(dataSet);
        chart.getPlugins().add(new Zoomer());
        chart.setStyle(FinancialTheme.Default.name());

        chart.setPrefSize(Region.USE_COMPUTED_SIZE, Region.USE_COMPUTED_SIZE);

        return chart;
    }
}
