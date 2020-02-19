package zad2;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.File;
import java.io.FilenameFilter;
import java.io.IOException;

class ImageSlideshow {
    private static final String[] extensions = new String[]{".jpg", ".png", ".gif"};
    private int time, fontSize;
    private File directory;
    private JFrame frame;
    private FilenameFilter filter = (directory, name) -> {
        for (String ext : extensions) {
            if (name.toLowerCase().endsWith(ext)) return true;
        }
        return false;
    };

    ImageSlideshow(String[] args) {
        String path = args[0];
        this.directory = new File(path);
        this.time = Integer.parseInt(args[1]) * 1000;
        this.fontSize = Integer.parseInt(args[2]);
    }

    void displayImages() throws InterruptedException {
        this.frame = new JFrame("zad2");
        this.frame.setLocationRelativeTo(null);
        this.frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.frame.setResizable(true);
        this.frame.setVisible(true);
        if (this.directory.listFiles().length > 0) {
            for (File f : directory.listFiles(filter)) {
                try {
                    ImageIcon ico = new ImageIcon(ImageIO.read(f));
                    Label label = new Label(ico);
                    this.frame.getContentPane().add(label);
                    this.frame.pack();
                    this.frame.addWindowListener(new WindowAdapter() {
                        void windowResized(WindowEvent e) {
                            label.repaint();
                        }
                    });
                    this.frame.setSize(new Dimension(ico.getIconWidth(), ico.getIconHeight()));
                    Thread.currentThread();
                    Thread.sleep(this.time);
                    this.frame.remove(label);
                } catch (IOException | NullPointerException e) {
                    this.throwTxt(this.frame, "Brak obrazka");
                }
            }
            this.throwTxt(this.frame, "Koniec prezentacji");
            this.frame.dispose();
        } else {
            this.throwTxt(this.frame, "Brak obrazka");
            this.frame.dispose();
        }
    }

    private void throwTxt(JFrame frame, String msg) {
        JLabel label = new JLabel(msg, JLabel.CENTER);
        label.setPreferredSize(new Dimension(this.fontSize * 10, this.fontSize * 10));
        label.setFont(new Font("Dialog", Font.PLAIN, this.fontSize));
        this.frame.getContentPane().add(label);
        this.frame.pack();
        try {
            Thread.currentThread();
            Thread.sleep(this.time);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        this.frame.remove(label);
    }
}

class Label extends JLabel {
    private ImageIcon ico;

    Label(ImageIcon ico) {
        super();
        this.ico = ico;
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(this.ico.getImage(), 0, 0, this.getWidth(), this.getHeight(), this);
    }
}