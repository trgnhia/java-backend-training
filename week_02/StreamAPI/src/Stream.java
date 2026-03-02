import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

class Student {
    private double score;
    private int age;
    private String name;

    public double getScore() {
        return score;
    }

    public void setScore(double score) {
        this.score = score;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Student(double score, int age, String name) {
        this.score = score;
        this.age = age;
        this.name = name;
    }

    @Override
    public String toString() {
        return "Student{" +
                "score=" + score +
                ", age=" + age +
                ", name='" + name + '\'' +
                '}';
    }

    public static void main(String[] args) {
        List<Student> studentList = new ArrayList<>();

        studentList.add(new Student(8.5, 18, "Nguyen Van A"));
        studentList.add(new Student(7.2, 19, "Tran Thi B"));
        studentList.add(new Student(9.0, 18, "Le Van C"));
        studentList.add(new Student(6.8, 20, "Pham Thi D"));
        studentList.add(new Student(8.0, 19, "Hoang Van E"));
        studentList.add(new Student(7.5, 18, "Vo Thi F"));
        studentList.add(new Student(9.5, 20, "Dang Van G"));
        studentList.add(new Student(6.5, 18, "Bui Thi H"));
        studentList.add(new Student(8.8, 19, "Do Van I"));
        studentList.add(new Student(7.9, 20, "Ngo Thi K"));
        studentList.add(new Student(8.3, 18, "Phan Van L"));
        studentList.add(new Student(7.0, 19, "Huynh Thi M"));
        studentList.add(new Student(9.2, 20, "Truong Van N"));
        studentList.add(new Student(6.9, 18, "Ly Thi O"));
        studentList.add(new Student(8.7, 19, "Mai Van P"));

        List<Student> students = studentList.stream()
                .filter(stu -> stu.getScore() >= 7)
                .sorted(Comparator.comparingDouble(Student::getScore).reversed())
                .collect(Collectors.toList());
        System.out.println(students);

        Map<Integer, List<Student>> groupedByAge = studentList.stream()
                .collect(Collectors.groupingBy(student -> student.getAge()));

        System.out.println(groupedByAge);

    }
}

public class Stream {
}
