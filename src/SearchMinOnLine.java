import java.util.Vector;

public class SearchMinOnLine {

    private double x0, x1;
    private double sigma;
    private double h, k;
    private double currX, prevX, nextX;
    private double prevL, currL;
    double[] res;
    GivenFunction function;
    private Vector<Vector<Double>> data = new Vector<>();


    SearchMinOnLine(double x0, double sigma) {
        this.x0 = x0;
        this.sigma = sigma;
        function = new GivenFunction();
        defineDirection();
        calculate();
    }

    Vector<Vector<Double>> getData() {
        return data;
    }

    double getCounter() {
        return k;
    }

    void putDataInRow() {
        Vector<Double> row = new Vector<>();
        row.add(k);
        row.add(h);
        row.add(prevX);
        row.add(nextX);
        row.add(Math.abs(this.prevX - this.nextX));
        row.add(currL / prevL);
        row.add(function.f(currX));
        data.add(row);
    }

    void defineDirection() {
        if (function.f(this.x0) > function.f(this.x0 + this.sigma)) {
            this.x1 = x0 + sigma;
            this.h = sigma;
        } else if (function.f(this.x0) > function.f(this.x0 - this.sigma)) {
            this.x1 = x0 - sigma;
            this.h = -sigma;
        } else {
            this.prevX = x0 - sigma;
            this.x1 = x0 + sigma;
        }
    }

    void calculate() {
        currX = x0;
        nextX = x1;
        currL = 0;
        prevL = 0;

        while (true) {
            if (function.f(currX) > function.f(nextX))
                k++;
            else
                break;

            this.h = h * 2;
            prevX = currX;
            currX = nextX;
            nextX = nextX + h;

            prevL = currL;
            currL = Math.abs(nextX - prevX);
            putDataInRow();
        }
    }

    double[] getResult() {
        res = new double[]{this.prevX, this.nextX};
        return res;
    }


}
