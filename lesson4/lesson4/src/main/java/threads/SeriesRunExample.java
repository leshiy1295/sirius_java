package threads;

import java.util.ArrayList;
import java.util.List;

public class SeriesRunExample extends Thread {
    private static int currentMax = 0;
    private int mainId;
    private final Object waitObject;

    public SeriesRunExample(int id, Object waitObject) {
        this.mainId = id;
        this.waitObject = waitObject;
    }

    public static void example() {
        Object waitObject = new Object();
        List<Thread> threads = new ArrayList<>();
        for (int i = currentMax; i < 5; ++i) {
            threads.add(new SeriesRunExample(i, waitObject));
        }
        for (int i = currentMax; i < 5; ++i) {
            threads.get(i).start();
        }
    }

    public void run() {
        try {
            System.out.println("Start run of thread: " + mainId);
            synchronized (waitObject) {
                while (mainId > currentMax) {
                    waitObject.wait(); // освобождает synchronized, используется та же очередь, что и для synchronized (waitObject)
                }
            }

            ++currentMax;

            System.out.println("Hello from thread: " + mainId);
            synchronized (waitObject) {
                waitObject.notifyAll(); // передаёт synchronized освобождаемому потоку
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
