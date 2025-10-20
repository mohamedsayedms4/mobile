package org.example.mobily.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.example.mobily.model.constants.Rating;
import org.example.mobily.model.constants.ScreenProtection;
import org.example.mobily.model.constants.ScreenType;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Screen {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private double size; // بالإنش

    private String resolutionEn;
    @Column(columnDefinition = "TEXT")
    private String resolutionAr;

    @Enumerated(EnumType.STRING)
    private ScreenType type; // نوع الشاشة

    private int refreshRate; // Hz

    @Enumerated(EnumType.STRING)
    private ScreenProtection protection; // نوع الحماية

    @Enumerated(EnumType.STRING)
    private Rating rating;
}
