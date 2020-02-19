package zad2;

import java.util.HashMap;
import java.util.Map;

class PriceList {
    private static PriceList inst = new PriceList();
    private Map<String, Double> pl;

    private PriceList() {
        this.pl = new HashMap<>();
    }

    static PriceList getInstance() {
        return inst;
    }

    void put(String s, double d) {
        pl.put(s, d);
    }

    Map<String, Double> getPriceList() {
        return this.pl;
    }

    double getPrice(Flower f) {
        try {
            return this.pl.get(f.toString());
        } catch (NullPointerException e) {
            return -1.0;
        }
    }
}