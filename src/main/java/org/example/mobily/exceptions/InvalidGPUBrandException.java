package org.example.mobily.exceptions;

public class InvalidGPUBrandException extends RuntimeException {
    public InvalidGPUBrandException(String value) {
        super("GPU Brand '" + value + "' is not supported.");
    }
}
