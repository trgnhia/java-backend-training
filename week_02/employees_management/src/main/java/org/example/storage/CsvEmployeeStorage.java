package org.example.storage;

import org.example.enums.EmployeeType;
import org.example.enums.Status;
import org.example.model.Employee;

import java.io.*;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class CsvEmployeeStorage implements EmployeeStorage{
    private final String filePath;

    public CsvEmployeeStorage(String filePath) {
        this.filePath = filePath;
    }

    @Override
    public List<Employee> loadAll() {
        List<Employee> employees = new ArrayList<>();
        File file = new File(filePath);
        if (!file.exists()) {
            return employees;
        }

        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String line;
            while((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                if (parts.length != 9) {
                    continue;
                }
                Employee employee = new Employee(
                        parts[0].trim(),
                        parts[1].trim(),                        // name
                        parts[2].trim(),                        // email
                        parts[3].trim(),                        // phone
                        parts[4].trim(),                        // department
                        EmployeeType.valueOf(parts[5].trim()),
                        Double.parseDouble(parts[6].trim()),
                        LocalDate.parse(parts[7].trim()),
                        Status.valueOf(parts[8].trim())
                );
                employees.add(employee);
            }
        } catch (IOException e) {
            throw new RuntimeException ("Cant not reading CSV ", e );
        }
        return employees;
    }

    @Override
    public void saveAll(Collection<Employee> employees) {

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath))) {

            for (Employee e : employees) {
                String line = String.join(",",
                        e.getId(),
                        e.getName(),
                        e.getEmail(),
                        e.getPhone(),
                        e.getDepartment(),
                        e.getEmployeeType().name(),
                        String.valueOf(e.getSalary()),
                        e.getHiredDate().toString(),
                        e.getStatus().name()
                );
                writer.write(line);
                writer.newLine();
            }

        } catch (IOException e) {
            throw new RuntimeException ("Cant not write CSV ", e );
        }
    }
}
