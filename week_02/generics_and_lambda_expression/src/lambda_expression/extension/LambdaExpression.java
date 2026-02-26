package lambda_expression.extension;

import java.util.*;
import java.util.function.Predicate;

public class LambdaExpression {
    public static List<Integer> filter (List<Integer> list, Predicate<Integer> condition) {
        List<Integer> result = new ArrayList<>();
        for (Integer x : list) {
            if (condition.test(x)) {
                result.add(x);
            }
        }
        return result;
    }

    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(1,2,5,7,15,20,1345,945,39);
        System.out.println(filter(numbers, x -> x % 2 == 0));
        System.out.println(filter(numbers, x -> x > 90));
        System.out.println(filter(numbers, x -> x >= 7 && x < 20));
    }
}
