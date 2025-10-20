package org.example.mobily.exceptions;

public class InvalidBatteryTypeException extends RuntimeException {
    public InvalidBatteryTypeException(String value) {
        super("Battery Type '" + value + "' is not supported.");
    }
}
