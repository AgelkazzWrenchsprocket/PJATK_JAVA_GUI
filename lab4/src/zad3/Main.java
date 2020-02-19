package zad3;

public class Main extends Thread {
    public static void main(String[] args) {
        TowarCreator tr = new TowarCreator();
        TowarWeigher w = new TowarWeigher(tr);
    }
}