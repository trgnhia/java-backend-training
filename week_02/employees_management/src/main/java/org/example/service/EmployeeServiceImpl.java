package org.example.service;

import org.example.exception.*;
import org.example.model.Employee;
import org.example.storage.EmployeeStorage;
import org.example.validation.EmployeeValidator;

import java.util.Map;
import java.util.*;

public class EmployeeServiceImpl implements EmployeeService{
    private final Map<String, Employee> employees = new HashMap<>();
    private final EmployeeValidator employeeValidator;
    private final EmployeeStorage employeeStorage;

    public EmployeeServiceImpl(EmployeeStorage employeeStorage, EmployeeValidator employeeValidator) {
        this.employeeStorage = employeeStorage;
        this.employeeValidator = employeeValidator;
    }

    @Override
    public void loadFromFile() {
        List<Employee> loadedEmployees = employeeStorage.loadAll();
        employees.clear();
        for (Employee e : loadedEmployees) {
            employees.put(e.getId(), e);
        }
    }

    @Override
    public void saveToFile() {
        employeeStorage.saveAll(employees.values());
    }

    @Override
    public void addEmployee(Employee employee) {
        employeeValidator.validate(employee);
        String id = employee.getId();
        if (employees.containsKey(id)) {
            throw new DuplicateIdException(id);
        }
        employees.put(id, employee);
    }

    @Override
    public void removeEmployee(String id) {
        if (!employees.containsKey(id)) {
            throw new ResourceNotFoundException(id);
        }
        employees.remove(id);
    }

    @Override
    public void updateEmployee(String id, Employee updatedEmployee) {
        if (!employees.containsKey(id)) {
            throw new ResourceNotFoundException(id);
        }
        updatedEmployee.setId(id);
        employeeValidator.validate(updatedEmployee);
        employees.put(id, updatedEmployee);
    }

    @Override
    public Optional<Employee> findById(String id) {
        return Optional.ofNullable(employees.get(id));
    }

    @Override
    public List<Employee> getAll() {
        return new ArrayList<>(employees.values());
    }
}
