package zad4;

import javax.swing.*;
import java.awt.*;
import java.util.LinkedList;

public class Main {

    public static void main(String[] args) {
        JFrame frame = new JFrame("zad4");
        frame.setMinimumSize(new Dimension(210, 0));
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel optionsPanel = new JPanel();
        frame.getContentPane().add(optionsPanel, BorderLayout.NORTH);

        JPanel buttonsPanel = new JPanel();
        frame.getContentPane().add(buttonsPanel, BorderLayout.CENTER);

        LinkedList<JButton> buttons = new LinkedList<>();
        buttons.add(new JButton("Przycisk 1"));
        buttons.add(new JButton("P 2"));
        buttons.add(new JButton("Większy przycisk numer 3"));
        buttons.add(new JButton("Przycisk 4"));
        buttons.add(new JButton("P5"));

        JComboBox<Layout> layoutCombo = new JComboBox<>(Layout.values());
        optionsPanel.add(layoutCombo);
        layoutCombo.addActionListener(event -> {
            JComboBox<Layout> pickCombo = (JComboBox<Layout>) event.getSource();
            Layout picked = (Layout) pickCombo.getSelectedItem();
            switch (picked) {
                case A: {
                    buttonsPanel.setLayout(new BorderLayout());
                    buttonsPanel.add(buttons.get(0), BorderLayout.NORTH);
                    buttonsPanel.add(buttons.get(1), BorderLayout.WEST);
                    buttonsPanel.add(buttons.get(2), BorderLayout.CENTER);
                    buttonsPanel.add(buttons.get(3), BorderLayout.EAST);
                    buttonsPanel.add(buttons.get(4), BorderLayout.SOUTH);
                    frame.pack();
                    break;
                }
                case B: {
                    frame.setMinimumSize(new Dimension(600, 110));
                    buttonsPanel.setLayout(new FlowLayout());
                    for (JButton b : buttons)
                        buttonsPanel.add(b);
                    frame.pack();
                    break;
                }
                case C: {
                    frame.setMinimumSize(new Dimension(600, 110));
                    buttonsPanel.setLayout(new FlowLayout(FlowLayout.LEFT));
                    for (JButton b : buttons)
                        buttonsPanel.add(b);
                    frame.pack();
                    break;
                }
                case D: {
                    frame.setMinimumSize(new Dimension(600, 110));
                    buttonsPanel.setLayout(new FlowLayout(FlowLayout.RIGHT));
                    for (JButton b : buttons)
                        buttonsPanel.add(b);
                    frame.pack();
                    break;
                }
                case E: {
                    buttonsPanel.setLayout(new GridLayout(1, 5));
                    for (JButton b : buttons)
                        buttonsPanel.add(b);
                    frame.pack();
                    break;
                }
                case F: {
                    buttonsPanel.setLayout(new GridLayout(5, 1));
                    for (JButton b : buttons)
                        buttonsPanel.add(b);
                    frame.pack();
                    break;
                }
                case G: {
                    buttonsPanel.setLayout(new GridLayout(2, 6));
                    for (JButton b : buttons)
                        buttonsPanel.add(b);
                    frame.pack();
                    break;
                }
            }
        });
        frame.pack();
        frame.setVisible(true);
    }

    private enum Layout {
        A, B, C, D, E, F, G
    }
}