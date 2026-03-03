package org.example.service;

import org.example.model.Employee;

import java.util.Map;
import java.util.*;

public class EmployeeServiceImpl implements EmployeeService{
    private final Map<String, Employee> employyes = new HashMap<>();

    @Override
    public void addEmployee(Employee employee) {

    }

    @Override
    public void removeEmployee(String id) {

    }

    @Override
    public void updateEmployee(String id) {

    }

    @Override
    public Optional<Employee> findById(String id) {
        return Optional.empty();
    }
}
