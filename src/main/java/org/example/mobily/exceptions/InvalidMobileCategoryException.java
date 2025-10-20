package org.example.mobily.exceptions;

public class InvalidMobileCategoryException extends RuntimeException {
    public InvalidMobileCategoryException(String value) {
        super("Mobile Category '" + value + "' is not supported.");
    }
}
