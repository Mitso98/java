import com.mycompany.task2.MyPanel;
import javax.swing.*;

public class DrawFrame {

    public void draw() {

        JFrame frame = new JFrame();
        frame.setSize(300, 200);
        frame.setTitle("Marquee");
        frame.setContentPane(new MyPanel());
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }

}