package org.example.mobily.model.constants;


import com.fasterxml.jackson.annotation.JsonCreator;
import lombok.Getter;
import org.example.mobily.exceptions.InvalidScreenTypeException;

import java.util.Arrays;

@Getter
public enum ScreenType {
    AMOLED("AMOLED", "أموليد"),
    SUPER_AMOLED("Super AMOLED", "سوبر أموليد"),
    LCD("LCD", "إل سي دي"),
    IPS("IPS", "آي بي إس"),
    OLED("OLED", "أولد"),
    LED("LED", "إل إي دي"),
    OTHER("Other", "أخرى");

    private final String en;
    private final String ar;

    ScreenType(String en, String ar) {
        this.en = en;
        this.ar = ar;
    }

    public ScreenType parseScreenType(String value) {
        return Arrays.stream(ScreenType.values())
                .filter(type -> type.getEn().equalsIgnoreCase(value))
                .findFirst()
                .orElseThrow(() -> new InvalidScreenTypeException(value));
    }


    @JsonCreator
    public static ScreenType fromString(String value) {
        for (ScreenType m : ScreenType.values()) {
            if (m.name().equalsIgnoreCase(value)) {
                return m;
            }
        }
        throw new org.example.mobily.exceptions.InvalidScreenTypeException(value);
    }

}
