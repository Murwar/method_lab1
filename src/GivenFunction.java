public class GivenFunction {
    //var 5
    //f(x)=(x+5)^4,
    // x пренадлежит отрезку от -10 до 15

    private double a = -10;
    private double b = 15;

    double f(double x) {
        return Math.pow((x + 5), 4);
    }

    double getA() {
        return a;
    }

    double getB() {
        return b;
    }
}
