package zad3;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Main {
    @SuppressWarnings("resource")
    public static void main(String[] args) throws IOException {
        String fname = System.getProperty("user.home") + "/tab.txt";
        Scanner sc;
        ArrayList<Integer> nums = new ArrayList<>();

        try {
            sc = new Scanner(new FileReader(fname)).useDelimiter("\\s+");
            while (sc.hasNext()) {
                int n = Integer.parseInt(sc.next());
                nums.add(n);
            }
            sc.close();
        } catch (FileNotFoundException e) {
            System.out.print("***");
            System.exit(0);
        } catch (NumberFormatException e) {
            System.out.print("asd");
            System.exit(0);
        }

        int[] uselessTable = nums.stream().mapToInt(i -> i).toArray();
        int max = Collections.max(nums);
        ArrayList<Integer> pos = new ArrayList<>();
        for (int i = 0; i < nums.size(); i++) {
            if (uselessTable[i] == max) pos.add(i);
            System.out.print(uselessTable[i] + " ");
        }
        System.out.println("\n" + max);
        pos.forEach((tmp) -> System.out.print(tmp + " "));
    }
}