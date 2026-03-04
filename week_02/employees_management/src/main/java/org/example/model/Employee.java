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
    private Status status;

    public Employee(String id,
                    String name,
                    String email,
                    String phone,
                    String department,
                    EmployeeType employeeType,
                    double salary,
                    LocalDate hiredDate,
                    Status status) {

        this.id = id;
        this.name = name;
        this.email = email;
        this.phone = phone;
        this.department = department;
        this.employeeType = employeeType;
        this.salary = salary;
        this.hiredDate = hiredDate;
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

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public EmployeeType getEmployeeType() {
        return employeeType;
    }

    public void setEmployeeType(EmployeeType employeeType) {
        this.employeeType = employeeType;
    }

    public LocalDate getHiredDate() {
        return hiredDate;
    }

    public void setHiredDate(LocalDate hiredDate) {
        this.hiredDate = hiredDate;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }
}
