import java.util.Vector;

public class DichotomyMethod {

    private double sigma;
    private double epsilon;
    private double counter = 0;
    private double a, b, x1, x2;
    private double prevL, currL;
    GivenFunction function;
    private Vector<Vector<Double>> data = new Vector<>();


    DichotomyMethod(double epsilon) {
        this.epsilon = epsilon;
        sigma = epsilon / 4;
        function = new GivenFunction();
        this.a = function.getA();
        this.b = function.getB();
        this.currL = function.getDist();
        this.prevL = function.getDist();
        calculate();
    }

    void findX1(double ai, double bi) {
        x1 = (ai + bi) / 2 - sigma;
    }

    void findX2(double ai, double bi) {
        x2 = (ai + bi) / 2 + sigma;
    }

    //Количество вычислений минимизируемой функции
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
        row.add(Math.abs(this.b-this.a));
        row.add(currL/prevL);
        row.add(x1);
        row.add(x2);
        row.add(function.f(x1));
        row.add(function.f(x2));
        data.add(row);
    }

    void calculate() {
        while (b - a > epsilon) {
            findX1(a, b);
            findX2(a, b);

            //Добавляем данные в вектор для таблицы в отчет
            putDataInRow();

            //Ищем, на каком интервале находится искомый минимум
            if (function.f(x1) > function.f(x2))
                a = x1;
            else if (function.f(x1) < function.f(x2))
                b = x2;
            else {
                a = x1;
                b = x2;
            }

            counter++;
            prevL = currL;
            currL = Math.abs(b - a);
        }
        putDataInRow();
    }
}
