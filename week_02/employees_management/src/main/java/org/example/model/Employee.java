package org.example.model;

import org.example.enums.EmployeeType;
import org.example.enums.Status;

import java.time.LocalDate;

public class Employee {
    private String id;
    private String name;
    private String email;
    private String phone;
    private String department;
    private double salary;
    private LocalDate hiredDate;
    private EmployeeType employeeType;
    private Status  status;

    public Employee(String department, String email, EmployeeType employeeType, LocalDate hiredDate, String id, String name, String phone, double salary, Status status) {
        this.department = department;
        this.email = email;
        this.employeeType = employeeType;
        this.hiredDate = hiredDate;
        this.id = id;
        this.name = name;
        this.phone = phone;
        this.salary = salary;
        this.status = status;
    }

    public Employee() {

    }

    @Override
    public String toString() {
        return "Employee{" +
                "department='" + department + '\'' +
                ", id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", phone='" + phone + '\'' +
                ", salary=" + salary +
                ", hiredDate=" + hiredDate +
                ", employeeType=" + employeeType +
                ", status=" + status +
                '}';
    }
}
