package zad2;

abstract class Flower {
    private String colour;
    private int quantity;

    Flower(int i) {
        this.quantity = i;
    }

    String getColour() {
        return this.colour;
    }

    void setColour(String s) {
        this.colour = s;
    }

    int getQuantity() {
        return this.quantity;
    }
}