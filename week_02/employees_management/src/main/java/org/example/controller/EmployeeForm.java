package org.example.controller;

import org.example.enums.EmployeeType;
import org.example.enums.Status;
import org.example.model.Employee;

import java.time.LocalDate;

public class EmployeeForm {
    private final ConsoleInput input;

    public EmployeeForm(ConsoleInput input) {
        this.input = input;
    }

    public Employee InputForCreate() {
        String id = input.readUniqueId("ID: ");
        return readCommonFields(id);
    }

    public Employee InputForUpdate(String id) {
        return readCommonFields(id);
    }

    private Employee readCommonFields(String id) {
        String name = input.notBlank("Name: ");
        String email = input.readEmail("Email (format: name@domain.com): ");
        String phone = input.readPhone("Phone (digits only, <= 12): ");
        String department = input.notBlank("Department: ");
        EmployeeType type = input.chooseEmployeeType();
        double salary = input.readDouble("Salary: ");
        LocalDate hiredDate = input.readLocalDate("Hired date (DD/MM/yyyy): ");
        Status status = input.chooseStatus();

        return new Employee(id, name, email, phone, department, type, salary, hiredDate, status);
    }
}