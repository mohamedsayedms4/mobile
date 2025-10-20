package org.example.mobily.model.constants;


import com.fasterxml.jackson.annotation.JsonCreator;
import lombok.Getter;
import org.example.mobily.exceptions.InvalidRAMTypeException;

import java.util.Arrays;

@Getter
public enum RAMType {
    DDR3("DDR3", "دي دي آر 3"),
    DDR4("DDR4", "دي دي آر 4"),
    DDR5("DDR5", "دي دي آر 5"),
    LPDDR3("LPDDR3", "إل بي دي دي آر 3"),
    LPDDR4("LPDDR4", "إل بي دي دي آر 4"),
    LPDDR4X("LPDDR4X", "إل بي دي دي آر 4 إكس"), // تم إضافة هذا الخيار
    LPDDR5("LPDDR5", "إل بي دي دي آر 5"),
    OTHER("Other", "أخرى");
    private final String en;
    private final String ar;

    RAMType(String en, String ar) {
        this.en = en;
        this.ar = ar;
    }

    public RAMType parseRAMType(String value) {
        return Arrays.stream(RAMType.values())
                .filter(type -> type.getEn().equalsIgnoreCase(value))
                .findFirst()
                .orElseThrow(() -> new InvalidRAMTypeException(value));
    }

    @JsonCreator
    public static RAMType fromString(String value) {
        for (RAMType m : RAMType.values()) {
            if (m.name().equalsIgnoreCase(value)) {
                return m;
            }
        }
        throw new org.example.mobily.exceptions.InvalidRAMTypeException(value);
    }
}
