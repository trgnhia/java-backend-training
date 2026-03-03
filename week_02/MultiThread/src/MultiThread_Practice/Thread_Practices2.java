package MultiThread_Practice;

import java.util.concurrent.ExecutorCompletionService;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Thread_Practices2 {
    public static void main(String[] args) {
        // create thread pool have 2 thread

        ExecutorService executor = Executors.newFixedThreadPool(2);

        Runnable task = () -> {
            for (int i = 1; i <= 3; i++) {
                System.out.println(Thread.currentThread().getName() + " - " + i);
            };
            try {
                Thread.sleep(6000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        };

        // gui task cho moi pool
        executor.submit(task);

        System.out.println("Main thread continues");

        executor.shutdown();
    }
}
