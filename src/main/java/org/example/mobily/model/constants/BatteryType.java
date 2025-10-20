package org.example.mobily.model.constants;

import com.fasterxml.jackson.annotation.JsonCreator;
import lombok.Getter;
import org.example.mobily.exceptions.InvalidBatteryTypeException;

import java.util.Arrays;

@Getter
public enum BatteryType {
    LI_ION("Lithium-Ion", "ليثيوم أيون"),
    LI_PO("Lithium-Polymer", "ليثيوم بوليمر"),
    NIMH("Nickel-Metal Hydride", "هيدريد النيكل المعدني");

    private final String en;
    private final String ar;

    BatteryType(String en, String ar) {
        this.en = en;
        this.ar = ar;
    }

    public BatteryType parseBatteryType(String value) {
        return Arrays.stream(BatteryType.values())
                .filter(type -> type.getEn().equalsIgnoreCase(value))
                .findFirst()
                .orElseThrow(() -> new InvalidBatteryTypeException(value));
    }


    @JsonCreator
    public static BatteryType fromString(String value) {
        for (BatteryType m : BatteryType.values()) {
            if (m.name().equalsIgnoreCase(value)) {
                return m;
            }
        }
        throw new org.example.mobily.exceptions.InvalidBatteryTypeException(value);
    }

}
