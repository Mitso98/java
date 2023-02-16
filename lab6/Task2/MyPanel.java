

import javax.swing.*;

public class MyPanel extends JPanel implements Runnable {
    int dx = 25;
    int x = 5;

    public MyPanel() {
        Thread t;
        t = new Thread(this);
        t.start(); 
    }

    @Override
    public void paintComponent(java.awt.Graphics g) { 
        super.paintComponent(g);
        g.drawString("I'am a Marquee Text!", x, 50);
    }

    @Override
    public void run() { 
        while (true) { 
            try {
                Thread.sleep(1000); 
            } catch (InterruptedException e) {
                System.out.println(e.getMessage());
            }
            repaint();
            int frameWidth = this.getWidth();
            if (x < frameWidth) {
                x = x + dx;
            } else {
                x = 5;
            }
        }
    }

}