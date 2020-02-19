package zad3;

class ReversibleDouble implements Reversible {
    private double d;

    ReversibleDouble(double d) {
        this.d = d;
    }

    void add() {
        this.d += 10;
    }

    @Override
    public void reverse() {
        this.d = 1 / this.d;
    }

    @Override
    public String toString() {
        return Double.toString(this.d);
    }
}