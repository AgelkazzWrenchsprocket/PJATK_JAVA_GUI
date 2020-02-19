package zad2;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.NoSuchFileException;
import java.nio.file.Paths;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Finder {
    private String fileContent;

    public Finder(String fn) throws IOException {
        try {
            this.fileContent = new String(Files.readAllBytes(Paths.get(fn)));
        } catch (NoSuchFileException e) {
            System.out.println("File not found!");
        }
    }

    int getIfCount() {
        int nif = 0;
        String tmp = fileContent.replaceAll("(((\\/\\/.+))|(/\\*(?:.|[\\n\\r])*?\\*/))|(\\\".*?\\\")", " ");
        Matcher m = Pattern.compile("if\\s*\\([^)]*\\s*\\)").matcher(tmp);
        while (m.find()) nif++;
        return nif;
    }

    int getStringCount(String s) {
        int nwar = 0;
        Matcher m = Pattern.compile(s).matcher(this.fileContent);
        while (m.find()) nwar++;
        return nwar;
    }
}