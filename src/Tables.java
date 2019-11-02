import javax.swing.*;
import java.util.Vector;

public class Tables extends JFrame {

    DichotomyMethod dichotomyMethod = new DichotomyMethod(0.01);
    GoldenRatio goldenRatio = new GoldenRatio(0.01);
    FibonacciMethod fibonacciMethod = new FibonacciMethod(0.01);
    SearchMinOnLine searchMinOnLine = new SearchMinOnLine(-10, 0.01);


    private Object[] columnsHeader = new String[]{"i", "ai", "bi", "bi-ai", "currL/prevL", "x1", "x2", "f(x1)", "f(x2)"};
    private Object[] columnsHeaderForSearchMin = new String[]{"i", "h", "xPrev", "xNext", "xPrev-xCurr", "currL/prevL", "f(xCurr)"};

    public Tables() {
        super("Таблица с результатами исследований");
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        Vector<String> headerForMethods = new Vector<>();
        Vector<String> headerForAlgorithm = new Vector<>();
        Vector<Vector<Double>> dataFromDichotomyMethod = dichotomyMethod.getData();
        Vector<Vector<Double>> dataFromGoldenRatio = goldenRatio.getData();
        Vector<Vector<Double>> dataFromFibonacciMethod = fibonacciMethod.getData();
        Vector<Vector<Double>> dataFromSearchMin = searchMinOnLine.getData();

        for (int i = 0; i < columnsHeader.length; i++) {
            headerForMethods.add((String) columnsHeader[i]);
        }

        for (int i = 0; i < columnsHeaderForSearchMin.length; i++) {
            headerForAlgorithm.add((String) columnsHeaderForSearchMin[i]);
        }

        JTable dichotomyTable = new JTable(dataFromDichotomyMethod, headerForMethods);
        JTable goldenRatioTable = new JTable(dataFromGoldenRatio, headerForMethods);
        JTable fibonacciTable = new JTable(dataFromFibonacciMethod, headerForMethods);
        JTable searchMinTable = new JTable(dataFromSearchMin, headerForAlgorithm);

        Box contents = new Box(BoxLayout.Y_AXIS);
        contents.add(new JScrollPane(null));
        contents.add(new JScrollPane(dichotomyTable));
        contents.add(new JScrollPane(null));
        contents.add(new JScrollPane(goldenRatioTable));
        contents.add(new JScrollPane(null));
        contents.add(new JScrollPane(fibonacciTable));
        contents.add(new JScrollPane(null));
        contents.add(new JScrollPane(searchMinTable));

        setContentPane(contents);
        setSize(500, 400);
        setVisible(true);
    }
}
