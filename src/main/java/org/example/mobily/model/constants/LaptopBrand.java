package org.example.mobily.model.constants;

import com.fasterxml.jackson.annotation.JsonCreator;

public enum LaptopBrand {
    DELL("ديل"),
    HP("إتش بي"),
    ASUS("آسوس"),
    LENOVO("لينوفو"),
    MSI("إم إس آي"),
    ACER("أيسر"),
    APPLE("أبل"),
    HUAWEI("هواوي"),
    SAMSUNG("سامسونج"),
    MICROSOFT("مايكروسوفت"),
    RAZER("رايزر"),
    LG("إل جي"),
    TOSHIBA("توشيبا"),
    FUJITSU("فوجيتسو"),
    SONY("سوني"),
    GOOGLE("جوجل"),
    XIAOMI("شاومي"),
    AVELL("أفيل"),
    ORIGIN("أوريجن"),
    MEDION("ميديوم"),
    VAIO("فايو");

    private final String arabicName;

    LaptopBrand(String arabicName) {
        this.arabicName = arabicName;
    }

    public String getArabicName() {
        return arabicName;
    }


//    @JsonCreator
//    public static LaptopBrand fromString(String value) {
//        for (LaptopBrand m : LaptopBrand.values()) {
//            if (m.name().equalsIgnoreCase(value)) {
//                return m;
//            }
//        }
//        throw new org.example.mobily.exceptions.L(value);
//    }
}
