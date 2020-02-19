package zad1;

abstract class Pacjent {
    private String nazwisko;

    Pacjent(String n) {
        this.nazwisko = n;
    }

    String nazwisko() {
        return this.nazwisko;
    }

    abstract String choroba();

    abstract String leczenie();
}