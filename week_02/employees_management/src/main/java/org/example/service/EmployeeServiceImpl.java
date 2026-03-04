package org.example.service;

import org.example.enums.EmployeeType;
import org.example.enums.Status;
import org.example.exception.*;
import org.example.model.Employee;
import org.example.storage.EmployeeStorage;
import org.example.validation.EmployeeValidator;

import java.util.Map;
import java.util.*;
import java.util.stream.Collectors;

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
    public List<Employee> getAllSorted(Comparator<Employee> comparator) {
        return employees.values().stream()
                .sorted(comparator)
                .collect(Collectors.toList());
    }

    @Override
    public List<Employee> getEmployeeHaveGreaterSalary(double salary) {
        return employees.values().stream()
                .filter(e -> e.getSalary() > salary)
                .collect(Collectors.toList());
    }

    @Override
    public double getSummaryOfSalary() {
        return employees.values().stream()
                .mapToDouble(Employee::getSalary)
                .sum();
    }

    @Override
    public double getAverageOfSalary() {
        return employees.values().stream()
                .mapToDouble(Employee::getSalary)
                .average()
                .orElse(0);
    }

    @Override
    public List<Employee> getEmployeesHaveHighestSalary() {
        double highestSalary = getHighestSalary();
        return employees.values().stream()
                .filter(e -> e.getSalary() == highestSalary)
                .collect(Collectors.toList());
    }

    @Override
    public int employeeCount() {
        return employees.size();
    }

    @Override
    public List<Employee> getActivateEmployee() {
        return employees.values().stream()
                .filter(e -> e.getStatus() == Status.ACTIVE)
                .collect(Collectors.toList());
    }

    @Override
    public double getHighestSalary() {
        return   employees.values().stream()
                .mapToDouble(Employee::getSalary)
                .max()
                .orElse(0);
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
