package threads;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class PoolExample {
    public static void example() {
        int cores = Runtime.getRuntime().availableProcessors();
        System.out.println("Processors available: " + cores);
        ExecutorService service = Executors.newFixedThreadPool(2);

        List<Future> futures = new ArrayList<>();

        for (int i = 0; i < 4; ++i) {
            Future future = service.submit(new Thread(new Runnable() {
                @Override
                public void run() {
                    System.out.println("Hello from thread");
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }));
            futures.add(future);
        }

        for (Future f : futures) {
            try {
                System.out.println("result: " + f.get());
            } catch (InterruptedException | ExecutionException e) {
                e.printStackTrace();
            }

        }
        service.shutdown();
    }
}
