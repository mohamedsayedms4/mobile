package org.example.mobily.model;



import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.example.mobily.model.constants.OperatingSystemType;
import org.example.mobily.model.constants.Rating;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class OperatingSystem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    // اسم النظام (مثال: Android, iOS)
    private String nameEn;
    @Column(columnDefinition = "TEXT")
    private String nameAr;

    // نسخة النظام (مثال: 14, 17, 24H2)
    private String versionEn;
    @Column(columnDefinition = "TEXT")
    private String versionAr;

    // واجهة المستخدم (MIUI, One UI, etc)
    private String uiNameEn;
    @Column(columnDefinition = "TEXT")
    private String uiNameAr;

    private String uiVersion; // مثال: 15.0, 6.1

    // نوع النظام (Android, iOS, Harmony, ...)
    @Enumerated(EnumType.STRING)
    private OperatingSystemType type;

    // الشركة المصنعة
    private String manufacturerEn;
    @Column(columnDefinition = "TEXT")
    private String manufacturerAr;

    @Enumerated(EnumType.STRING)
    private Rating rating;
}
