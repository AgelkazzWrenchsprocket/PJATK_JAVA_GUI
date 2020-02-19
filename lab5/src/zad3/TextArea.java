package zad3;

import javax.swing.*;
import java.awt.*;

class TextArea {
    TextArea(String[] args) {
        this.displayTextArea(args);
    }

    private Color setBackgroundColor(String s) {
        try {
            return (Color) Color.class.getField(s).get(null);
        } catch (Exception e) {
            return Color.white;
        }
    }

    private Color setFontColor(String s) {
        try {
            return (Color) Color.class.getField(s).get(null);
        } catch (Exception e) {
            return Color.black;
        }
    }

    private int setFontSize(String s) {
        try {
            return Integer.parseInt(s);
        } catch (NumberFormatException e) {
            return 15;
        }
    }

    private int setFontSize(int i) {
        return i;
    }

    private int setFontStyle(String s) {
        switch (s) {
            case "b":
                return Font.BOLD;
            case "i":
                return Font.ITALIC;
            case "bi":
                return Font.BOLD | Font.ITALIC;
            case "ib":
                return Font.BOLD | Font.ITALIC;
            default:
                return Font.PLAIN;
        }
    }

    private int setFontStyle() {
        return Font.PLAIN;
    }

    private void displayTextArea(String[] args) throws ArrayIndexOutOfBoundsException {
        JFrame frame = new JFrame("zad3");
        JTextArea txt = new JTextArea();
        Color backgroundColor, fontColor;
        int fontSize, fontStyle;
        String font;

        frame.setPreferredSize(new Dimension(600, 200));
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        try {
            backgroundColor = setBackgroundColor(args[0]);
            fontColor = setFontColor(args[1]);
            fontSize = setFontSize(args[2]);
            fontStyle = setFontStyle(args[3]);
            font = args[4];
        } catch (ArrayIndexOutOfBoundsException e) {
            JOptionPane.showMessageDialog(frame, "Not enough parameters, setting default variables.");
            backgroundColor = setBackgroundColor("white");
            fontColor = setFontColor("black");
            fontSize = setFontSize(15);
            fontStyle = setFontStyle();
            font = "Dialog";
        }
        txt.setBackground(backgroundColor);
        txt.setForeground(fontColor);
        txt.setFont(new Font(font, fontStyle, fontSize));
        txt.setLineWrap(true);
        frame.getContentPane().add(new JScrollPane(txt));
        frame.pack();
        frame.setVisible(true);
    }
}