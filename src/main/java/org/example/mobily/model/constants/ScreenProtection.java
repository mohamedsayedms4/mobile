package org.example.mobily.model.constants;


import com.fasterxml.jackson.annotation.JsonCreator;
import lombok.Getter;
import org.example.mobily.exceptions.InvalidScreenProtectionException;

import java.util.Arrays;

@Getter
public enum ScreenProtection {
    GORILLA_GLASS("Gorilla Glass", "زجاج غوريلا"),
    CERAMIC_SHIELD("Ceramic Shield", "سيراميك شيلد"),
    TEMPERED_GLASS("Tempered Glass", "زجاج مقوى"),
    GORILLA_GLASS_VICTUS("GorillaGlassVictus", "زجاج غوريلا فيكتوس"),
    NONE("None", "بدون"),
    OTHER("Other", "أخرى");

    private final String en;
    private final String ar;

    ScreenProtection(String en, String ar) {
        this.en = en;
        this.ar = ar;
    }

    public ScreenProtection parseScreenProtection(String value) {
        return Arrays.stream(ScreenProtection.values())
                .filter(type -> type.getEn().equalsIgnoreCase(value))
                .findFirst()
                .orElseThrow(() -> new InvalidScreenProtectionException(value));
    }


    @JsonCreator
    public static ScreenProtection fromString(String value) {
        for (ScreenProtection m : ScreenProtection.values()) {
            if (m.name().equalsIgnoreCase(value)) {
                return m;
            }
        }
        throw new org.example.mobily.exceptions.InvalidScreenProtectionException(value);
    }


}
