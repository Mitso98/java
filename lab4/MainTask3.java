
import task3.*;

public class MainTask3 {
    public static void main(String[] args) {
        Complex<Double> c1 = new DoubleComplex(5, 10);
        Complex<Double> c2 = new DoubleComplex(5, 10);

        System.out.println(c1.getImg() + " : " + c1.getReal());
        c2 = c1.add(c2);
        System.out.println(c2.getImg() + " : " + c2.getReal());
    }
}
