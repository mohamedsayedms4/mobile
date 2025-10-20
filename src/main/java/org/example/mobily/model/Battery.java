package org.example.mobily.model;

import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import jakarta.persistence.*;
import lombok.*;
import org.example.mobily.model.constants.BatteryType;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "battery")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Battery {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.STRING)
    private BatteryType type;

    private Integer capacityMah;

    @Embedded
    @AttributeOverrides({
            @AttributeOverride(name = "method", column = @Column(name = "wired_method")),
            @AttributeOverride(name = "standard", column = @Column(name = "wired_standard")),
            @AttributeOverride(name = "powerWatts", column = @Column(name = "wired_power")),
            @AttributeOverride(name = "speed", column = @Column(name = "wired_speed")),
            @AttributeOverride(name = "regionNote", column = @Column(name = "wired_region_note"))
    })
    private ChargingInfo wiredCharging;

    @Embedded
    @AttributeOverrides({
            @AttributeOverride(name = "method", column = @Column(name = "wireless_method")),
            @AttributeOverride(name = "standard", column = @Column(name = "wireless_standard")),
            @AttributeOverride(name = "powerWatts", column = @Column(name = "wireless_power")),
            @AttributeOverride(name = "speed", column = @Column(name = "wireless_speed")),
            @AttributeOverride(name = "regionNote", column = @Column(name = "wireless_region_note"))
    })
    private ChargingInfo wirelessCharging;

    @Embedded
    @AttributeOverrides({
            @AttributeOverride(name = "method", column = @Column(name = "reverse_method")),
            @AttributeOverride(name = "standard", column = @Column(name = "reverse_standard")),
            @AttributeOverride(name = "powerWatts", column = @Column(name = "reverse_power")),
            @AttributeOverride(name = "speed", column = @Column(name = "reverse_speed")),
            @AttributeOverride(name = "regionNote", column = @Column(name = "reverse_region_note"))
    })
    private ChargingInfo reverseCharging;
}
