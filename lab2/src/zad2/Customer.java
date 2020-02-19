package zad2;

class Customer {
    private String name;
    private double cash;
    private ShoppingCart cart;

    Customer(String s, double d) {
        this.name = s;
        this.cash = d;
        this.cart = new ShoppingCart();
        this.cart.setOwner(this);
    }

    void get(Flower f) {
        this.cart.add(f);
    }

    double getCash() {
        return this.cash;
    }

    ShoppingCart getShoppingCart() {
        return this.cart;
    }

    void pack(Box b) {
        b.getList().addAll(this.cart.getList());
        this.cart.getList().clear();
    }

    void pay() {
        PriceList pl = PriceList.getInstance();
        ShoppingCart tmp = this.cart;
        this.cart = new ShoppingCart();
        this.cart.setOwner(this);
        for (int i = 0; i < tmp.getList().size(); i++) {
            Flower f = tmp.getList().get(i);
            if (pl.getPriceList().containsKey(f.toString())) {
                if ((pl.getPrice(f) * f.getQuantity()) < this.cash) {
                    this.cart.add(f);
                    this.cash -= (pl.getPrice(f) * f.getQuantity());
                }
            }
        }
    }

    @Override
    public String toString() {
        return this.name;
    }
}