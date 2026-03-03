package org.example.validation;

import org.example.exception.*;
import org.example.model.Employee;

public class EmployeeValidator {
    public void validate (Employee employee) {
        if (employee == null) {
            throw new InvalidFormatException("employee", "Employee can not be null");
        }
        if (Validator.isBlank(employee.getName())) {
            throw new InvalidFormatException("name", "Employee's name can not be null");
        }
        if (Validator.isBlank(employee.getDepartment())) {
            throw new InvalidFormatException("department", "Employee's name can not be null");
        }
        if (!Validator.isValidEmail(employee.getEmail())) {
            throw new InvalidFormatException("email", employee.getEmail());
        }

        if (!Validator.isValidPhoneNumber(employee.getPhone())) {
            throw new InvalidFormatException("phone", employee.getPhone());
        }

        if (employee.getSalary() < 0) {
            throw new NegativeSalaryException(employee.getSalary());
        }
    }
}
