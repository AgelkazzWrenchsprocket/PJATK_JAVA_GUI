package zad4;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.*;

class CountWords {
    private Scanner sc;
    private List<String> result;

    @SuppressWarnings("resource")
    CountWords(String fn) throws FileNotFoundException {
        try {
            this.sc = new Scanner(new FileReader(fn)).useDelimiter("[.,–+:;()?!\"\\s]+");
        } catch (FileNotFoundException e) {
            System.out.print("File not found!");
        }
        this.setResult();
    }

    private void setResult() {
        this.result = new ArrayList<>();
        Map<String, Integer> map = new LinkedHashMap<>();
        while (this.sc.hasNext()) {
            String curLine = this.sc.next();
            if (!map.containsKey(curLine)) map.put(curLine, 1);
            else map.put(curLine, map.get(curLine) + 1);
        }
        sc.close();
        for (Map.Entry<String, Integer> i : map.entrySet()) this.result.add(i.getKey() + " " + i.getValue());
    }

    List<String> getResult() {
        return this.result;
    }
}