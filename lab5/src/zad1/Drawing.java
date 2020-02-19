package zad1;

import javax.swing.*;
import java.awt.*;

class Drawing extends JComponent {
    Drawing(int w, int h) {
        this.setPreferredSize(new Dimension(w, h));
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        int w = getWidth() - 1;
        int h = getHeight() - 1;
        g.setColor(Color.blue);
        g.drawLine(0, 0, w, h);
        g.drawLine(0, h, w, 0);
    }
}