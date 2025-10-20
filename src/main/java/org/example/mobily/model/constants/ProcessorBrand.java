package org.example.mobily.model.constants;

import com.fasterxml.jackson.annotation.JsonCreator;
import lombok.Getter;
import org.example.mobily.exceptions.InvalidProcessorBrandException;

import java.util.Arrays;

@Getter
public enum ProcessorBrand {
    INTEL("Intel", "إنتل"),
    AMD("AMD", "إيه إم دي"),
    APPLE("Apple", "أبل"),
    QUALCOMM("Qualcomm", "كوالكوم"),
    MEDIATEK("MediaTek", "ميديا تيك"),
    SAMSUNG("Samsung", "سامسونج"),
    SNAPDRAGON("Snapdragon", "سنابدراجون"),
    EXYNOS("Exynos", "اكسينوس"),
    OTHER("Other", "أخرى");

    private final String en;
    private final String ar;

    ProcessorBrand(String en, String ar) {
        this.en = en;
        this.ar = ar;
    }
    public ProcessorBrand parseProcessorBrand(String value) {
        return Arrays.stream(ProcessorBrand.values())
                .filter(brand -> brand.getEn().equalsIgnoreCase(value))
                .findFirst()
                .orElseThrow(() -> new InvalidProcessorBrandException(value));
    }



    @JsonCreator
    public static ProcessorBrand fromString(String value) {
        for (ProcessorBrand m : ProcessorBrand.values()) {
            if (m.name().equalsIgnoreCase(value)) {
                return m;
            }
        }
        throw new org.example.mobily.exceptions.InvalidProcessorBrandException(value);
    }
}
