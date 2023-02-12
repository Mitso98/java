package task3;

public interface Complex<T> {
    public T getReal();

    public T getImg();

    public Complex<T> add(Complex<T> x);

    public Complex<T> subtract(Complex<T> x);

    public Complex<T> product(Complex<T> x);

    public Complex<T> divide(Complex<T> x);

}
