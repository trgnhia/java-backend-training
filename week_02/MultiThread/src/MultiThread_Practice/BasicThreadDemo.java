package MultiThread_Practice;
import java.util.concurrent.TimeUnit;

public class BasicThreadDemo {

    private static final Object LOCK = new Object();
    private static final Object WAIT_LOCK = new Object();

    public static void main(String[] args) throws Exception {

        // 1) Thread A: Giữ LOCK một lúc để Thread B bị BLOCKED
        Thread threadA = new Thread(() -> {
            log("A: started");
            synchronized (LOCK) {
                log("A: acquired LOCK, sleep 2s (=> A will be TIMED_WAITING)");
                sleepMillis(2000); // TIMED_WAITING
                log("A: woke up, releasing LOCK soon");
            }
            log("A: finished (=> TERMINATED)");
        }, "Thread-A");

        // 2) Thread B: Cố lấy LOCK => sẽ bị BLOCKED khi A đang giữ LOCK
        Thread threadB = new Thread(() -> {
            log("B: started, trying to acquire LOCK (=> B may be BLOCKED)");
            synchronized (LOCK) {
                log("B: acquired LOCK (after waiting), doing quick work");
            }
            log("B: finished (=> TERMINATED)");
        }, "Thread-B");

        // 3) Thread C: WAITING bằng wait() cho đến khi được notify
        Thread threadC = new Thread(() -> {
            log("C: started, entering WAIT_LOCK then wait()");
            synchronized (WAIT_LOCK) {
                try {
                    log("C: calling wait() (=> WAITING, and it releases WAIT_LOCK)");
                    WAIT_LOCK.wait(); // WAITING (vô thời hạn) + RELEASE LOCK
                    log("C: notified, resumed");
                } catch (InterruptedException e) {
                    log("C: interrupted");
                    Thread.currentThread().interrupt();
                }
            }
            log("C: finished (=> TERMINATED)");
        }, "Thread-C");

        // ---- BEFORE START: all are NEW
        System.out.println("\n=== BEFORE start() ===");
        printState(threadA, threadB, threadC);

        // Start A, rồi start B để B rơi vào BLOCKED
        threadA.start();
        sleepMillis(200); // cho A kịp lấy LOCK
        threadB.start();

        // Start C để nó đi vào WAITING
        threadC.start();
        sleepMillis(200); // cho C kịp wait()

        System.out.println("\n=== DURING execution (expected: A TIMED_WAITING, B BLOCKED, C WAITING) ===");
        printState(threadA, threadB, threadC);

        // notify C sau 1s
        sleepMillis(1000);
        synchronized (WAIT_LOCK) {
            log("MAIN: notify() C");
            WAIT_LOCK.notify();
        }

        // join() để main WAITING cho đến khi các thread xong
        System.out.println("\n=== MAIN: calling join() (main thread will WAITING) ===");
        threadA.join();
        threadB.join();
        threadC.join();

        System.out.println("\n=== AFTER join() (all TERMINATED) ===");
        printState(threadA, threadB, threadC);

        log("MAIN: finished");
    }

    // ---------- Helpers ----------
    private static void printState(Thread... threads) {
        for (Thread t : threads) {
            System.out.printf("%s -> %s%n", t.getName(), t.getState());
        }
    }

    private static void sleepMillis(long ms) {
        try {
            TimeUnit.MILLISECONDS.sleep(ms);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }

    private static void log(String msg) {
        System.out.printf("[%s] %s%n", Thread.currentThread().getName(), msg);
    }
}
