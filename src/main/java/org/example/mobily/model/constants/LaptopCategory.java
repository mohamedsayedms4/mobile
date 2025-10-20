package org.example.mobily.model.constants;


public enum LaptopCategory {
    ULTRABOOK("ألترا بوك"),           // خفيف وسهل الحمل
    GAMING("مخصص للألعاب"),           // للألعاب الثقيلة
    BUSINESS("لرجال الأعمال"),        // أجهزة برو/عمل
    STUDENT("للطلبة"),                // مناسب للدراسة
    BUDGET("اقتصادي"),                // منخفض السعر
    CREATIVE("للمصممين والمونتاج"),   // تصميم/مونتاج/جرافيكس
    WORKSTATION("محطات عمل"),        // أداء قوي للتطبيقات الهندسية
    CONVERTIBLE("قابل للتحويل"),       // 2 في 1 قابل للطي
    MINI("ميني"),                     // صغير الحجم/خفيف
    PRO("برو"),                        // إصدار Pro
    PLUS("بلاس");                      // إصدار Plus

    private final String arabicName;

    LaptopCategory(String arabicName) {
        this.arabicName = arabicName;
    }

    public String getArabicName() {
        return arabicName;
    }
}
