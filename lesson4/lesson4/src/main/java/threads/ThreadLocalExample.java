package threads;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public class ThreadLocalExample {
    static class ThreadId implements Runnable {
        // atomic целое, содержащее следующее значение ID потока
        private static final AtomicInteger nextId = new AtomicInteger(0);

        // Thread Local переменная, содержащая ID для каждого потока в отдельности
        private static final ThreadLocal<Integer> threadId = new ThreadLocal<Integer>() {
            @Override
            protected Integer initialValue() {
                System.out.println("Initializing threadId in thread " + Thread.currentThread().getName());
                return nextId.incrementAndGet();
            }
        };

        // Возврат текущего уникального ID потока
        public static int getId() {
            return threadId.get();
        }

        @Override
        public void run() {
            System.out.println("Hello from thread " + Thread.currentThread().getName());
            try {
                Thread.sleep(1000 * getId());
                System.out.println("Bye from thread " + Thread.currentThread().getName() + " with id " + getId());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public static void example() {
        List<Thread> threads = new ArrayList<>();
        for (int i = 0; i < 5; ++i) {
            threads.add(new Thread(new ThreadId()));
        }
        for (Thread t : threads) {
            t.start();
        }
    }
}
