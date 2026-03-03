package org.example.service;

import org.example.model.Employee;

import java.util.Optional;

public interface EmployeeService {
    void addEmployee(Employee employee);
    void removeEmployee (String id);
    void updateEmployee (String id);
    Optional<Employee> findById (String id);
}
