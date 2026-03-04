package org.example.service;

import org.example.enums.EmployeeType;
import org.example.model.Employee;

import java.util.*;

public interface EmployeeService {
    void addEmployee(Employee employee);
    void removeEmployee (String id);
    void updateEmployee (String id, Employee employee);
    Optional<Employee> findById (String id);
    List<Employee> getAll ();
    void saveToFile();
    void loadFromFile();
    List<Employee> getAllSorted(Comparator<Employee> comparator);
    List<Employee> getEmployeeHaveGreaterSalary(double salary);
    double getSummaryOfSalary ();
    double getAverageOfSalary ();
    List<Employee> getEmployeesHaveHighestSalary();
    int employeeCount();
    List<Employee> getActivateEmployee();
    double getHighestSalary();
    List<Employee> searchByName(String keyword);
    List<Employee> searchByDepartment(String keyword);
    List<Employee> searchByType(EmployeeType type);
    List<Employee> searchBySalaryRange(double min, double max);
    List<Double> getTop3HighestSalary();
}
