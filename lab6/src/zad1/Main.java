package zad1;

import javax.swing.*;
import java.awt.*;
import java.util.LinkedList;

public class Main {
    public static void main(String[] args) {
        LinkedList<Color> colors = new LinkedList<>();
        colors.add(Color.BLUE);
        colors.add(Color.YELLOW);
        colors.add(Color.GREEN);
        colors.add(Color.RED);

        JFrame frame = new JFrame("zad1");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);

        JButton button = new JButton("click me!");
        button.setBackground(colors.getFirst());
        button.addActionListener(e -> {
            Color current = button.getBackground();
            if (current.equals(colors.getLast()))
                current = colors.getFirst();
            else
                current = colors.get(colors.indexOf(current) + 1);
            button.setBackground(current);
        });
        frame.getContentPane().add(button);
        frame.pack();
        frame.setVisible(true);
    }
}