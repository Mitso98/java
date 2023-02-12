import task1.*;

public class MainTask1 {
    public static void main(String[] args) {
        Calculator calc = new Calculator();

        try {
            calc.divide(5, 0);
        } catch (CustomEx e) {
            System.out.println(e);
        }
    }
}
