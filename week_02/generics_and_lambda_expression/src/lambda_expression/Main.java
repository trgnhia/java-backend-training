package lambda_expression;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class Main {

    public static List<Integer> filter (List<Integer> nums, Predicate<Integer> condition) {
        List<Integer> res = new ArrayList<>();
        for (Integer a : nums) {
            if (condition.test(a)) {
                res.add(a);
            }
        }
        return res;
    }

    public static void main(String[] args) {
        List<Integer> numList = new ArrayList<>();
        for (int i = 0; i < 100; i++) {
            numList.add(i);
        }

        List<Integer> evenNums = filter(numList, i -> i % 2 == 0);

        System.out.println(evenNums);
    }
}
