import javax.swing.*;

public class TimeAndDateApp {
    public static void main(String[] args) {
        JFrame frame = new JFrame();
        frame.setSize(300, 200);
        frame.setTitle("Time and Date");
        frame.setContentPane(new MyPanel());
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}