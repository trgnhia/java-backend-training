package org.example.exception;

public class InvalidFormatException extends GlobalExceptionHandler {
    public InvalidFormatException(String field, String message) {
        super("Invalid format field: " + field + ": " + message, "INVALID");
    }
}
