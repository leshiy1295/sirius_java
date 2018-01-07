package threads;

import java.util.concurrent.atomic.AtomicInteger;

public class CorrectIncrementExample {
    private static final int HUNDRED_MILLION = 100_000_000;
    private AtomicInteger counter = new AtomicInteger();

    public boolean stop() {
        return counter.incrementAndGet() > HUNDRED_MILLION;
    }

    public void example() {
        StateObject object = new StateObject();
        CorrectThread thread1 = new CorrectThread(this, object);
        CorrectThread thread2 = new CorrectThread(this, object);
        thread1.start();
        thread2.start();
        try {
            thread1.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Expected: " + HUNDRED_MILLION);
        System.out.println("Found: " + thread1.getI());
    }
}
