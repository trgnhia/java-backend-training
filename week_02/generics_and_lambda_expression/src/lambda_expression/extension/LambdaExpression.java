package lambda_expression.extension;

import java.util.*;
import java.util.function.BinaryOperator;
import java.util.function.Consumer;
import java.util.function.Function;
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

    public static <T,R> List<R> map (List<T> list, Function<T,R> mapper) {
        List<R> res = new ArrayList<>();
        for (T item : list) {
            res.add(mapper.apply(item));
        }
        return res;
    }

    public static <T> void forEach (List<T> list, Consumer<T> action) {
        for (T item : list) {
            action.accept(item);
        }
    }

    public static int reduce(List<Integer> list, int identity, BinaryOperator<Integer> op) {
        int acc = identity;
        for (Integer x : list) {
            acc = op.apply(acc, x);
        }
        return acc;
    }

    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(1,2,5,7,15,20,1345,945,39);
        List<String> strs = Arrays.asList("trnghia", "anna", "kelvin", "boob");
        System.out.println(filter(numbers, x -> x % 2 == 0));
        System.out.println(filter(numbers, x -> x > 90));
        System.out.println(filter(numbers, x -> x >= 7 && x < 20));

        // Apply Integer List to string list
        System.out.println(map(numbers, x -> "num=" + x));
        System.out.println(map(strs, str -> str.length()));

        // foreach consumer
       forEach(numbers, num -> System.out.println(num));

       // reduce in binaryOperator
        List<Integer> nums = Arrays.asList(5, 2, 3, 4);
        System.out.println(reduce(numbers, 0, (a, b) -> a + b));
        System.out.println(reduce(nums, 1, (a, b) -> a * b));
        System.out.println(reduce(nums, Integer.MIN_VALUE, (a, b) -> Math.max(a, b))); // max = 4

    }
}
