package org.example.mobily.model;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.example.mobily.model.constants.Rating;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class FrontCamera {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String setupType; // Single / Dual...

    private int megapixels; // 18

    private String aperture; // f/1.9

    private String focalLength; // 20mm

    private String focusTech; // PDAF

    private String extraSensor; // SL 3D

    @Column(columnDefinition = "TEXT")
    private String features; // HDR, Dolby Vision HDR ...

    @Column(columnDefinition = "TEXT")
    private String videoSpecs; // 4K@... , 1080p@...

    @Enumerated(EnumType.STRING)
    private Rating rating;
}
