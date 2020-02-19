package zad4;

public class Writer implements Runnable {
    private Author autor;
    private Thread t;
    private boolean finished;

    Writer(Author autor) {
        this.autor = autor;
        this.t = new Thread(this);
        this.finished = false;
    }

    private void finish() {
        this.t.interrupt();
        this.finished = true;
    }

    private boolean isFinished() {
        return this.finished;
    }

    @Override
    public void run() {
        while (!this.isFinished()) {
            while (!this.autor.isFinished()) {
                synchronized (this.autor.bq()) {
                    if (!this.autor.bq().isEmpty()) {
                        String msg = this.autor.bq().poll();
                        System.out.println("-> " + msg);
                    }
                }
            }
            this.finish();
        }
    }
}