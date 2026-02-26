package generics;

import java.util.ArrayList;
import java.util.List;

public class Main {
    private static void printList(List<?> myList) {
        for(int i = 0; i < myList.size(); i++) {
            System.out.println(myList.get(i));
        }
    }
    public static void main(String[] args) {
        List<Integer> intList = new ArrayList<>();
        for (int i = 0; i < 10; i ++) {
            intList.add(i);
        }

        List<String> nameList = new ArrayList<>();
        nameList.add("a");
        nameList.add("b");
        nameList.add("c");
        nameList.add("d");

        printList(intList);
        printList(nameList);

    }
}
