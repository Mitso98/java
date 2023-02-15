import task1.StringUtils;

public class Main {
    public static void main(String[] args) {

        String s1 = "hi";
        String s2 = "hello";

        String result = StringUtils.betterString(s1, s2, (st1, st2) -> false);

        System.out.println(result);
    }
}
