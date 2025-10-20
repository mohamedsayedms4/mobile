package org.example.mobily.model.constants;

import com.fasterxml.jackson.annotation.JsonCreator;
import lombok.Getter;
import org.example.mobily.exceptions.InvalidGPUBrandException;

import java.util.Arrays;

@Getter
public enum GPUBrand {
    ADRENO("Adreno", "أدرينو"),
    MALI("Mali", "مالي"),
    INTEL("Intel", "إنتل"),
    AMD("AMD", "إيه إم دي"),
    NVIDIA("NVIDIA", "إنفيديا"),
    APPLE("Apple", "أبل"),
    POWERVR("PowerVR", "باور في آر"), // ✅ القيمة الجديدة
    OTHER("Other", "أخرى");

    private final String en;
    private final String ar;

    GPUBrand(String en, String ar) {
        this.en = en;
        this.ar = ar;
    }

    public static GPUBrand parseGPUBrand(String value) {
        return Arrays.stream(GPUBrand.values())
                .filter(type -> type.getEn().equalsIgnoreCase(value))
                .findFirst()
                .orElseThrow(() -> new InvalidGPUBrandException(value));
    }


    @JsonCreator
    public static GPUBrand fromString(String value) {
        for (GPUBrand m : GPUBrand.values()) {
            if (m.name().equalsIgnoreCase(value)) {
                return m;
            }
        }
        throw new org.example.mobily.exceptions.InvalidGPUBrandException(
                value);
    }
}
