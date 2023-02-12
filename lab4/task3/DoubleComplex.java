package task3;

public class DoubleComplex implements Complex<Double> {
    double real;
    double img;

    public DoubleComplex(double img, double real) {
        this.setParams(img, real);
    }

    @Override
    public Double getImg() {
        return this.img;
    }

    @Override
    public Double getReal() {
        return this.real;
    }

    public void setParams(double img, double real) {
        this.real = real;
        this.img = img;
    }

    @Override
    public Complex<Double> add(Complex<Double> x) {
        double img = x.getImg() + this.img;
        double real = x.getReal() + this.real;

        Complex<Double> tmp = new DoubleComplex(img, real);

        return tmp;
    }

    @Override
    public Complex<Double> subtract(Complex<Double> x) {
        double img = x.getImg() - this.img;
        double real = x.getReal() - this.real;

        Complex<Double> tmp = new DoubleComplex(img, real);

        return tmp;
    }

    @Override
    public Complex<Double> divide(Complex<Double> x) {
        double img = x.getImg() / this.img;
        double real = x.getReal() / this.real;

        Complex<Double> tmp = new DoubleComplex(img, real);

        return tmp;
    }

    @Override
    public Complex<Double> product(Complex<Double> x) {
        double img = x.getImg() * this.img;
        double real = x.getReal() * this.real;

        Complex<Double> tmp = new DoubleComplex(img, real);

        return tmp;
    }
}
