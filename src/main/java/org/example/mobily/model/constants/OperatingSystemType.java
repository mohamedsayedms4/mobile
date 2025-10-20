package org.example.mobily.model.constants;

import com.fasterxml.jackson.annotation.JsonCreator;
import lombok.Getter;
import org.example.mobily.exceptions.InvalidOperatingSystemTypeException;

import java.util.Arrays;

@Getter
public enum OperatingSystemType {
    ANDROID("Android", "أندرويد"),
    IOS("iOS", "آي أو إس"),
    HARMONY("HarmonyOS", "هارموني"),
    WINDOWS("Windows", "ويندوز"),
    LINUX("Linux", "لينكس"),
    OTHER("Other", "أخرى");

    private final String en;
    private final String ar;

    OperatingSystemType(String en, String ar) {
        this.en = en;
        this.ar = ar;
    }

    public OperatingSystemType parseOperatingSystemType(String value) {
        return Arrays.stream(OperatingSystemType.values())
                .filter(os -> os.getEn().equalsIgnoreCase(value))
                .findFirst()
                .orElseThrow(() -> new InvalidOperatingSystemTypeException(value));
    }

    @JsonCreator
    public static OperatingSystemType fromString(String value) {
        for (OperatingSystemType m : OperatingSystemType.values()) {
            if (m.name().equalsIgnoreCase(value)) {
                return m;
            }
        }
        throw new org.example.mobily.exceptions.InvalidOperatingSystemTypeException(value);
    }
}
