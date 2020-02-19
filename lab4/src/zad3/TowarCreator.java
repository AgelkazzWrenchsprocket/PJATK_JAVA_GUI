package zad3;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Queue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class TowarCreator extends Thread {
    private Thread thread;
    private String file;
    private BlockingQueue<Towar> bq;
    private boolean status;

    public TowarCreator() {
        this.file = "../Towary.txt";
        this.bq = new LinkedBlockingQueue<>();
        this.status = false;
        Runnable r = () -> {
            while (!this.thread.isInterrupted()) {
                try (BufferedReader br = new BufferedReader(new FileReader(this.file))) {
                    String line;
                    while ((line = br.readLine()) != null) {
                        String[] tmpTab = line.split("\\s");
                        int id = Integer.parseInt(tmpTab[0]);
                        int weight = Integer.parseInt(tmpTab[1]);
                        Towar t = new Towar(id, weight);
                        this.bq().add(t);
                        if (id % 200 == 0) System.out.println("utworzono " + id + " obiektów");
                    }
                    br.close();
                    this.thread.interrupt();
                    this.finish();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        };
        this.thread = new Thread(r, "ReadingThread");
        this.thread.start();
    }

    public synchronized boolean isFinished() {
        return this.status;
    }

    public synchronized void finish() {
        this.status = true;
    }

    public synchronized Queue<Towar> bq() {
        return this.bq;
    }
}