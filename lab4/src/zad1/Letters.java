package zad1;

import java.util.LinkedHashSet;
import java.util.Set;

class Letters extends Thread {
    private final LinkedHashSet<Thread> list = new LinkedHashSet<>();

    Letters(String s) {
        for (int i = 0; i < s.length(); i++) {
            String name = "Thread " + s.substring(i, i + 1);
            Runnable rt = () -> {
                while (!Thread.currentThread().isInterrupted()) {
                    String msg = name.substring(name.length() - 1);
                    System.out.print(msg);
                }
            };
            Thread thread = new Thread(rt, name);
            list.add(thread);
        }
    }

    Set<Thread> getThreads() {
        return this.list;
    }
}