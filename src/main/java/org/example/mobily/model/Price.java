package org.example.mobily.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.example.mobily.model.constants.Currency;
import org.example.mobily.model.constants.StorageCapacity;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Price {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String countryEn;

    @Column(columnDefinition = "TEXT")
    private String countryAr;

    private double amount;

    @Enumerated(EnumType.STRING)
    private Currency currency;

    @Enumerated(EnumType.STRING)
    private StorageCapacity storageCapacity;
}