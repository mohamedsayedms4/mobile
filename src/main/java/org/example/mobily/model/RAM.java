package org.example.mobily.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.example.mobily.model.constants.RAMType;
import org.example.mobily.model.constants.Rating;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class RAM {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private float size; // الحجم بالجيجابايت أو ميجابايت حسب النظام

    @Enumerated(EnumType.STRING)
    private RAMType type; // نوع الرام

    @Enumerated(EnumType.STRING)
    private Rating rating;
}
