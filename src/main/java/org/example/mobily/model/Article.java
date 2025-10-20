package org.example.mobily.model;


import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Article {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(columnDefinition = "TEXT")

    private String title;

    private String bannerUrl;
    @Column(columnDefinition = "TEXT")

    private String description;

    @ElementCollection
    private List<String> photo;

    @ElementCollection
    @Column(columnDefinition = "TEXT")

    private List<String> specificationsSection ;

    @ElementCollection
    @Column(columnDefinition = "TEXT")

    private List<String> priceSection;


    @Column(updatable = false)
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    protected LocalDateTime createdAt;

    @PrePersist
    protected void onCreate() {
        createdAt = LocalDateTime.now();
    }
}
