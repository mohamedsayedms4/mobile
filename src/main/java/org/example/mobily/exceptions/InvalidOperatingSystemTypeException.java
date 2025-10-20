package org.example.mobily.exceptions;

public class InvalidOperatingSystemTypeException extends RuntimeException {
    public InvalidOperatingSystemTypeException(String value) {
        super("Operating System Type '" + value + "' is not supported.");
    }
}
