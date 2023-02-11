public class QuadEq {
    private double a, b, c = 0;

    QuadEq(double a, double b, double c) {
        this.setParams(a, b, c);
    }

    public void setParams(double a, double b, double c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }

    public void calcX() {
        double d = (b * b) - (4 * a * c);
        if (d > 0.0) {
            double r1 = (-b + Math.pow(d, 0.5)) / (2.0 * a);
            double r2 = (-b - Math.pow(d, 0.5)) / (2.0 * a);
            System.out.println("The roots are " + r1 + " and " + r2);
        } else if (d == 0.0) {
            double r1 = -b / (2.0 * a);
            System.out.println("The root is " + r1);
        } else {
            System.out.println("Roots are not real.");
        }
    }
}
