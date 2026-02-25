package task_5;

import java.io.*;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Nhập số a: ");
        int a = scanner.nextInt();
        System.out.println("Nhập số b: ");
        int b = scanner.nextInt();

        try {
            if (b == 0) {
                throw new ArithmeticException("Divide by zero");
            }
            double result = (double) a / b;
            System.out.println(result);

        } catch (ArithmeticException e) {
            System.out.println(e.getMessage());

        } finally {
            System.out.println("Done");
        }


        // read file
        String path = "data.txt";

        try (BufferedReader br = new BufferedReader(new FileReader(path))) {
            String line;
            int lineNo = 1;
            while ((line = br.readLine()) != null) {
                System.out.println(lineNo + ": " + line);
                lineNo++;
            }

        } catch (IOException e) {
            System.out.println("Cannot read file: " + e.getMessage());
        }
// scanner
        File file = new File("data.txt");

        try (Scanner sc = new Scanner(file)) {
            int lineNo = 1;
            while (sc.hasNextLine()) {
                String line = sc.nextLine();
                System.out.println(lineNo + ": " + line);
                lineNo++;
            }
        } catch (FileNotFoundException e) {
            System.out.println("Không tìm thấy file: " + e.getMessage());
        }
    }
}
