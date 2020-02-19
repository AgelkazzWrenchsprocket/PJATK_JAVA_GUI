package zad1;

class Account {
    private static double interestRate;
    private double money;

    static void setInterestRate(double r) {
        if (r > 0) interestRate = r;
    }

    double getStatus() {
        return this.money;
    }

    void addInterest() {
        this.money += (interestRate / 100.0 * this.money);
    }

    void deposit(double d) {
        if (d > 0) this.money += d;
    }

    void withdraw(double w) {
        if (w <= this.money && w > 0) this.money -= w;
    }

    void transfer(Account acc, double t) {
        if (t <= this.money && t > 0) {
            this.money -= t;
            acc.deposit(t);
        }
    }
}