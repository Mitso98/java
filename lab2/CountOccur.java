import java.util.ArrayList;

public class CountOccur {
    IPCutter splitter;
    String str;

    CountOccur(String str) {
        this.str = str;
        splitter = new IPCutter(this.str);
    }

    public int count(String word) {
        ArrayList<String> str = splitter.doIPSplit(' ');
        int counter = 0;
        for (String s : str) {
            if(s.equals(word)) counter++;
        }

        return counter;
    }

}