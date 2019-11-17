import java.util.Vector;

public class GivenFunctionForGradient {

    //var 5
    double f(Vector<Double> xGivenArray) {
        return Math.pow((1.5 - xGivenArray.get(0) * (1 - xGivenArray.get(1))), 2) + Math.pow((2.25 - xGivenArray.get(0) * (1 - xGivenArray.get(1) * xGivenArray.get(1))), 2) + Math.pow((2.625 - xGivenArray.get(0) * (1 - Math.pow(xGivenArray.get(1), 3))), 2);
    }

    private double df(int index, Vector<Double> x, double eps) {
        Vector<Double> xNewArray = new Vector<>();
        for (int i = 0; i < x.size(); i++) {
            xNewArray.add(i, x.get(i));
        }
        xNewArray.set(index, x.get(index) + eps);
        return (f(xNewArray) - f(x)) / eps;
    }

    Vector<Double> nabOperator(Vector<Double> x, double eps) {
        Vector<Double> nab = new Vector<>();
        for (int i = 0; i < x.size(); i++) {
            nab.add(i, df(i, x, eps));
        }
        double norm = getNorm(nab);
        for (int i = 0; i < nab.size(); i++) {
            nab.set(i, nab.get(i) / norm);
        }
        return nab;
    }

    private double getNorm(Vector<Double> x) {
        double res = 0;
        for (int i = 0; i < x.size(); i++) {
            res += x.get(i) * x.get(i);
        }
        return Math.sqrt(res);
    }

//    Vector<Double> directionVector(Vector<Double> x, double eps) {
//        Vector<Double> nab = nabOperator(x, eps);
//        double norm = getNorm(nab);
//        Vector<Double> directionVector = new Vector<>();
//        for (int i = 0; i < nab.size(); i++) {
//            directionVector.add(i, nab.get(i) / norm);
//        }
//        return directionVector;
//    }

    private double dx1(Vector<Double> x) {
        return -12.75 + 3 * x.get(1) + 4.5 * x.get(1) * x.get(1) + 5.25 * Math.pow(x.get(1), 3) + 2 * x.get(0) * (3 - 2 * x.get(1) - 1 * x.get(1) * x.get(1) - 2 * Math.pow(x.get(1), 3) + Math.pow(x.get(1), 4) + Math.pow(x.get(1), 6));
    }

    private double dx2(Vector<Double> x) {
        return x.get(0) * (x.get(0) * (6 * Math.pow(x.get(1), 5) + 4 * Math.pow(x.get(1), 3) - 6 * x.get(1) * x.get(1) - 2) + 15.75 * x.get(1) * x.get(1) + 9 * x.get(1) + 3);
    }

    Vector<Double> directionVector2(Vector<Double> x) {
        Vector<Double> sk = new Vector<>();
        double norm = Math.sqrt(dx1(x) * dx1(x) + dx2(x) * dx2(x));
        sk.add(0, dx1(x) / norm);
        sk.add(1, dx2(x) / norm);
        return sk;
    }

}
