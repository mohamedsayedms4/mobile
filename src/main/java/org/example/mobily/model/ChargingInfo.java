package org.example.mobily.model;

import jakarta.persistence.*;
import lombok.*;
import org.example.mobily.model.constants.ChargingMethod;
import org.example.mobily.model.constants.ChargingStandard;

import jakarta.persistence.Embeddable;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.*;

@Embeddable
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ChargingInfo {

    @Enumerated(EnumType.STRING)
    private ChargingMethod method;

    @Enumerated(EnumType.STRING)
    private ChargingStandard standard;

    private Integer powerWatts;   // مثال: 20, 4.5
    private String speed;         // مثال: 50% in 30 min
    private String regionNote;    // مثال: (15W - China)
}
