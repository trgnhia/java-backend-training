package collections;

import java.util.ArrayList;
import java.util.*;

public class SortNames {
    public static void main(String[] args) {
        List<String> names = new ArrayList<>();
        names.add("Minh");
        names.add("An");
        names.add("Jonh");
        names.add("Kelvin");
        names.add("Long");

        Collections.sort(names);

        System.out.println("Danh sach sau khi sap xep: ");
        for(String name: names) {
            System.out.println(name);
        }
    }
}
