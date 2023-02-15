package task1;

public class StringUtils {

    @FunctionalInterface
    public interface StringUtilsInterface<T> {
        public Boolean betterString(T s1, T s2);
    }

    public static String betterString(String s1, String s2, StringUtilsInterface<String> value) {

        if (value.betterString(s1, s2)) {
            return s1;
        }

        return s2;
    }

}
