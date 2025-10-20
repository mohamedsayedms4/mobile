package org.example.mobily.model.constants;

import com.fasterxml.jackson.annotation.JsonCreator;
import lombok.Getter;
import org.example.mobily.exceptions.InvalidChargingStandardException;

import java.util.Arrays;

@Getter
public enum ChargingStandard {
    NOT_SUPPORTED("Not Supported", "غير مدعوم"),
    PD("Power Delivery", "باور دليفري"),
    QC("Quick Charge", "شحن سريع"),
    MAGSAFE("MagSafe", "ماغ سيف"),
    QI("Qi", "تشي"),
    QI2("Qi2", "تشي 2"),
    SUPER_VOOC("Super VOOC", "سوبر فووك"),
    OTHER("Other", "أخرى");
    private final String en;
    private final String ar;

    ChargingStandard(String en, String ar) {
        this.en = en;
        this.ar = ar;
    }
//    public ChargingStandard parseChargingStandard(String value) {
//        return Arrays.stream(ChargingStandard.values())
//                .filter(type -> type.getEn().equalsIgnoreCase(value))
//                .findFirst()
//                .orElseThrow(() -> new InvalidChargingStandardException(value));
//    }


    @JsonCreator
    public static ChargingStandard fromString(String value) {
        for (ChargingStandard m : ChargingStandard.values()) {
            if (m.name().equalsIgnoreCase(value)) {
                return m;
            }
        }
        throw new org.example.mobily.exceptions.InvalidChargingStandardException(value);
    }

}
