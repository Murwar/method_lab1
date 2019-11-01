import java.util.Vector;

public class GoldenRatio {
    private double epsilon;
    private double counter = 0;
    private double a, b, x1, x2;
    private GivenFunction function;
    private Vector<Vector<Double>> data = new Vector<>();

    GoldenRatio(double epsilon) {
        this.epsilon = epsilon;
        function = new GivenFunction();
        this.a = function.getA();
        this.b = function.getB();
        calculate();
    }

    void findX1(double ai, double bi) {
        x1 = ai + (3 - Math.sqrt(5)) / 2 * (bi - ai);
    }

    void findX2(double ai, double bi) {
        x2 = ai + (Math.sqrt(5) - 1) / 2 * (bi - ai);
    }

    double getCounter() {
        return counter;
    }

    Vector<Vector<Double>> getData() {
        return data;
    }

    void putDataInRow() {
        Vector<Double> row = new Vector<>();
        row.add(counter);
        row.add(a);
        row.add(b);
        row.add(a / b);
        row.add(x1);
        row.add(x2);
        row.add(function.f(x1));
        row.add(function.f(x2));
        data.add(row);
    }

    void calculate() {

        findX1(a, b);
        findX2(a, b);
        while (Math.abs(b - a) > epsilon) {

            //Добавляем данные в вектор для таблицы в отчет
            putDataInRow();

            //Ищем, на каком интервале находится искомый минимум
            if (function.f(x1) >= function.f(x2)) {
                a = x1;
                x1 = x2;
                findX2(a, b);
            } else {
                b = x2;
                x2 = x1;
                findX1(a, b);
            }
            counter++;
        }
        putDataInRow();
    }
}