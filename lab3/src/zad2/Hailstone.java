package zad2;

import java.util.Iterator;

class Hailstone implements Iterable<Integer>, Iterator<Integer> {
    private boolean firstRun;
    private int e;

    Hailstone(int ini) {
        this.e = ini;
        this.firstRun = true;
    }

    public boolean hasNext() {
        return this.e != 1;
    }

    public Integer next() {
        if (!this.firstRun) {
            if (this.e % 2 == 0) this.e = this.e / 2;
            else this.e = this.e * 3 + 1;
        } else {
            this.firstRun = false;
        }
        return this.e;
    }

    @Override
    public Iterator<Integer> iterator() {
        return this;
    }
}