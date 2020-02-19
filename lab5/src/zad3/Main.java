package zad3;

public class Main {
    public static void main(String[] args) {
        /*
         * args[0] = background color, e.g. YELLOW
		 * args[1] = font color, e.g. RED
		 * args[2] = font size, e.g. 15
		 * args[3] = font style options:
		 * 		p - plain,
		 * 		b - bold,
		 * 		i - italic,
		 * 		bi - bold italic
		 * args[4] = font, e.g. Monospaced
		 */
        TextArea ta = new TextArea(args);
    }
}