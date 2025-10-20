package org.example.mobily.model.constants;

import com.fasterxml.jackson.annotation.JsonCreator;
import org.example.mobily.exceptions.InvalidStorageCapacityException;

import java.util.Arrays;

public enum StorageCapacity {
    MB128("128MB", "128 ميجابايت"),
    MB256("256MB", "256 ميجابايت"),
    MB512("512MB", "512 ميجابايت"),

    GB1("1GB", "1 جيجابايت"),
    GB2("2GB", "2 جيجابايت"),
    GB4("4GB", "4 جيجابايت"),
    GB8("8GB", "8 جيجابايت"),
    GB16("16GB", "16 جيجابايت"),
    GB32("32GB", "32 جيجابايت"),
    GB64("64GB", "64 جيجابايت"),
    GB128("128GB", "128 جيجابايت"),
    GB256("256GB", "256 جيجابايت"),
    GB512("512GB", "512 جيجابايت"),
    TB1("1TB", "1 تيرابايت"),
    TB2("2TB", "2 تيرابايت");

    private final String en;
    private final String ar;

    StorageCapacity(String en, String ar) {
        this.en = en;
        this.ar = ar;
    }

    public String getEn() {
        return en;
    }

    public String getAr() {
        return ar;
    }

    public StorageCapacity parseStorageCapacity(String value) {
        return Arrays.stream(StorageCapacity.values())
                .filter(capacity -> capacity.getEn().equalsIgnoreCase(value))
                .findFirst()
                .orElseThrow(() -> new InvalidStorageCapacityException(value));
    }


    @JsonCreator
    public static StorageCapacity fromString(String value) {
        for (StorageCapacity m : StorageCapacity.values()) {
            if (m.name().equalsIgnoreCase(value)) {
                return m;
            }
        }
        throw new org.example.mobily.exceptions.InvalidStorageCapacityException(value);
    }

}

