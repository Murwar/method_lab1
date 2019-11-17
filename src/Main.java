import java.util.Vector;

public class Main {

    public static void main(String[] args) {

       // new Tables();
        
        /*SearchMinOnLine searchMinOnLine = new SearchMinOnLine(-10, 0.01);
        System.out.println("xPrev = " + searchMinOnLine.getResult()[0] + "    " + "xNext = " + searchMinOnLine.getResult()[1]);

        DichotomyMethod dichotomyMethod = new DichotomyMethod(0.01);
        GoldenRatio goldenRatio = new GoldenRatio(0.01);
        FibonacciMethod fibonacciMethod = new FibonacciMethod(0.01);
        System.out.println(dichotomyMethod.getResult() + " " + goldenRatio.getResult() + " " + fibonacciMethod.getResult());
*/

        Vector<Double> xArray = new Vector<>();
        xArray.add(0, 30.0);
        xArray.add(1, -50.02);


        GradientDescent gradientDescent = new GradientDescent(xArray, 1e-6, 1e-6);
        System.out.println(gradientDescent.calculate());
    }
}
