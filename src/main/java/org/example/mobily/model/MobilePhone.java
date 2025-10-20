package org.example.mobily.model;


import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import lombok.*;
import org.example.mobily.model.constants.*;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Entity
@Table(name = "mobiles")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class MobilePhone {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.STRING)
    private MobileBrand brand;

    @Column(columnDefinition = "TEXT")
    private String brandAr;

    private String name;

    @Column(columnDefinition = "TEXT")
    private String shortReviewEn;

    @Column(columnDefinition = "TEXT")
    private String shortReviewAr;

    @ElementCollection
    @OrderColumn
    @Column(columnDefinition = "TEXT")
    private List<String> detailedSpecsEn;

    @ElementCollection
    @OrderColumn
    @Column(columnDefinition = "TEXT")
    private List<String> detailedSpecsAr;


    @ElementCollection
    @OrderColumn
    private List<String> screenDetailsEN;


    @ElementCollection
    @OrderColumn
    @Column(columnDefinition = "TEXT")
    private List<String> screenDetailsAR;

    @ElementCollection
    @OrderColumn
    private List<String> cameraDetailsEN;


    @ElementCollection
    @OrderColumn
    @Column(columnDefinition = "TEXT")
    private List<String> cameraDetailsAR;
    // Relations
    @OneToOne(cascade = CascadeType.ALL)
    private Processor processor;

    @OneToOne(cascade = CascadeType.ALL)
    private Screen screen;

    @OneToOne(cascade = CascadeType.ALL)
    private Battery battery;

    @OneToOne(cascade = CascadeType.ALL)
    private OperatingSystem os;

    @OneToOne(cascade = CascadeType.ALL)
    private MainCamera rearCamera;

    @OneToOne(cascade = CascadeType.ALL)
    private FrontCamera frontCamera;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "mobile_id")
    @OrderColumn
    private List<Price> prices;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "mobile_id")
    @OrderColumn
    private List<RAM> rams;

    @Enumerated(EnumType.STRING)
    private MobileCategory category;

    @ElementCollection
    @OrderColumn
    private List<StorageCapacity> storageCapacity;

    @ElementCollection
    @Enumerated(EnumType.STRING)
    @OrderColumn
    private List<ManufacturingMaterial> manufacturingMaterial;

    @ElementCollection
    @OrderColumn
    private List<String> images;


    @ElementCollection
    @OrderColumn
    private List<String> advantageEn;


    @ElementCollection
    @OrderColumn
    @Column(columnDefinition = "TEXT")
    private List<String> advantageAR;

    @ElementCollection
    @OrderColumn
    private List<String> disadvantageEN;



    @ElementCollection
    @OrderColumn
    @Column(columnDefinition = "TEXT")
    private List<String> disadvantageAR;

    @Column(columnDefinition = "TEXT")
    private String colorAr;

    private String colorEN;
    @ElementCollection
    @OrderColumn
    private List<String> designEN;
    @ElementCollection
    @OrderColumn
    @Column(columnDefinition = "TEXT")
    private List<String> designAR;

    @ElementCollection
    @OrderColumn
    private List<String> performanceEN;
    @ElementCollection
    @OrderColumn
    @Column(columnDefinition = "TEXT")
    private List<String> performanceAR;


    @ElementCollection
    @OrderColumn
    private List<String> boxIncludedEN;
    @ElementCollection
    @OrderColumn
    @Column(columnDefinition = "TEXT")
    private List<String> boxIncludedAR;


    private Integer yearOfReleased; // مثال: 2023, 2024

    @Column(updatable = false)
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime createdAt ;

    @ElementCollection
    @OrderColumn
    private List<String> linksForBuy;

    @Enumerated(EnumType.STRING)
    private Rating rating;

    @Column(nullable = false)
    private String mainImage;
    @Column(nullable = true)
    private Integer  cameraImage;
    @Column(nullable = true)
    private Integer  advantageImage;
    @Column(nullable = true)
    private Integer  disadvantageImage;
    @Column(nullable = true)
    private Integer  boxIncludedImage;

    // ====== Lifecycle hooks ======
    @PrePersist
    @PreUpdate
    private void preSave() {
        setBrandArValue();
        createdAt = LocalDateTime.now();
//        calculateAverageRating();
    }

    private void setBrandArValue() {
        if (brand != null) {
            this.brandAr = brand.getArabicName();
        }
    }

//    private void calculateAverageRating() {
//        int sum = 0;
//        int count = 0;
//
//        List<Rating> componentRatings = Stream.of(processor, screen, battery, os, rearCamera, frontCamera)
//                .filter(Objects::nonNull)
//                .map(c -> {
//                    try {
//                        return (Rating) c.getClass().getMethod("getRating").invoke(c);
//                    } catch (Exception e) {
//                        return null;
//                    }
//                })
//                .filter(Objects::nonNull)
//                .collect(Collectors.toList());
//
//        for (Rating r : componentRatings) {
//            sum += r.getStars();
//            count++;
//        }
//
//        if (rams != null) {
//            for (RAM ram : rams) {
//                if (ram.getRating() != null) {
//                    sum += ram.getRating().getStars();
//                    count++;
//                }
//            }
//        }
//
//        if (count > 0) {
//            double avg = (double) sum / count;
//            this.rating = Rating.fromValue(avg);
//        }
//    }

    // ====== Helper ======
//    public String getMainImage() {
//        return (images != null && !images.isEmpty()) ? images.get(0) : null;
//    }
}
