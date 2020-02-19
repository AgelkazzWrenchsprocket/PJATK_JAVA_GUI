package zad1;

class ChoryNaNoge extends Pacjent {
    ChoryNaNoge(String n) {
        super(n);
    }

    @Override
    String choroba() {
        return "noga";
    }

    @Override
    String leczenie() {
        return "gips";
    }
}