import java.util.Vector;

public class GradientDescent {

    private double x0;
    private double epsF;
    private double epsI;
    private double k;
    GivenFunctionForGradient functionForGradient;
    Vector<Double> xArray = new Vector<>();

    GradientDescent(double x0, double epsF, double epsI){
        this.x0 = x0;
        this.epsF = epsF;
        this.epsI = epsI;
        functionForGradient = new GivenFunctionForGradient();
    }


}
