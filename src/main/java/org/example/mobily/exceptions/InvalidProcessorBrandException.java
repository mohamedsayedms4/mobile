package org.example.mobily.exceptions;

public class InvalidProcessorBrandException extends RuntimeException {
    public InvalidProcessorBrandException(String value) {
        super("Processor Brand '" + value + "' is not supported.");
    }
}
