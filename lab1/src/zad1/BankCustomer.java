package zad1;

class BankCustomer {
    private Person owner;
    private Account acc;

    BankCustomer(Person p) {
        this.owner = p;
        this.acc = new Account();
    }

    Account getAccount() {
        return this.acc;
    }

    public String toString() {
        return "Klient: " + this.owner.getName() + " stan konta " + this.acc.getStatus();
    }
}