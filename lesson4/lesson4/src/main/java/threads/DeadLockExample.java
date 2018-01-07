package threads;

public class DeadLockExample {
    private int c1;
    private int c2;
    private Object lock1 = new Object();
    private Object lock2 = new Object();

    private void c1c2Up() {
        synchronized (lock1) {
            ++c1;
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            synchronized (lock2) {
                ++c2;
            }
        }
        System.out.println("c1c2Up finished");
    }

    private void c2c1Up() {
        synchronized (lock2) {
            ++c2;
            synchronized (lock1) {
                ++c1;
            }
        }
        System.out.println("c2c1Up finished");
    }

    public void example() {
        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                c1c2Up();
            }
        });
        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                c2c1Up();
            }
        });
        t1.start();
        t2.start();
        try {
            t1.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Finished");
    }
}
