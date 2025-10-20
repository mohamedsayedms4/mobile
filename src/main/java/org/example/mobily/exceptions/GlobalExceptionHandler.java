package org.example.mobily.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.LocalDateTime;
import java.util.Map;

@ControllerAdvice
public class GlobalExceptionHandler {

    // دالة مساعدة لتقليل التكرار
    private ResponseEntity<Map<String, Object>> buildResponse(Exception ex, String error, HttpStatus status) {
        Map<String, Object> body = Map.of(
                "timestamp", LocalDateTime.now(),
                "status", status.value(),
                "error", error,
                "message", ex.getMessage()
        );
        return new ResponseEntity<>(body, status);
    }

    @ExceptionHandler({
            InvalidCurrencyException.class,
            InvalidArchitectureTypeException.class,
            InvalidBatteryTypeException.class,
            InvalidChargingMethodException.class,
            InvalidChargingStandardException.class,
            InvalidGPUBrandException.class,
            InvalidManufacturingMaterialException.class,
            InvalidMobileBrandException.class,
            InvalidMobileCategoryException.class,
            InvalidOperatingSystemTypeException.class,
            InvalidProcessorBrandException.class,
            InvalidRAMTypeException.class,
            InvalidRatingException.class,
            InvalidScreenProtectionException.class,
            InvalidScreenTypeException.class,
            InvalidStorageCapacityException.class
    })
    public ResponseEntity<Map<String, Object>> handleAllCustomExceptions(RuntimeException ex) {
        String error;

        switch (ex.getClass().getSimpleName()) {
            case "InvalidCurrencyException" -> error = "Invalid Currency";
            case "InvalidArchitectureTypeException" -> error = "Invalid Architecture Type";
            case "InvalidBatteryTypeException" -> error = "Invalid Battery Type";
            case "InvalidChargingMethodException" -> error = "Invalid Charging Method";
            case "InvalidChargingStandardException" -> error = "Invalid Charging Standard";
            case "InvalidGPUBrandException" -> error = "Invalid GPU Brand";
            case "InvalidManufacturingMaterialException" -> error = "Invalid Manufacturing Material";
            case "InvalidMobileBrandException" -> error = "Invalid Mobile Brand";
            case "InvalidMobileCategoryException" -> error = "Invalid Mobile Category";
            case "InvalidOperatingSystemTypeException" -> error = "Invalid Operating System Type";
            case "InvalidProcessorBrandException" -> error = "Invalid Processor Brand";
            case "InvalidRAMTypeException" -> error = "Invalid RAM Type";
            case "InvalidRatingException" -> error = "Invalid Rating";
            case "InvalidScreenProtectionException" -> error = "Invalid Screen Protection";
            case "InvalidScreenTypeException" -> error = "Invalid Screen Type";
            case "InvalidStorageCapacityException" -> error = "Invalid Storage Capacity";
            default -> error = "Invalid Value";
        }

        return buildResponse(ex, error, HttpStatus.BAD_REQUEST);
    }
}
