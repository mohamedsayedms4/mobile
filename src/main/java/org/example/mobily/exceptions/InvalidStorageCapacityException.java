package org.example.mobily.exceptions;

public class InvalidStorageCapacityException extends RuntimeException {
    public InvalidStorageCapacityException(String value) {
        super("Storage Capacity '" + value + "' is not supported.");
    }
}
