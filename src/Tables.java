import javax.swing.*;
import java.util.Vector;

public class Tables extends JFrame {

    DichotomyMethod dichotomyMethod = new DichotomyMethod(0.01);
    GoldenRatio goldenRatio = new GoldenRatio(0.01);
    FibonacciMethod fibonacciMethod = new FibonacciMethod(0.01, 0.01);
    private Object[] columnsHeader = new String[]{"i", "ai", "bi", "ai/bi", "x1", "x2", "f(x1)", "f(x2)"};

    public Tables() {
        super("Таблица с результатами исследований");
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        Vector<String> header = new Vector<>();
        Vector<Vector<Double>> dataFromDichotomyMethod = dichotomyMethod.getData();
        Vector<Vector<Double>> dataFromGoldenRatio = goldenRatio.getData();
        Vector<Vector<Double>> dataFromFibonacciMethod = fibonacciMethod.getData();

        for (int i = 0; i < columnsHeader.length; i++) {
            header.add((String) columnsHeader[i]);
        }

        JTable dichotomyTable = new JTable(dataFromDichotomyMethod, header);
        JTable goldenRatioTable = new JTable(dataFromGoldenRatio, header);
        JTable fibonacciTable = new JTable(dataFromFibonacciMethod, header);

        Box contents = new Box(BoxLayout.Y_AXIS);
        contents.add(new JScrollPane(dichotomyTable));
        contents.add(new JScrollPane(goldenRatioTable));
        contents.add(new JScrollPane(fibonacciTable));

        setContentPane(contents);
        setSize(500, 400);
        setVisible(true);
    }
}
