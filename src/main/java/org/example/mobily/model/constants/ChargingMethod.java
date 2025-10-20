package org.example.mobily.model.constants;

import com.fasterxml.jackson.annotation.JsonCreator;
import lombok.Getter;
import org.example.mobily.exceptions.InvalidChargingMethodException;

import java.util.Arrays;

@Getter
public enum ChargingMethod {
    WIRED("Wired", "سلكي"),
    WIRELESS("Wireless", "لاسلكي"),
    REVERSE("Reverse Charging", "شحن عكسي");

    private final String en;
    private final String ar;

    ChargingMethod(String en, String ar) {
        this.en = en;
        this.ar = ar;
    }

    public ChargingMethod parseChargingMethod(String value) {
        return Arrays.stream(ChargingMethod.values())
                .filter(type -> type.getEn().equalsIgnoreCase(value))
                .findFirst()
                .orElseThrow(() -> new InvalidChargingMethodException(value));
    }


    @JsonCreator
    public static ChargingMethod fromString(String value) {
        for (ChargingMethod m : ChargingMethod.values()) {
            if (m.name().equalsIgnoreCase(value)) {
                return m;
            }
        }
        throw new org.example.mobily.exceptions.InvalidChargingMethodException(value);
    }

}
