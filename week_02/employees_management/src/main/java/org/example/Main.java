package org.example;

import org.example.controller.EmployeeController;
import org.example.service.EmployeeService;
import org.example.service.EmployeeServiceImpl;
import org.example.storage.CsvEmployeeStorage;
import org.example.storage.EmployeeStorage;
import org.example.validation.EmployeeValidator;

public class Main {
    public static void main(String[] args) {

        EmployeeValidator validator = new EmployeeValidator();

        EmployeeStorage storage =
                new CsvEmployeeStorage("employees.csv");

        EmployeeService service =
                new EmployeeServiceImpl(storage, validator);

        service.loadFromFile();

        BackGroundScheduler scheduler = new BackGroundScheduler(service);
        scheduler.start();

        EmployeeController controller =
                new EmployeeController(service);

        controller.start();
        scheduler.stop();
    }
}