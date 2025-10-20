package org.example.mobily.exceptions;

public class InvalidCurrencyException extends RuntimeException {
    public InvalidCurrencyException(String value) {
        super("Currency '" + value + "' is not supported.");
    }
}

