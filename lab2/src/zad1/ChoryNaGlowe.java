package zad1;

class ChoryNaGlowe extends Pacjent {
    ChoryNaGlowe(String n) {
        super(n);
    }

    @Override
    String choroba() {
        return "glowa";
    }

    @Override
    String leczenie() {
        return "aspiryna";
    }
}