package zad2;

class StringTask implements Runnable {
    private volatile TaskState state;
    private String letter;
    private String result;
    private int i;

    StringTask(String s, int i) {
        this.letter = s;
        this.result = "";
        this.i = i;
        this.setState(TaskState.CREATED);
    }

    public void start() {
        new Thread(this, letter).start();
    }

    public void abort() {
        Thread.currentThread().interrupt();
        this.setState(TaskState.ABORTED);
    }

    public boolean isDone() {
        switch (this.getState()) {
            case ABORTED:
                return true;
            case READY:
                return true;
            default:
                return false;
        }
    }

    public String getResult() {
        return this.result;
    }

    public TaskState getState() {
        return this.state;
    }

    private void setState(TaskState ts) {
        this.state = ts;
    }

    @Override
    public void run() {
        this.setState(TaskState.RUNNING);
        while (this.i > 0 && !Thread.currentThread().isInterrupted() && this.getState().equals(TaskState.RUNNING)) {
            this.result += this.letter;
            this.i--;
        }
        if (this.i == 0) this.setState(TaskState.READY);
    }

    enum TaskState {
        CREATED, RUNNING, ABORTED, READY;
    }
}