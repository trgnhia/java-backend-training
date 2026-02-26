package lambda_expression;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        List<Integer> numList = new ArrayList<>();
        for (int i = 0; i < 100; i++) {
            numList.add(i);
        }

        List<Integer> evenNums = numList.stream()
                .filter(i -> i % 2 == 0)
                .collect(Collectors.toList());

        System.out.println(evenNums);
    }
}
