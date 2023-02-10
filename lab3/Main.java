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

    public static void main(String[] args) {

        float x = 24;
        float out = new Function<Float, Float>() {
            @Override
            public Float apply(Float celsius) {
                return (celsius * 9 / 5) + 32;
            }
        }.apply(x);

        System.out.println("Temp is = " + x + "C or " + out + " F");
        ;
    }

}