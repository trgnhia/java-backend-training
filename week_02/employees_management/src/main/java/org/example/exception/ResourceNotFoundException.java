package org.example.exception;

public class ResourceNotFoundException extends GlobalExceptionHandler{
    public ResourceNotFoundException(String resource) {
        super("Can't not found employee with: " + resource, "NOT_FOUND");
    }
}
