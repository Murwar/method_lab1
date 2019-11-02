import java.util.Vector;

public class GivenFunctionForGradient {

    private Vector<Double> xArray;
    private double res;
    //var 5
    double f(Vector<Double> xGivenArray) {
        xArray = new Vector<>();
        for(int i = 0; i< xGivenArray.size(); i++){
            this.xArray.add(i,xGivenArray.get(i));
        }
        this.res =  Math.pow(xArray.get(1)-xArray.get(0),2) +100* Math.pow(1-xArray.get(0),2);
        return Math.pow(xArray.get(1)-xArray.get(0),2) +100* Math.pow(1-xArray.get(0),2);
    }

    double getRes(){
        return res;
    }

}
