package org.example.mobily.exceptions;

public class InvalidMobileBrandException extends RuntimeException {
    public InvalidMobileBrandException(String value) {
        super("Mobile Brand '" + value + "' is not supported.");
    }
}
