import java.util.function.Function;

/**
 * Main
 */
public class Main {

    /*
     * public static void main(String[] args) {
     * float x = 24;
     * 
     * System.out.println("Temp is = " + x + "C or " + new TempConverter().apply(x)
     * + " F");
     * }
     * 
     */

    // public static void main(String[] args) {

    // float x = 24;
    // float out = new Function<Float, Float>() {
    // @Override
    // public Float apply(Float celsius) {
    // return (celsius * 9 / 5) + 32;
    // }
    // }.apply(x);

    // System.out.println("Temp is = " + x + "C or " + out + " F");
    // ;
    // }

    public static void main(String[] args) {
        QuadEq eq = new QuadEq(1, 1, 1);
        eq.calcX();
        eq.setParams(1, 5, 2);
        eq.calcX();
    }

}