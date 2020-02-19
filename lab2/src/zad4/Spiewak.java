package zad4;

abstract class Spiewak {
    private static int noTotal = 1;
    private String name;
    private int no;

    Spiewak(String s) {
        this.name = s;
        this.no = noTotal;
        noTotal += 1;
    }

    static String najglosniej(Spiewak sp[]) {
        String results = "";
        int theLoudestVoice = 0;
        for (Spiewak s : sp) {
            int scream = (int) s.spiewaj().chars().map(i -> (char) i).filter(c -> Character.isUpperCase(c)).count();
            if (scream == theLoudestVoice) results += s.toString() + "\n";
            else if (scream > theLoudestVoice) {
                theLoudestVoice = scream;
                results = s.toString() + "\n";
            }
        }
        return results;
    }

    abstract String spiewaj();

    public String toString() {
        return "(" + Integer.toString(this.no) + ") " + this.name + ": " + spiewaj();
    }
}