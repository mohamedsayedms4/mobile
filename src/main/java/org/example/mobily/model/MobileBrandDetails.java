package org.example.mobily.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.example.mobily.model.constants.MobileBrand;

@Entity
@Table(name = "mobile_brand_details")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class MobileBrandDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false, unique = true)
    private MobileBrand brand;

    @Column(length = 255)
    private String logoUrl;


    @Column(columnDefinition = "TEXT")
    private String description;
}