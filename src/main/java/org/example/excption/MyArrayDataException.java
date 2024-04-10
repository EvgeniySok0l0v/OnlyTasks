package org.example.excption;

public class MyArrayDataException extends NumberFormatException{

    public MyArrayDataException(String message) {
        super(message);
    }

    @Override
    public String getMessage() {
        return super.getLocalizedMessage();
    }
}
