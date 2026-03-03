import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class MultiThread2 {
    public static void main(String[] args) {
        ExecutorService executor = Executors.newFixedThreadPool(3);

        Runnable task1 = () -> {
            System.out.println("Task 1 is running by " + Thread.currentThread().getName());
        };

        Runnable task2 = () -> {
            System.out.println("Task 2 is running by " + Thread.currentThread().getName());
        };

        Runnable task3 = () -> {
            System.out.println("Task 3 is running by " + Thread.currentThread().getName());
        };

        /**
         * Gui task cho thread pool
         * pool lay 1 threa dang ranh de cho chay task
         */
        executor.submit(task1);
        executor.submit(task2);
        executor.submit(task3);

        executor.shutdown();
    }
}
