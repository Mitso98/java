package task1;
public class Calculator {
    
    public double divide(double a, double b) throws CustomEx {
        if (a < b)
            throw new CustomEx("A must be bigger than B");
        else if (b == 0)
            throw new CustomEx("You can not divide by zero");
        else if (a < 0 || b < 0)
            throw new CustomEx("This method only handle numbers bigger than 0");

        return a / b;
    }
}
