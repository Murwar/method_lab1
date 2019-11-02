import java.util.Vector;

public class Main {

    public static void main(String[] args) {

        new Tables();

        Vector<Double> xArray = new Vector<>();
        xArray.add(0,5.1);
        xArray.add(1,8.9);
        GivenFunctionForGradient functionForGradient = new GivenFunctionForGradient();
        functionForGradient.f(xArray);
        System.out.println(functionForGradient.getRes());
        /*SearchMinOnLine searchMinOnLine = new SearchMinOnLine(-10, 0.01);
        System.out.println("xPrev = " + searchMinOnLine.getResult()[0] + "    " + "xNext = " + searchMinOnLine.getResult()[1]);

        DichotomyMethod dichotomyMethod = new DichotomyMethod(0.01);
        GoldenRatio goldenRatio = new GoldenRatio(0.01);
        FibonacciMethod fibonacciMethod = new FibonacciMethod(0.01);
        System.out.println(dichotomyMethod.getResult() + " " + goldenRatio.getResult() + " " + fibonacciMethod.getResult());
*/

    }
}
