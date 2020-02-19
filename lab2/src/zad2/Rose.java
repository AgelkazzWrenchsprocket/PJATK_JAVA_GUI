package zad2;

class Rose extends Flower {
    Rose(int i) {
        super(i);
        this.setColour("czerwony");
    }

    @Override
    public String toString() {
        return "róża";
    }
}