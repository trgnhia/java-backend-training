package task_1;


import java.util.Scanner;

public class Calculator {
    public long summary(int a, int b) {
        return a + b;
    }

    public int diff(int a, int b) {
        return a - b;
    }

    public long result(int a, int b) {
        return a * b;
    }

    public double div(int a, int b) {
        if (b == 0) {
            throw new ArithmeticException("Cant div by zero");
        }
        return (double) a / b;
    }

    public double area(int radius) {
        return Math.PI * radius * radius;
    }

    public double perimeter(int radius) {
        return Math.PI * radius * 2;
    }

    public static void main(String[] args) {
        Calculator cal = new Calculator();
        Scanner scanner = new Scanner(System.in);
        System.out.println("Nhập số a: ");
        int a = scanner.nextInt();
        System.out.println("Nhập số b: ");
        int b = scanner.nextInt();

        long sum = cal.summary(a, b);
        int diff = cal.diff(a, b);
        long res = cal.result(a, b);
        double div = cal.div(a, b);
        System.out.println("Tổng, hiệu, tích, thương lần lượt là:\n" + sum + "\n" + diff + "\n" + res + "\n" + div);

        System.out.println("Nhập bán kính r: ");
        int radius = scanner.nextInt();
        double area = cal.area(radius);
        double perimeter = cal.perimeter(radius);
        System.out.printf("Diện tích: %.2f\n", area);
        System.out.printf("Chu vi: %.2f\n", perimeter);

    }
}