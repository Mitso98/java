import javax.swing.*;

public class MyPanel extends JPanel implements Runnable {

    int dx = 25;
    int x = 5;
    int dy = 25;
    int y = 200;

    public MyPanel() {
        Thread t = new Thread(this);
        t.start();
    }

    @Override
    public void paintComponent(java.awt.Graphics g) {
        super.paintComponent(g);
        g.setColor(java.awt.Color.RED);
        g.fillOval(x, y, 50, 50);
        g.drawOval(x, y, 50, 50);

    }

    @Override
    public void run() {
        while (true) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            repaint();

            int frameWidth = this.getWidth();
            int frameHight = this.getHeight();

            if (x + dx > frameWidth - 50 || x + dx < 0) {
                dx = -dx;
            }
            if (y + dy > frameHight - 50 || y + dy < 0) {
                dy = -dy;
            }
            x = x + dx;
            y = y + dy;

        }
    }

}