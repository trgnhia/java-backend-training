
public class MultiThread {
    public static void main(String[] args) {
        Runnable task1 = () -> {
            for (int i = 1; i <= 20; i++) {
                if (i % 2 == 0) {
                    System.out.println(
                            Thread.currentThread().getName() + " - " + i
                    );
//                    try {
//                        Thread.sleep(300);
//                    } catch (InterruptedException e) {
//                        e.printStackTrace();
//                    }
                }
            }
        };

        Runnable task2 = () -> {
            for (int i = 1; i <= 20; i++) {
                if (i % 2 == 1) {
                    System.out.println(
                            Thread.currentThread().getName() + " - " + i
                    );
//                    try {
//                        Thread.sleep(300);
//                    } catch (InterruptedException e) {
//                        e.printStackTrace();
//                    }
                }
            }
        };

        Thread evenThread = new Thread(task1, "Even - Thread");
        Thread oddThread = new Thread(task2, "Odd - Thread");

        evenThread.start();
        oddThread.start();

    }
}
