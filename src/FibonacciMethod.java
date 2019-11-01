import java.util.Vector;

public class FibonacciMethod {

    private int n = 0;
    private int counter = 0;
    private double a, b, x1, x2, eps, l; //l -длина конечного интервала, eps - константа различимости
    private GivenFunction function;
    private Vector<Vector<Double>> data = new Vector<>();


    FibonacciMethod(double eps, double l) {
        this.eps = eps;
        this.l = l;
        this.function = new GivenFunction();
        this.a = function.getA();
        this.b = function.getB();
        findN();
        calculate();
    }

    void findN() {
        double L0 = b - a;
        while (fibonacciFunction(n) <= L0 / l)
            n++;
    }

    double fibonacciFunction(int n) {
        return 1 / Math.sqrt(5) * (Math.pow((1 + Math.sqrt(5)) / 2, n) - Math.pow((1 - Math.sqrt(5)) / 2, n));
    }

    void findX1(int k) {
        double fibN = fibonacciFunction(n - k);
        double fibN2 = fibonacciFunction(n - k - 2);
        this.x1 = this.a + (fibN2 / fibN) * (b - a);
    }

    void findX2(int k) {
        double fibN = fibonacciFunction(n - k);
        double fibN1 = fibonacciFunction(n - k - 1);
        this.x2 = this.a + fibN1 / fibN * (b - a);
    }

    //Количество вычислений минимизируемой функции
    double getCounter() {
        return this.counter;
    }

    Vector<Vector<Double>> getData() {
        return this.data;
    }

    void putDataInRow() {
        Vector<Double> row = new Vector<>();
        row.add(Double.valueOf(counter));
        row.add(this.a);
        row.add(this.b);
        row.add(this.a / this.b);
        row.add(this.x1);
        row.add(this.x2);
        row.add(this.function.f(x1));
        row.add(this.function.f(x2));
        data.add(row);
    }

    void calculate() {
        findX1(counter);
        findX2(counter);
        putDataInRow();
        while (counter != n - 2) {

            //Ищем, на каком интервале находится искомый минимум
            if (function.f(x1) > function.f(x2)) {
                this.a = x1;
                this.x1 = x2;
                findX2(counter);
            } else {
                this.b = x2;
                this.x2 = x1;
                findX1(counter);
            }
            counter++;
            putDataInRow();
        }
        x2 = x1 + eps;
        if (function.f(x1) > function.f(x2))
            a = x1;
        else if (function.f(x1) < function.f(x2))
            b = x2;
        else {
            a = x1;
            b = x2;
        }
        counter++;
        putDataInRow();
    }
}
