package stream_practices;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

class User {
    String name;
    int age;
    double salary;

    public User(String name, int age, double salary) {
        this.name = name;
        this.age = age;
        this.salary = salary;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", salary=" + salary +
                '}';
    }

    public static void main(String[] args) {
        List<User> users = List.of(
                new User("An", 22, 1200.0),
                new User("Binh", 25, 1500.5),
                new User("Cuong", 10, 20600.0),
                new User("Dung", 28, 1800.75),
                new User("Hanh", 5, 25050.0),
                new User("Linh", 24, 1300.25)
        );

        List<String> over18 = users.stream()
                .filter(user -> user.getAge() > 18)
                .map(user -> user.getName())
                .collect(Collectors.toList());
        System.out.println(over18);

        var summaryOfSalary = users.stream()
                .map(User::getSalary)
                .reduce(Double::sum);
        System.out.println(summaryOfSalary);

        boolean isUnder18 = users.stream()
                .anyMatch(user -> user.getAge() < 18);
        System.out.println(isUnder18);

        Optional<User> userHaveMaxSalary = users.stream()
                .sorted(Comparator.comparingDouble(User::getSalary).reversed())
                .findFirst();
        System.out.println(userHaveMaxSalary);

        List<User> filteredUser = users.stream()
                .filter(user -> user.getAge() > 18)
                .sorted(Comparator.comparingDouble(User::getSalary).reversed())
                .limit(2)
                .collect(Collectors.toList());
        System.out.println(filteredUser);

        List<String> usernameHaveThan6000Salary = users.stream()
                .filter(user -> user.getSalary() > 6000)
                .map(user -> user.getName())
                .sorted()
                .collect(Collectors.toList());

        System.out.println(usernameHaveThan6000Salary);


    }

}


public class StreamEx2 {
    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 38, 4, 4);

        List<Long> result = numbers.stream()
                .filter(n -> n % 2 == 0)
                .map(n -> (long) n * 2)
                .collect(Collectors.toList());
        System.out.println(result);

        List<Integer> result2 = numbers.stream()
                .filter(n -> n > 5)
                .sorted()
                .collect(Collectors.toList());
        System.out.println(result2);

        List<Long> result3 = numbers.stream()
                .filter(n -> n % 2 == 0)
                .map(n -> (long) n * n)
                .sorted(Comparator.reverseOrder())
                .collect(Collectors.toList());
        System.out.println(result3);

        long sumOfEvenNumbers = numbers.stream()
                .filter(n -> n % 2 == 0)
                .reduce(0, Integer::sum);
        System.out.println(sumOfEvenNumbers);

        Optional<Integer> firstGreaterThan10AfterSorted = numbers.stream()
                .sorted()
                .filter(n -> n > 10)
                .findFirst();
        System.out.println(firstGreaterThan10AfterSorted);

        // reduce

        List<String> words = Arrays.asList("java", "Springboot", "ReactJS", "NextJS");

    }
}
