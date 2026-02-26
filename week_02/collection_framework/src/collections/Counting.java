package collections;

import java.util.*;

public class Counting {
    public static void main(String[] args) {
        String plainText = "The weather to day is so cold and i am learning java core in GEM corp. java is core language but weather is so bad";
        Map<String, Integer> count = new HashMap<>();
        String[] words = plainText.split("\\s+");
        for(String word : words) {
            if (count.containsKey(word)) {
                count.put(word, count.get(word) + 1);
            } else {
                count.put(word,1);
            }
        }
        System.out.println("Tan suat xuat hien: ");
        for (Map.Entry<String, Integer> entry : count.entrySet()) {
            System.out.println("Word: " + entry.getKey() + " - " + entry.getValue());
        }

        System.out.println("\nTan suat xuat hien: ");
        count.forEach((key, value) -> {
            System.out.println("Word: " + key + " - " + value);
        });
    }
}
