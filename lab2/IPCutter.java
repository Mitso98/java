import java.util.ArrayList;
import java.util.StringTokenizer;

public class IPCutter {
    String ip;

    IPCutter(String ip) {
        this.ip = ip;
    }

    public ArrayList<String> doIPSplit(char dellimtar) {
        String[] arr = this.ip.split("\\" + dellimtar, 0);
        ArrayList<String> result = new ArrayList<>();
        for (String num : arr) {
            result.add(num);
        }
        return result;
    }

    public ArrayList<String> tokenizer(char dellimtar) {
        StringTokenizer token = new StringTokenizer(this.ip, "" + dellimtar);
        ArrayList<String> result = new ArrayList<>();

        while (token.hasMoreTokens()) {
            result.add(token.nextToken());
        }
        return result;
    }
}
