package zad4;

import java.util.Queue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class Author implements Runnable {
    private BlockingQueue<String> bq;
    private String[] args;
    private boolean finished;
    private Thread t;

    Author(String[] args) {
        this.args = args;
        this.finished = false;
        this.t = new Thread(this);
        this.bq = new LinkedBlockingQueue<>();
    }

    synchronized boolean isFinished() {
        return this.finished;
    }

    private synchronized void finish() {
        this.t.interrupt();
        this.finished = true;
    }

    synchronized Queue<String> bq() {
        return this.bq;
    }

    @Override
    public void run() {
        while (!this.isFinished()) {
            for (String s : args) {
                try {
                    Thread.sleep(1000);
                    this.bq.add(s);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            this.finish();
        }
    }
}