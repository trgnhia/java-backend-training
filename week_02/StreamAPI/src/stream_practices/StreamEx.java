package stream_practices;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class StreamEx {
    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 38, 4, 4);

        List<Integer> evenNums = numbers.stream()
                .filter(num -> num % 2 == 0)
                .collect(Collectors.toList());
        System.out.println(evenNums);

        List<Integer> greaterFive = numbers.stream()
                .filter(num -> num > 5)
                .collect(Collectors.toList());
        System.out.println(greaterFive);

        List<Long> powValue = numbers.stream()
                .map(x -> (long) x * x)
                .collect(Collectors.toList());
        System.out.println(powValue);

        List<String> convert = numbers.stream()
                .map(x -> "num = " + x)
                .collect(Collectors.toList());
        System.out.println(convert);

        List<Integer> sortAsc = numbers.stream()
                .sorted()
                .collect(Collectors.toList());

        List<Integer> sortDesc = numbers.stream()
                .sorted(Comparator.reverseOrder())
                .collect(Collectors.toList());
        System.out.println(sortDesc);


        boolean isGreaterThan8 = numbers.stream()
                        .anyMatch(num -> num > 8);
        System.out.println(isGreaterThan8);

        Optional<Integer> firtNumberGreaterThan5  = numbers.stream()
                        .filter(num -> num > 5)
                        .findFirst();
        System.out.println(firtNumberGreaterThan5);

        long summary = numbers.stream()
                        .reduce(0, Integer::sum);
        System.out.println(summary);

        long res = numbers.stream()
                        .reduce(1, (a,b) -> a*b);
        System.out.println(res);

        System.out.println(sortAsc);


    }
}
