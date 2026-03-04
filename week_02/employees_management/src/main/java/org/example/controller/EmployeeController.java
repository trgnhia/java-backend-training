package org.example.controller;

import org.example.enums.EmployeeType;
import org.example.enums.Status;
import org.example.model.Employee;
import org.example.service.EmployeeService;
import org.example.validation.Validator;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

import static java.util.Comparator.comparing;

public class EmployeeController {
    private final EmployeeService employeeService;
    private final Scanner scanner = new Scanner(System.in);

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    public void start() {
        while (true) {
            printMenu();
            System.out.printf("Choose an option: ");
            int choice = Integer.parseInt(scanner.nextLine());
            try {
                switch (choice) {
                    case 1 -> handleAdd();
                    case 2 -> handleRemove();
                    case 3 -> handleUpdate();
                    case 4 -> handleSearch();
                    case 5 -> handleSort();
                    case 6 -> handleStatistics();
                    case 7 -> handleSave();
                    case 8 -> handleLoad();
                    case 9 -> {
                        System.out.println("Do you want to save change?: Y/N ");
                        String option = scanner.nextLine();
                        if (option.toLowerCase().equals("y")) {
                            handleSave();
                        }
                        System.out.println("Byee!");
                        return;
                    }
                    default -> System.out.println("Invalid choice. Please try again.");
                }
            } catch (RuntimeException e) {
                System.out.println(e.toString());
            } catch (Exception e) {
                System.out.println("Unexpected error: " + e.getMessage());
            }
        }
    }

    // ================== Helpers ==================

    private void printMenu() {
        System.out.println();
        System.out.println("=========== EMPLOYEE MANAGEMENT ===========");
        System.out.println("1. Add          6. Statistics");
        System.out.println("2. Remove       7. Save");
        System.out.println("3. Update       8. Load");
        System.out.println("4. Search       9. Exit");
        System.out.println("5. Sort");
        System.out.println("===========================================");
    }

    private void handleAdd() {
        System.out.println("=== ADD EMPLOYEE ===");
        String id = readUniqueId("ID: ");
        String name = notBlank("Name: ");
        String email = readEmail("Email (format: name@domain.com): ");
        String phone = readPhone("Phone (digits only, <= 12): ");
        String department = notBlank("Department: ");
        EmployeeType type = chooseEmployeeType();
        double salary = readDouble("Salary: ");
        LocalDate hiredDate = readLocalDate("Hired date (DD/MM/yyyy): ");
        Status status = chooseStatus();

        Employee employee = new Employee(
                id, name, email, phone, department, type, salary, hiredDate, status
        );
        employeeService.addEmployee(employee);
        System.out.println("Added successfully.");
    }

    private void handleSave() {
        employeeService.saveToFile();
        System.out.println("Saved to CSV successfully.");
    }

    private void handleStatistics() {
        System.out.println("======== STATISTICS ========");
        List<Employee> employees;
        while (true) {
            System.out.println("Choose your option to statistics:");
            System.out.println("1. Number of employee.      4. Highest salary.");
            System.out.println("2. Summary salary.          5. Top 3 highest salary.");
            System.out.println("3. Average salary.          6. Activate employees");
            int option = Integer.parseInt(scanner.nextLine());
            System.out.print("Your choice: ");
            switch (option) {
                case 1 -> {
                    System.out.println("Number of employees : " + employeeService.employeeCount());
                }
                case 2 -> {
                    System.out.printf("Summary salary of company: " + employeeService.getSummaryOfSalary());
                }
                case 3 -> {
                    System.out.printf("Average salary of company: " + employeeService.getAverageOfSalary());
                }
                case 4 -> {
                    System.out.printf("Highest salary of company: " + employeeService.getHighestSalary());
                }
                case 5 -> {
                    System.out.printf("Average salary of company: " + employeeService.getAverageOfSalary());
                }
                case 6 -> {
                    System.out.printf("Activate employee of company: " + employeeService.getActivateEmployee());
                }
                default -> {
                    System.out.println("Invalid choice. Please choose 1-6.");
                    continue;
                }
            }
            break;
        }
    }

    private void handleSearch() {
        System.out.println("======== SREACH WITH FILTER ========");
        List<Employee> employees;
        while (true) {
            System.out.println("Choose your option to filter:");
            System.out.println("1. Search by salary greater.        3. Search by salary range.");
            System.out.println("2. Search by name.                  4. Search by employee type.");
            System.out.println("            5. Search by department.");
            System.out.print("Your choice: ");
            int option = Integer.parseInt(scanner.nextLine());
            switch (option) {
                case 1 -> {
                    System.out.printf("Salary: ");
                    Double salary = Double.parseDouble(scanner.nextLine().replace(",", "."));
                    employees = employeeService.getEmployeeHaveGreaterSalary(salary);
                }

                default -> {
                    System.out.println("Invalid choice. Please choose 1-5.");
                    continue;
                }
            }
            break;
        }
        System.out.println(employees);
    }

    private void handleSort() {
        System.out.println("======== SORTED ========");
        List<Employee> sortedEmployees;
        while (true) {
            System.out.println("Choose your option to sort:");
            System.out.println("1. Sort by name.");
            System.out.println("2. Sort by salary.");
            System.out.println("3. Sort by hire date.");
            System.out.print("Your choice: ");

            int option = Integer.parseInt(scanner.nextLine());
            switch (option) {
                case 1 -> {
                    sortedEmployees = employeeService.getAllSorted(
                            Comparator.comparing(Employee::getName, String.CASE_INSENSITIVE_ORDER)
                    );
                }
                case 2 -> {
                    sortedEmployees = employeeService.getAllSorted(
                            Comparator.comparingDouble(Employee::getSalary)
                    );
                }
                case 3 -> {
                    sortedEmployees = employeeService.getAllSorted(
                            Comparator.comparing(Employee::getHiredDate)
                    );
                }
                default -> {
                    System.out.println("Invalid choice. Please choose 1-3.");
                    continue;
                }
            }
            break;
        }
        //sortedEmployees.forEach(System.out::println);
        System.out.println(sortedEmployees);
    }

    private void handleLoad() {
        System.out.println("----------*** ALL EMPLOYEES ***----------");
        List<Employee> employeeList = employeeService.getAll();
        System.out.println(employeeList);
    }

    private void handleRemove() {
        System.out.println("-----* REMOVE EMPLOYEE *-----");
        String id = notBlank("ID: ");
        employeeService.removeEmployee(id);
        System.out.println("Remove employee successfully.");
    }

    private void handleUpdate() {
        System.out.println("-----* UPDATE EMPLOYEE *-----");
        String id = notBlank("ID: ");
        if (!employeeService.findById(id).isPresent()) {
            System.out.println("ID not exists: " + id + ". Please enter another ID.");
        } else {
            String name = notBlank("Name: ");
            String email = readEmail("Email (format: name@domain.com): ");
            String phone = readPhone("Phone (digits only, <= 12): ");
            String department = notBlank("Department: ");
            EmployeeType type = chooseEmployeeType();
            double salary = readDouble("Salary: ");
            LocalDate hiredDate = readLocalDate("Hired date (DD/MM/yyyy): ");
            Status status = chooseStatus();

            Employee employee = new Employee(
                    id, name, email, phone, department, type, salary, hiredDate, status
            );
            employeeService.updateEmployee(id, employee);
        }
    }


    private String notBlank(String field) {
        while (true) {
            System.out.printf(field);
            String value = scanner.nextLine();
            if (value != null && !value.trim().isEmpty()) {
                return value.trim();
            }
            System.out.println("Input cant be blank, please try again.");
        }
    }

    private Double readDouble(String field) {
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

    private LocalDate readLocalDate(String field) {
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

    private EmployeeType chooseEmployeeType() {
        while (true) {
            System.out.println("Choose Employee Type:");
            System.out.println("1. FULL_TIME");
            System.out.println("2. PART_TIME");
            System.out.println("3. INTERN");
            System.out.println("4. ONSITE");
            System.out.print("Your choice: ");

            String input = scanner.nextLine().trim();
            switch (input) {
                case "1":
                    return EmployeeType.FULL_TIME;
                case "2":
                    return EmployeeType.PART_TIME;
                case "3":
                    return EmployeeType.INTERN;
                case "4":
                    return EmployeeType.ONSITE;
                default:
                    System.out.println("Invalid choice. Please choose 1-4.");
            }
        }
    }

    private Status chooseStatus() {
        while (true) {
            System.out.println("Choose Status:");
            System.out.println("1. ACTIVE");
            System.out.println("2. INACTIVE");
            System.out.print("Your choice: ");

            String input = scanner.nextLine().trim();
            switch (input) {
                case "1":
                    return Status.ACTIVE;
                case "2":
                    return Status.INACTIVE;
                default:
                    System.out.println("Invalid choice. Please choose 1-2.");
            }
        }
    }

    private String readEmail(String field) {
        while (true) {
            String email = notBlank(field);
            if (Validator.isValidEmail(email)) return email;
            System.out.println("Invalid email. Example: name@domain.com");
        }
    }

    private String readPhone(String field) {
        while (true) {
            String phone = notBlank(field);
            if (Validator.isValidPhoneNumber(phone)) return phone;
            System.out.println("Invalid phone. Only digits 0-9, length <= 12.");
        }
    }

    private String readUniqueId(String field) {
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
