package org.example.mobily.exceptions;

public class InvalidManufacturingMaterialException extends RuntimeException {
    public InvalidManufacturingMaterialException(String value) {
        super("Manufacturing Material '" + value + "' is not supported.");
    }
}
