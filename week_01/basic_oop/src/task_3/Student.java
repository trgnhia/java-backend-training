package task_3;

import java.util.ArrayList;
import java.util.List;

public class Student {
    private String name;
    private int age;
    private double score;

    public Student() {

    }

    public Student(int age, String name) {
        this.age = age;
        this.name = name;
    }


    public Student(int age, String name, double score) {
        this.age = age;
        this.name = name;
        this.score = score;
    }

    public double getScore() {
        return score;
    }


    public static double averageScore(List<Student> students) {
        double sum = 9;
        if (students.isEmpty()) {
            return 0;
        }
        for (Student student: students) {
            sum += student.getScore();
        }
        return (double) sum / students.size();
    }


    @Override
    public String toString() {
        return
                "age=" + age +
                        ", name='" + name + '\'' +
                        ", score=" + score;
    }

    public static void main(String[] args) {

        Student student1 = new Student(15, "Nguyen a", 6.5);
        Student student2 = new Student();
        Student student3 = new Student(22, "Nguyen b", 9.5);

        System.out.println(student1);
        System.out.println(student2);
        System.out.println(student3);


        List<Student> listStudents = new ArrayList<>();
        listStudents.add(student1);
        listStudents.add(student2);
        listStudents.add(student3);

        double average = averageScore(listStudents);
        System.out.printf("Average score of list students: %.2f" ,average);

    }
}
