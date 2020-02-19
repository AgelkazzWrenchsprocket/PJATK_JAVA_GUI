package zad2;

import java.util.LinkedList;

abstract class Container {
    private LinkedList<Flower> list;
    private Customer owner;

    Container() {
        this.list = new LinkedList<>();
    }

    Container(Customer c) {
        this.list = new LinkedList<>();
        this.owner = c;
    }

    private Customer getOwner() {
        return this.owner;
    }

    void setOwner(Customer c) {
        this.owner = c;
    }

    LinkedList<Flower> getList() {
        return this.list;
    }

    void add(Flower f) {
        this.list.add(f);
    }

    @Override
    public String toString() {
        String containerType = "";
        String containerContent = " -- pusto";
        PriceList pl = PriceList.getInstance();
        if (this instanceof Box) containerType = "Pudełko";
        if (this instanceof ShoppingCart) containerType = "Wózek";
        if (this.getList().size() > 0) {
            containerContent = "\n";
            for (int i = 0; i < this.getList().size(); i++) {
                Flower f = this.getList().get(i);
                containerContent += f + ", kolor: " + f.getColour() + ", ilość " + f.getQuantity() + ", cena " + pl.getPrice(f) + '\n';
            }
        }
        return containerType + " właściciel " + this.getOwner() + containerContent;
    }
}