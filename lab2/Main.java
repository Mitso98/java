import java.util.ArrayList;
import java.util.Random;

public class Main {
    public static void main(String[] args) {
        // Task1
        // IPCutter cut = new IPCutter("163.121.12.30");
        // ArrayList<String> splitter = cut.doIPSplit('.');
        // ArrayList<String> token = cut.tokenizer('.');

        // for (String s : splitter) {
        // System.out.println(s);
        // }
        // System.out.println();
        // for (String s : token) {
        // System.out.println(s);
        // }

        // Task2
        // CountOccur count = new CountOccur("Hello Java Hello");
        // System.out.println(count.count("Hello"));

        // Task3
        // int[] num = new int[1000];
        // Random rand = new Random();
        // ArrayAlgo algo = new ArrayAlgo();

        // for (int i = 0; i < num.length; i++) {
        // num[i] = rand.nextInt(5000);
        // }

        // System.out.println(algo.min(num));
        // System.out.println();
        // System.out.println(algo.max(num));

        // Task3 BinarySearch
        ArrayAlgo algo = new ArrayAlgo();

        int[] num = new int[1000];
        for (int i = 0; i < num.length; i++) {
            num[i] = i;
        }

        int result = algo.binarySearch(num, 10, 0, num.length - 1);

        if (result == -1) {
            System.out.println("Element was not found!");
        } else {
            System.out.println("Element was found at index: " + result);
        }

    }
}