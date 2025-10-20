package org.example.mobily.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.example.mobily.model.constants.ArchitectureType;
import org.example.mobily.model.constants.GPUBrand;
import org.example.mobily.model.constants.ProcessorBrand;
import org.example.mobily.model.constants.Rating;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Processor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    // اسم المعالج
    private String nameEn;
    @Column(columnDefinition = "TEXT")
    private String nameAr;

    // العلامة التجارية
    @Enumerated(EnumType.STRING)
    private ProcessorBrand brand;

    // الشركة المصنعة
    private String manufacturerEn;
    @Column(columnDefinition = "TEXT")
    private String manufacturerAr;

    // عدد الأنوية
    private int cores;

    // تردد الساعة (GHz)
    private double clockSpeed;

    // المعمارية
    @Enumerated(EnumType.STRING)
    private ArchitectureType architecture;

    // حجم التصنيع (nm)
    private int processSize;

    // وحدة معالجة الرسوميات
    @Enumerated(EnumType.STRING)
    private GPUBrand gpu;

    @Enumerated(EnumType.STRING)
    private Rating rating;
}
