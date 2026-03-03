package org.example.exception;

public class NegativeSalaryException extends GlobalExceptionHandler{
    public NegativeSalaryException (double salary) {
        super("Salary cant be negative number: " + salary, "NEGATIVE_SALARY");
    }
}
