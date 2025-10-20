package org.example.mobily.exceptions;

public class InvalidChargingMethodException extends RuntimeException {
    public InvalidChargingMethodException(String value) {
        super("Charging Method '" + value + "' is not supported.");
    }
}
