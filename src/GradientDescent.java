import java.util.Vector;

public class GradientDescent {

    private double epsF; //точность по функции
    private double epsI; //точность по переменным
    private double lambda;
    GivenFunctionForGradient functionForGradient;
    Vector<Double> xCurr = new Vector<>();
    Vector<Double> xNext = new Vector<>();

    GradientDescent(Vector<Double> x0, double epsF, double epsI) {
        this.epsF = epsF;
        this.epsI = epsI;
        xCurr.addAll(x0);
        xNext.addAll(x0);
        functionForGradient = new GivenFunctionForGradient();
    }


    double getDist(Vector<Double> currX, Vector<Double> nextX) {
        double res = -1;
        for (int i = 0; i < currX.size(); i++) {
            res += Math.pow((nextX.get(i) - currX.get(i)), 2);
        }
        return Math.sqrt(res);
    }

    Vector<Double> calculate() {
        int counter = 0;
        GoldenRatio goldenRatio = new GoldenRatio(0.01);
        Vector<Double> xStart = new Vector<>(xCurr);
        for (;;) {
            Vector<Double> Sk = functionForGradient.nabOperator(xCurr, 0.01);
            lambda = goldenRatio.argmin(xStart, Sk, 1e-8, 1, 1e-2);
            for (int i = 0; i < xCurr.size(); i++) {
                xNext.set(i, xCurr.get(i) - lambda * Sk.get(i));
            }

//            if (functionForGradient.f(xNext) >= functionForGradient.f(xCurr)) {
//                for (int i = 0; i < xCurr.size(); i++) {
//                    xNext.set(i, xCurr.get(i) + lambda * Sk.get(i));
//                }
//            }
            counter++;
            if (Math.abs(functionForGradient.f(xNext) - functionForGradient.f(xCurr)) < epsF || getDist(xCurr, xNext) < epsI) {
                System.out.println(counter);
                return xNext;
            }

            for (int i = 0; i < xCurr.size(); i++) {
                xCurr.set(i, xNext.get(i));
            }
        }
    }
}
