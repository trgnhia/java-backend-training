package org.example.controller;

import org.example.enums.EmployeeType;
import org.example.model.Employee;
import org.example.service.EmployeeService;

import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class EmployeeController {
    private final EmployeeService employeeService;
    private final Scanner scanner = new Scanner(System.in);

    private final ConsoleInput input;
    private final EmployeeForm employeeForm;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
        this.input = new ConsoleInput(scanner, employeeService);
        this.employeeForm = new EmployeeForm(input);
    }

    public void start() {
        while (true) {
            printMenu();
            int choice = input.readInt("Choose an option: ");

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
                        System.out.print("Do you want to save change?: Y/N ");
                        String option = scanner.nextLine();
                        if (option != null && option.trim().equalsIgnoreCase("y")) {
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

    // ================== Menu ==================

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

    // ================== Handlers ================== //

    private void handleAdd() {
        System.out.println("=== ADD EMPLOYEE ===");
        Employee employee = employeeForm.InputForCreate();
        employeeService.addEmployee(employee);
        System.out.println("Added successfully.");
    }

    private void handleRemove() {
        System.out.println("-----* REMOVE EMPLOYEE *-----");
        String id = input.notBlank("ID: ");
        employeeService.removeEmployee(id);
        System.out.println("Remove employee successfully.");
    }

    private void handleUpdate() {
        System.out.println("-----* UPDATE EMPLOYEE *-----");
        String id = input.notBlank("ID: ");

        if (employeeService.findById(id).isEmpty()) {
            System.out.println("ID not exists: " + id + ". Please enter another ID.");
            return;
        }

        Employee employee = employeeForm.InputForUpdate(id);
        employeeService.updateEmployee(id, employee);
        System.out.println("Updated successfully.");
    }

    private void handleSearch() {
        System.out.println("======== SEARCH WITH FILTER ========");

        List<Employee> result;

        while (true) {
            System.out.println("Choose your option to filter:");
            System.out.println("1. Search by name");
            System.out.println("2. Search by department");
            System.out.println("3. Search by employee type");
            System.out.println("4. Search by salary range");
            System.out.println("Your choice: ");
            int option = Integer.parseInt(scanner.nextLine());

            switch (option) {
                case 1 -> {
                    String keyword = input.notBlank("Enter Name: ");
                    result = employeeService.searchByName(keyword);
                }
                case 2 -> {
                    String keyword = input.notBlank("Enter Department: ");
                    result = employeeService.searchByDepartment(keyword);
                }
                case 3 -> {
                    EmployeeType type = input.chooseEmployeeType();
                    result = employeeService.searchByType(type);
                }
                case 4 -> {
                    double min = input.readDouble("Min salary: ");
                    double max = input.readDouble("Max salary: ");
                    result = employeeService.searchBySalaryRange(min, max);
                }
                default -> {
                    System.out.println("Invalid choice. Please choose 1-4.");
                    continue;
                }
            }
            break;
        }
        System.out.println(result);
    }

    private void handleSort() {
        System.out.println("======== SORTED ========");

        List<Employee> sortedEmployees;

        while (true) {
            System.out.println("Choose your option to sort:");
            System.out.println("1. Sort by name.");
            System.out.println("2. Sort by salary.");
            System.out.println("3. Sort by hire date.");
            int option = input.readInt("Your choice: ");

            switch (option) {
                case 1 -> sortedEmployees = employeeService.getAllSorted(
                        Comparator.comparing(Employee::getName, String.CASE_INSENSITIVE_ORDER)
                );
                case 2 -> sortedEmployees = employeeService.getAllSorted(
                        Comparator.comparingDouble(Employee::getSalary)
                );
                case 3 -> sortedEmployees = employeeService.getAllSorted(
                        Comparator.comparing(Employee::getHiredDate)
                );
                default -> {
                    System.out.println("Invalid choice. Please choose 1-3.");
                    continue;
                }
            }
            break;
        }
         System.out.println(sortedEmployees);
    }

    private void handleStatistics() {
        System.out.println("======== STATISTICS ========");

        while (true) {
            System.out.println("Choose your option to statistics:");
            System.out.println("1. Number of employee.      4. Highest salary.");
            System.out.println("2. Summary salary.          5. Top 3 highest salary.");
            System.out.println("3. Average salary.          6. Activate employees");
            System.out.println("7. Statistic by department.");
            int option = input.readInt("Your choice: ");

            switch (option) {
                case 1 -> System.out.println("Number of employees : " + employeeService.employeeCount());
                case 2 -> System.out.println("Summary salary of company: " + employeeService.getSummaryOfSalary());
                case 3 -> System.out.println("Average salary of company: " + employeeService.getAverageOfSalary());
                case 4 -> System.out.println("Highest salary of company: " + employeeService.getHighestSalary());
                case 5 -> System.out.println("Top 3 highest salary: " + employeeService.getTop3HighestSalary());
                case 6 -> System.out.println("Activate employee of company: " + employeeService.getActivateEmployee());
                case 7 -> System.out.println("Employee by partment: " + employeeService.getEmployeesByDepartment());
                default -> {
                    System.out.println("Invalid choice. Please choose 1-6.");
                    continue;
                }
            }
            break;
        }
    }

    private void handleSave() {
        employeeService.saveToFile();
        System.out.println("Saved to CSV successfully.");
    }

    private void handleLoad() {
        System.out.println("----------*** ALL EMPLOYEES ***----------");
        List<Employee> employeeList = employeeService.getAll();
        System.out.println(employeeList);
    }
}