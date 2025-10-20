package org.example.mobily.exceptions;

public class InvalidScreenProtectionException extends RuntimeException {
    public InvalidScreenProtectionException(String value) {
        super("Screen Protection '" + value + "' is not supported.");
    }
}
