package org.example.controller;

import org.example.enums.EmployeeType;
import org.example.enums.Status;
import org.example.service.EmployeeService;
import org.example.validation.Validator;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class ConsoleInput {
    private final Scanner scanner;
    private final EmployeeService employeeService;

    public ConsoleInput(Scanner scanner, EmployeeService employeeService) {
        this.scanner = scanner;
        this.employeeService = employeeService;
    }

    public String notBlank(String field) {
        while (true) {
            System.out.printf(field);
            String value = scanner.nextLine();
            if (value != null && !value.trim().isEmpty()) {
                return value.trim();
            }
            System.out.println("Input cant be blank, please try again.");
        }
    }

    public int readInt(String field) {
        while (true) {
            System.out.printf(field);
            String value = scanner.nextLine();
            try {
                return Integer.parseInt(value.trim());
            } catch (NumberFormatException e) {
                System.out.println("Invalid number. Try again.");
            }
        }
    }

    public double readDouble(String field) {
        while (true) {
            System.out.printf(field);
            String value = scanner.nextLine().replace(",", ".");
            try {
                return Double.parseDouble(value);
            } catch (NumberFormatException e) {
                System.out.println("Invalid number. Try again.");
            }
        }
    }

    public LocalDate readLocalDate(String field) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        while (true) {
            System.out.println(field);
            String value = scanner.nextLine();
            try {
                return LocalDate.parse(value.trim(), formatter);
            } catch (Exception e) {
                System.out.println("Invalid date format. Use dd/MM/yyyy.");
            }
        }
    }

    public EmployeeType chooseEmployeeType() {
        while (true) {
            System.out.println("Choose Employee Type:");
            System.out.println("1. FULL_TIME");
            System.out.println("2. PART_TIME");
            System.out.println("3. INTERN");
            System.out.println("4. ONSITE");
            System.out.print("Your choice: ");

            String input = scanner.nextLine().trim();
            switch (input) {
                case "1": return EmployeeType.FULL_TIME;
                case "2": return EmployeeType.PART_TIME;
                case "3": return EmployeeType.INTERN;
                case "4": return EmployeeType.ONSITE;
                default: System.out.println("Invalid choice. Please choose 1-4.");
            }
        }
    }

    public Status chooseStatus() {
        while (true) {
            System.out.println("Choose Status:");
            System.out.println("1. ACTIVE");
            System.out.println("2. INACTIVE");
            System.out.print("Your choice: ");

            String input = scanner.nextLine().trim();
            switch (input) {
                case "1": return Status.ACTIVE;
                case "2": return Status.INACTIVE;
                default: System.out.println("Invalid choice. Please choose 1-2.");
            }
        }
    }

    public String readEmail(String field) {
        while (true) {
            String email = notBlank(field);
            if (Validator.isValidEmail(email)) return email;
            System.out.println("Invalid email. Example: name@domain.com");
        }
    }

    public String readPhone(String field) {
        while (true) {
            String phone = notBlank(field);
            if (Validator.isValidPhoneNumber(phone)) return phone;
            System.out.println("Invalid phone. Only digits 0-9, length <= 12.");
        }
    }

    public String readUniqueId(String field) {
        while (true) {
            String id = notBlank(field);
            if (employeeService.findById(id).isPresent()) {
                System.out.println("ID already exists. Please enter another ID.");
            } else {
                return id;
            }
        }
    }
}