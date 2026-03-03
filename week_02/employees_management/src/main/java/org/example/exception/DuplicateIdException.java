package org.example.exception;

public class DuplicateIdException extends GlobalExceptionHandler{
    public DuplicateIdException(String id) {
        super("Id already exists: " + id, "DUPLICATED_ID");
    }
}
