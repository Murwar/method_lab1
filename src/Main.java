
public class Main {

    public static void main(String[] args) {

        DichotomyMethod dichotomyMethod = new DichotomyMethod(0.01);
        //System.out.println(dichotomyMethod.getCounter());

        new Tables();
        SearchMinOnLine searchMinOnLine = new SearchMinOnLine(-10, 0.01);
        System.out.println("xPrev = " + searchMinOnLine.getResult()[0] + "    " + "xNext = " + searchMinOnLine.getResult()[1]);
    }
}
