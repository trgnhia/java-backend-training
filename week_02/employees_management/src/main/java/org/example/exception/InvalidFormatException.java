package org.example.exception;

public class InvalidFormatException extends GlobalExceptionHandler{
    public InvalidFormatException (String field) {
        super("Invalid format field: " +  field, "INVALID");
    }
}
