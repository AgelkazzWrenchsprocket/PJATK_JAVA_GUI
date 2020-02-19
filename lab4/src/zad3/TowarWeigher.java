package zad3;

public class TowarWeigher extends Thread {
    private TowarCreator towarCreator;
    private Thread thread;
    private int objectCounter;
    private int totalWeight;

    public TowarWeigher(TowarCreator towarCreator) {
        this.towarCreator = towarCreator;
        this.totalWeight = 0;
        this.objectCounter = 1;
        Runnable r = () -> {
            while (!this.thread.isInterrupted()) {
                while (!this.towarCreator.isFinished() || !this.towarCreator.bq().isEmpty()) {
                    synchronized (this.towarCreator.bq()) {
                        if (!this.towarCreator.bq().isEmpty()) {
                            this.totalWeight += this.towarCreator.bq().poll().getWeight();
                            if (objectCounter % 100 == 0) System.out.println("policzono wage " + objectCounter + " towarów");
                            objectCounter++;
                        }
                    }
                }
                this.thread.interrupt();
            }
            System.out.print(this.totalWeight);
        };
        this.thread = new Thread(r, "WeighingThread");
        this.thread.start();
    }
}