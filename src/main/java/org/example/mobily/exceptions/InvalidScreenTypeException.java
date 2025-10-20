package org.example.mobily.exceptions;

public class InvalidScreenTypeException extends RuntimeException {
    public InvalidScreenTypeException(String value) {
        super("Screen Type '" + value + "' is not supported.");
    }
}
