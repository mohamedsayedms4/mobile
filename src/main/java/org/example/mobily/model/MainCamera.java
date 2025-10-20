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
public class MainCamera {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String setupType; // Single / Dual...

    private int megapixels; // 48

    private String aperture; // f/1.6

    private String focalLength; // 26mm

    private String sensorSize; // 1/1.56"

    private String pixelSize; // 1.0µm

    private String focusTech; // dual pixel PDAF

    private String stabilization; // sensor-shift OIS

    @Column(columnDefinition = "TEXT")
    private String features; // Dual-LED dual-tone flash ...

    @Column(columnDefinition = "TEXT")
    private String videoSpecs; // 4K@... HDR ...

    @Enumerated(EnumType.STRING)
    private Rating rating;
}
