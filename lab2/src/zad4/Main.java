package zad4;

public class Main {
    public static void main(String[] args) {
        Spiewak s1 = new Spiewak("Carrey") {
            @Override
            String spiewaj() {
                return "aaaaaaaaaaa";
            }
        };

        Spiewak s2 = new Spiewak("Houston") {
            @Override
            String spiewaj() {
                return "aaaBBBBBaaaaaaa";
            }
        };

        Spiewak s3 = new Spiewak("Madonna") {
            @Override
            String spiewaj() {
                return "aaaaaaGggGGG";
            }
        };

        Spiewak sp[] = {s1, s2, s3};

        for (Spiewak s : sp)
            System.out.println(s);

        System.out.println("\n" + Spiewak.najglosniej(sp));
    }
}