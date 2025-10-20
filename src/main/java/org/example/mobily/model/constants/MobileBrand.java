package org.example.mobily.model.constants;

import com.fasterxml.jackson.annotation.JsonCreator;
import org.example.mobily.exceptions.InvalidMobileBrandException;

import java.util.Arrays;

public enum MobileBrand {
    SAMSUNG("سامسونج"),
    APPLE("أبل"),
    HUAWEI("هواوي"),
    XIAOMI("شاومي"),
    OPPO("أوبو"),
    VIVO("فيفو"),
    REALME("ريلمي"),
    ONEPLUS("ون بلس"),
    GOOGLE("جوجل"),
    HONOR("هونر"),

    NOKIA("نوكيا"),
    SONY("سوني"),
    LENOVO("لينوفو"),
    MOTOROLA("موتورولا"),
    ASUS("آسوس"),
    LG("إل جي"),
    HTC("إتش تي سي"),
    ZTE("زد تي إي"),
    TECNO("تكنو"),
    INFINIX("إنفينيكس"),

    MICROSOFT("مايكروسوفت"),
    ALCATEL("ألكاتيل"),
    MEIZU("ميزو"),
    NOTHING("ناثينج"),
    UMIDIGI("يو مي ديجي"),
    COOLPAD("كول باد"),
    OSCAL("أوسكال"),
    SHARP("شارب"),
    MICROMAX("مايكروماكس"),
    ULEFONE("يولي فون"),
    DOOGEE("دوجي"),
    BLACKVIEW("بلاك فيو"),
    CUBOT("كيوبوت"),
    OUKITEL("أوكتيل"),
    ITEL("آيتل"),
    TCL("تي سي إل");


    private final String arabicName;

    MobileBrand(String arabicName) {
        this.arabicName = arabicName;
    }

    public String getArabicName() {
        return arabicName;
    }

    @JsonCreator
    public MobileBrand parseMobileBrand(String value) {
        return Arrays.stream(MobileBrand.values())
                .filter(brand -> brand.getArabicName().equalsIgnoreCase(value))
                .findFirst()
                .orElseThrow(() -> new InvalidMobileBrandException(value));
    }

    @JsonCreator
    public static MobileBrand fromString(String value) {
        for (MobileBrand m : MobileBrand.values()) {
            if (m.name().equalsIgnoreCase(value)) {
                return m;
            }
        }
        throw new org.example.mobily.exceptions.InvalidMobileBrandException(value);
    }





}
