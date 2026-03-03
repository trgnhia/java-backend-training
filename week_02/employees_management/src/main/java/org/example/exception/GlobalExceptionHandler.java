package org.example.exception;

public class GlobalExceptionHandler extends RuntimeException{
    private final String errCode;
    public GlobalExceptionHandler(String message, String errCode) {
        super(message);
        this.errCode = errCode;
    }

    public String getErrCode() {
        return errCode;
    }

    @Override
    public String toString() {
        return "{" +
                "errCode='" + errCode + '\'' +" message = " + getMessage() +
                '}';
    }
}
