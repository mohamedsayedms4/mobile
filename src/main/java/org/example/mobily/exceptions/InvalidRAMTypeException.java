package org.example.mobily.exceptions;

public class InvalidRAMTypeException extends RuntimeException {
    public InvalidRAMTypeException(String value) {
        super("RAM Type '" + value + "' is not supported.");
    }
}
