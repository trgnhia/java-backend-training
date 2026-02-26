package collections.extension;

import java.util.HashMap;
import java.util.*;
import java.util.TreeMap;

public class CountingUpLevel {
    public static void main(String[] args) {
        String plainText = "The weather to day is so cold and i am learning java core in GEM corp." +
                " java is core language but weather is so bad";
        Map<String, Integer> count = new HashMap<>();
        String[] words = plainText.split("\\s+");
        for(String word : words) {
            if (count.containsKey(word)) {
                count.put(word, count.get(word) + 1);
            } else {
                count.put(word,1);
            }
        }

        // sort theo alphabet
        System.out.println("\nTan suat xuat hien theo alphabet: ");
        Map<String, Integer> alpha = new TreeMap<>(count);
        alpha.forEach((key, value) -> {
            System.out.println(key + " " + value);
        });

        // sort theo value giam dan
        System.out.println("\nTan suat xuat hien theo thu tu giam dan: ");
        List<Map.Entry<String, Integer>> list = new ArrayList<>(count.entrySet());
        list.sort((l1, l2) -> {
            int cmp = Integer.compare(l2.getValue(),l1.getValue());
            if (cmp != 0) return cmp;
            return l1.getKey().compareTo(l2.getKey());
        });

        for (Map.Entry<String, Integer> l : list) {
            System.out.println(l.getKey() + " - " + l.getValue());
        }

    }
}
