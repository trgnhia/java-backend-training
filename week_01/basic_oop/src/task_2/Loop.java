package task_2;

import java.util.Scanner;

public class Loop {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Nhập số : ");
        int num = scanner.nextInt();
        if (num % 2 == 0) {
            System.out.println("even number");
        } else {
            System.out.println("odd number");
        }

        if (num % 3 == 0) {
            System.out.println("divisible by 3");
        } else {
            System.out.println("Not divisible by 3");
        }

        for (int i = 2 ; i <= 9 ; i++) {
            System.out.println("Bang cuu chuong nhan: " + i);
            for (int j = 1; j <= 9 ; j++) {
                System.out.println(i + " x " + j + " = " + (i*j));
            }
            System.out.println();
        }

        for (int i = 2 ; i <= 9 ; i++) {
            System.out.println("Bang cuu chuong chia: " + i);
            for (int j = i; j <= i * 10 ; j+=i ) {
                System.out.println(j + " : " + i + " = " + (j/i));
            }
            System.out.println();
        }

    }
}
