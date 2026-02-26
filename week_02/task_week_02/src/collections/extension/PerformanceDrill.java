package collections.extension;

import java.util.*;

public class PerformanceDrill {
    public static void main(String[] args) {
        int n = 200_000;

        System.out.println("n = " + n);

        testAppend(new ArrayList<>(), n, "ArrayList append");
        testAppend(new LinkedList<>(), n, "LinkedList append");

        testAddFirst(new ArrayList<>(), n / 10, "ArrayList addFirst");   // giảm n để tránh quá chậm
        testAddFirst(new LinkedList<>(), n, "LinkedList addFirst");

        testRemoveFirst(new ArrayList<>(), n / 10, "ArrayList removeFirst");
        testRemoveFirst(new LinkedList<>(), n, "LinkedList removeFirst");

        testRemoveEnd(new ArrayList<>(), n / 10, "ArrayList testRemoveEnd");
        testRemoveEnd(new LinkedList<>(), n, "LinkedList testRemoveEnd");
    }

    private static void testAppend(List<Integer> list, int n, String label) {
        long start = System.nanoTime();
        for (int i = 0; i < n; i++) list.add(i);
        long end = System.nanoTime();
        System.out.println(label + ": " + ms(start, end) + " ms");
    }

    private static void testAddFirst(List<Integer> list, int n, String label) {
        long start = System.nanoTime();
        for (int i = 0; i < n; i++) {
            if (list instanceof LinkedList) {
                ((LinkedList<Integer>) list).addFirst(i);
            } else {
                list.add(0, i);
            }
        }
        long end = System.nanoTime();
        System.out.println(label + ": " + ms(start, end) + " ms");
    }

    private static void testRemoveFirst(List<Integer> list, int n, String label) {
        // fill trước
        for (int i = 0; i < n; i++) list.add(i);

        long start = System.nanoTime();
        for (int i = 0; i < n; i++) {
            if (list instanceof LinkedList) {
                ((LinkedList<Integer>) list).removeFirst();
            } else {
                list.remove(0);
            }
        }
        long end = System.nanoTime();
        System.out.println(label + ": " + ms(start, end) + " ms");
    }

    private static void testRemoveEnd (List<Integer> list, int n, String label) {
        for (int i = 0; i < n; i++){
            list.add(i);
        }
        long start = System.nanoTime();
        for (int i = 0; i < n; i ++) {
            list.remove(list.size() -1);
        }
        long end = System.nanoTime();
        System.out.println(label + ": " + ms(start, end) + " ms");
    }
    private static long ms(long start, long end) {
        return (end - start) / 1_000_000;
    }
}
