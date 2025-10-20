package org.example.mobily.model.constants;


import com.fasterxml.jackson.annotation.JsonCreator;
import lombok.Getter;
import org.example.mobily.exceptions.InvalidArchitectureTypeException;

import java.util.Arrays;

@Getter
public enum ArchitectureType {
    X86("x86", "إكس86"),
    X64("x64", "إكس64"),
    ARM("ARM", "آرم"),
    ARM64("ARM64", "آرم64"),
    OTHER("Other", "أخرى");

    private final String en;
    private final String ar;

    ArchitectureType(String en, String ar) {
        this.en = en;
        this.ar = ar;
    }
    public ArchitectureType parseArchitectureType(String value) {
        return Arrays.stream(ArchitectureType.values())
                .filter(type -> type.getEn().equalsIgnoreCase(value))
                .findFirst()
                .orElseThrow(() -> new InvalidArchitectureTypeException(value));
    }

    @JsonCreator
    public static ArchitectureType fromString(String value) {
        for (ArchitectureType architectureType : ArchitectureType.values()) {
            if (architectureType.name().equalsIgnoreCase(value)) {
                return architectureType;
            }
        }
        throw new org.example.mobily.exceptions.InvalidArchitectureTypeException(value);
    }


}
