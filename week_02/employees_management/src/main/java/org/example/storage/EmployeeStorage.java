package org.example.storage;

import org.example.model.Employee;

import java.util.Collection;
import java.util.List;

public interface EmployeeStorage {
    List<Employee> loadAll();
    void saveAll(Collection <Employee> employee);
}
