package org.example;

import org.example.service.EmployeeService;

import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class BackGroundScheduler {
    private final EmployeeService emplService;
    private final ScheduledExecutorService scheduler = Executors.newScheduledThreadPool(2);

    public BackGroundScheduler(EmployeeService emplService) {
        this.emplService = emplService;
    }

    public void start() {
        Runnable saveFileTask = () -> {
            try {
                emplService.saveToFile();
                System.out.println("[AutoSave] File saved.");
            } catch (Exception e) {
                System.out.println("[AutoSave] Error: " + e.getMessage());
            }
        };
        scheduler.scheduleAtFixedRate(saveFileTask, 60, 60, TimeUnit.SECONDS);

        Runnable printSalary = () -> {
            try {
                double total = emplService.getSummaryOfSalary();
                System.out.println("[SalaryStats] Total salary = " + total);
            } catch (Exception e) {
                System.out.println("[SalaryStats] Error: " + e.getMessage());
            }
        };
        scheduler.scheduleAtFixedRate(printSalary, 30, 30, TimeUnit.SECONDS);

    }
    public void stop () {
        scheduler.shutdown();
    }
}
