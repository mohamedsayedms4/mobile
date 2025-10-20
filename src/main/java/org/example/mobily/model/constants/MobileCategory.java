package org.example.mobily.model.constants;

import com.fasterxml.jackson.annotation.JsonCreator;
import org.example.mobily.exceptions.InvalidMobileCategoryException;

import java.util.Arrays;

public enum MobileCategory {
    FLAGSHIP("فلاج شيب"),            // أعلى فئة
    MID_RANGE("فئة متوسطة"),          // سعر متوسط
    BUDGET("اقتصادي"),                // منخفض السعر
    GAMING("مخصص للألعاب"),           // للألعاب
    CAMERA("مخصص للتصوير"),           // للكاميرات القوية
    FOLDABLE("قابل للطي"),            // Foldable
    CLASSIC("كلاسيك"),                 // أجهزة عادية/بسيطة
    RUGGED("مقاوم للصدمات"),          // Rugged / قوي التحمل
    BUSINESS("مخصص لرجال الأعمال"),   // أجهزة بروفشنال/عمل
    ULTRA("ألترا"),                   // إصدارات ألترا
    LUXURY("فاخر"),                   // إصدارات فاخرة
    ENTRY_LEVEL("مبتدئ"),             // Entry-level
    PHABLET("فابلت"),                 // Phablet (هاتف + تابلت)
    MINI("ميني"),                     // الإصدارات الصغيرة
    PRO("برو"),                       // Pro Editions
    PLUS("بلاس");                     // Plus Editions

    private final String arabicName;

    MobileCategory(String arabicName) {
        this.arabicName = arabicName;
    }

    public String getArabicName() {
        return arabicName;
    }

    public MobileCategory parseMobileCategory(String value) {
        return Arrays.stream(MobileCategory.values())
                .filter(category -> category.getArabicName().equalsIgnoreCase(value))
                .findFirst()
                .orElseThrow(() -> new InvalidMobileCategoryException(value));
    }


    @JsonCreator
    public static MobileCategory fromString(String value) {
        for (MobileCategory m : MobileCategory.values()) {
            if (m.name().equalsIgnoreCase(value)) {
                return m;
            }
        }
        throw new org.example.mobily.exceptions.InvalidMobileCategoryException(value);
    }

}
