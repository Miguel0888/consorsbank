package consorsbank.controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.chart.*;
import javafx.scene.control.ComboBox;
import javafx.scene.control.ToolBar;
import javafx.scene.layout.Pane;

public class ChartController {

    @FXML
    private ToolBar toolbar;

    @FXML
    private ComboBox<String> chartTypeDropdown;

    @FXML
    private Pane chartContainer;

    private XYChart<String, Number> currentChart;

    public void initialize() {
        // Dropdown mit Diagrammtypen füllen
        chartTypeDropdown.getItems().addAll("Candlestick", "Bar", "Dot", "Line", "Step", "Mountain");

        // Event-Handler für die Dropdown-Auswahl
        chartTypeDropdown.setOnAction(event -> updateChart());

        // Standardmäßig Line-Diagramm anzeigen
        chartTypeDropdown.setValue("Line");
        updateChart();
    }

    public void updateChart() {
        String selectedType = chartTypeDropdown.getValue();

        // Bestehendes Diagramm entfernen
        chartContainer.getChildren().clear();

        // Diagramm basierend auf der Auswahl erstellen
        switch (selectedType) {
            case "Line":
                currentChart = createLineChart();
                break;
            case "Candlestick":
                currentChart = createCandlestickChart();
                break;
            case "Bar":
                currentChart = createBarChart();
                break;
            case "Dot":
                currentChart = createDotChart();
                break;
            case "Step":
                currentChart = createStepChart();
                break;
            case "Mountain":
                currentChart = createMountainChart();
                break;
        }

        // Diagramm hinzufügen
        if (currentChart != null) {
            chartContainer.getChildren().add(currentChart);
        }
    }

    // Methoden für die Erstellung von Diagrammen bleiben unverändert
    private LineChart<String, Number> createLineChart() {
        LineChart<String, Number> lineChart = new LineChart<>(new CategoryAxis(), new NumberAxis());
        lineChart.setTitle("Line Chart");

        XYChart.Series<String, Number> series = new XYChart.Series<>();
        series.setName("Beispieldaten");
        series.getData().add(new XYChart.Data<>("1", 100));
        series.getData().add(new XYChart.Data<>("2", 110));
        series.getData().add(new XYChart.Data<>("3", 105));
        lineChart.getData().add(series);

        return lineChart;
    }

    private BarChart<String, Number> createBarChart() {
        BarChart<String, Number> barChart = new BarChart<>(new CategoryAxis(), new NumberAxis());
        barChart.setTitle("Bar Chart");

        XYChart.Series<String, Number> series = new XYChart.Series<>();
        series.setName("Beispieldaten");
        series.getData().add(new XYChart.Data<>("1", 100));
        series.getData().add(new XYChart.Data<>("2", 110));
        series.getData().add(new XYChart.Data<>("3", 105));
        barChart.getData().add(series);

        return barChart;
    }

    private XYChart<String, Number> createCandlestickChart() {
        // Eine Implementierung für Candlestick mit einer ChartFX-Library oder benutzerdefiniert kann hier integriert werden
        LineChart<String, Number> dummyChart = new LineChart<>(new CategoryAxis(), new NumberAxis());
        dummyChart.setTitle("Candlestick Chart (Platzhalter)");

        XYChart.Series<String, Number> series = new XYChart.Series<>();
        series.getData().add(new XYChart.Data<>("1", 100));
        series.getData().add(new XYChart.Data<>("2", 110));
        series.getData().add(new XYChart.Data<>("3", 105));
        dummyChart.getData().add(series);

        return dummyChart;
    }

    private LineChart<String, Number> createDotChart() {
        LineChart<String, Number> dotChart = new LineChart<>(new CategoryAxis(), new NumberAxis());
        dotChart.setTitle("Dot Chart");
        dotChart.setStyle("-fx-symbols-visible: true;"); // Punkte sichtbar machen

        XYChart.Series<String, Number> series = new XYChart.Series<>();
        series.getData().add(new XYChart.Data<>("1", 100));
        series.getData().add(new XYChart.Data<>("2", 110));
        series.getData().add(new XYChart.Data<>("3", 105));
        dotChart.getData().add(series);

        return dotChart;
    }

    private LineChart<String, Number> createStepChart() {
        LineChart<String, Number> stepChart = new LineChart<>(new CategoryAxis(), new NumberAxis());
        stepChart.setTitle("Step Chart");

        XYChart.Series<String, Number> series = new XYChart.Series<>();
        series.getData().add(new XYChart.Data<>("1", 100));
        series.getData().add(new XYChart.Data<>("2", 110));
        series.getData().add(new XYChart.Data<>("3", 105));
        stepChart.getData().add(series);

        return stepChart;
    }

    private LineChart<String, Number> createMountainChart() {
        LineChart<String, Number> mountainChart = new LineChart<>(new CategoryAxis(), new NumberAxis());
        mountainChart.setTitle("Mountain Chart");
        mountainChart.setStyle("-fx-area-fill: lightblue;");

        XYChart.Series<String, Number> series = new XYChart.Series<>();
        series.getData().add(new XYChart.Data<>("1", 100));
        series.getData().add(new XYChart.Data<>("2", 110));
        series.getData().add(new XYChart.Data<>("3", 105));
        mountainChart.getData().add(series);

        return mountainChart;
    }
}
