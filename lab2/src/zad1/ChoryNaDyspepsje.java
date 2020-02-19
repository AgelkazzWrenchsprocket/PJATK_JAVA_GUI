package zad1;

class ChoryNaDyspepsje extends Pacjent {
    ChoryNaDyspepsje(String n) {
        super(n);
    }

    @Override
    String choroba() {
        return "dyspepsja";
    }

    @Override
    String leczenie() {
        return "wegiel";
    }
}