import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.stage.Stage;


public class Graphs extends Application {

    private double step = 0.01;
    private double epsMin = 0.001;

    @Override
    public void start(Stage stage) {
        stage.setTitle("График зависимости количества вычислений минимизируемой функции от логарифма задаваемой точности epsilon");
        final NumberAxis xAxis = new NumberAxis();
        final NumberAxis yAxis = new NumberAxis();
        xAxis.setLabel("Log(eps)");
        yAxis.setLabel("Amount");
        final LineChart<Number, Number> lineChart = new LineChart<>(xAxis, yAxis);
        XYChart.Series dichotomySeries = new XYChart.Series();
        XYChart.Series goldenRatioSeries = new XYChart.Series();
        XYChart.Series fibonacciSeries = new XYChart.Series();
        dichotomySeries.setName("Dichotomy Method");
        goldenRatioSeries.setName("Golden Ratio Method");
        fibonacciSeries.setName("Fibonacci Method");
        for (double epsilon = 0.1; epsilon >= epsMin; epsilon -= step) {
            DichotomyMethod dichotomyMethod = new DichotomyMethod(epsilon);
            GoldenRatio goldenRatio = new GoldenRatio(epsilon);
            FibonacciMethod fibonacciMethod = new FibonacciMethod(epsilon, 0.01);
            dichotomySeries.getData().add(new XYChart.Data(Math.log(epsilon), dichotomyMethod.getCounter()));
            goldenRatioSeries.getData().add(new XYChart.Data(Math.log(epsilon), goldenRatio.getCounter()));
            fibonacciSeries.getData().add(new XYChart.Data(Math.log(epsilon), fibonacciMethod.getCounter()));
        }

        Scene scene = new Scene(lineChart, 800, 600);
        lineChart.getData().add(dichotomySeries);
        lineChart.getData().add(goldenRatioSeries);
        lineChart.getData().add(fibonacciSeries);

        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
