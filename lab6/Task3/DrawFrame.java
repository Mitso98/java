import javax.swing.*;

public class DrawFrame {

    public void draw() {
        JFrame frame = new JFrame();
        frame.setSize(500, 500);
        frame.setTitle("Bouncing Ball App");
        frame.setContentPane(new MyPanel());
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }

}