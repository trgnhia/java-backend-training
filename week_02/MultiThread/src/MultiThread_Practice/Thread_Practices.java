package MultiThread_Practice;

public class Thread_Practices {
    public static void main(String[] args) {
        Runnable task2 = () -> {
            for (int i = 1; i <=3 ; i++) {
                System.out.println(
                        Thread.currentThread().getName() + " - " + i
                );
            } try {
                /**
                 * Thread chuyen sang trang thai TIME_WAITING
                 * Nhuong CPU cho thread khac, sau 500ms thi thuc thi runnable
                 */
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        };

        Thread t2 = new Thread(task2);

        /**
         *  JVM create new thread name t2
         *  Thread goi run() cua task
         *  Chay song song voi main
         */
        t2.start();
        System.out.println("Main thread continues...");

    }
}
