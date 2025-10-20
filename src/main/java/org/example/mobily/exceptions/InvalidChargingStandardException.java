package org.example.mobily.exceptions;

public class InvalidChargingStandardException extends RuntimeException {
    public InvalidChargingStandardException(String value) {
        super("Charging Standard '" + value + "' is not supported.");
    }
}
