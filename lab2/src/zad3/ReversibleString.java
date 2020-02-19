package zad3;

class ReversibleString implements Reversible {
    private String s;

    ReversibleString(String s) {
        this.s = s;
    }

    @Override
    public void reverse() {
        this.s = new StringBuilder(this.s).reverse().toString();
    }

    @Override
    public String toString() {
        return this.s;
    }
}