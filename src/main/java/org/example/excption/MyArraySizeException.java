package org.example.excption;

public class MyArraySizeException extends Exception{

    private String message;
    public MyArraySizeException(String message) {
        this.message = message;
    }

    @Override
    public String getMessage() {
        return message;
    }
}
