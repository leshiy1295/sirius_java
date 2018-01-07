package threads;

public class RandomRunExample extends Thread {
    public void run() {
        System.out.println(Thread.currentThread().getName());
    }

    public static void example() {
        for (int i = 0; i < 5; ++i) {
            Thread thread = new RandomRunExample();
            thread.start();
        }
    }
}
