package zad3;

public class ReverseTest {
    public static void main(String[] args) {
        Reversible[] revers = new Reversible[]{
                new ReversibleString("Kot"),
                new ReversibleDouble(2),
                new ReversibleDouble(3),
                new ReversibleString("Pies"),
                new ReversibleString("Ala ma kota i psa"),
                new ReversibleDouble(10),
        };

        System.out.println("Normalne:");
        for (Reversible r : revers) {
            System.out.println(r);
        }

        for (Reversible r : revers) {
            r.reverse();
        }

        System.out.println("Odwrócone:");
        for (Reversible r : revers) {
            System.out.println(r);
        }

        System.out.println("Przywrócone i zmienione:");
        for (Reversible r : revers) {
            r.reverse();
            if (r instanceof ReversibleString) System.out.println("Tekst " + r);
            if (r instanceof ReversibleDouble) {
                ((ReversibleDouble) r).add();
                System.out.println(r);
            }
        }
    }
}