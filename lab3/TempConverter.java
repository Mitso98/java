import java.util.function.Function;

public class TempConverter implements Function<Float, Float> {
    @Override
    public Float apply(Float celsius) {
        return (celsius * 9 / 5) + 32;
    }
}
