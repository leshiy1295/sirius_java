package threads;

import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.Callable;

public class ThreadsExample {
    public static void run() {
        final Timer timer = new Timer();
        System.out.println("I'll be back in 5 seconds");
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                System.out.println("After 5 seconds");
                timer.cancel();
            }
        }, 5 * 1000);
        try {
            System.out.println(new Callable<Integer>() {
                @Override
                public Integer call() throws Exception {
                    return 42;
                }
            }.call());
        } catch (Exception e) {
            e.printStackTrace();
        }
        RandomRunExample.example();
        PoolExample.example();
        (new InterferenceExample()).example();
        (new CorrectIncrementExample()).example();
//        (new DeadLockExample()).example();
        SeriesRunExample.example();
    }
}
