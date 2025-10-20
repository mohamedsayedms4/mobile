package org.example.mobily.exceptions;

public class InvalidArchitectureTypeException extends RuntimeException {
    public InvalidArchitectureTypeException(String value) {
        super("Architecture Type '" + value + "' is not supported.");
    }
}
