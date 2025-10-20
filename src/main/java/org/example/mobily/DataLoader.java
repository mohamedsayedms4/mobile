//package org.example.mobily;
//
//import org.example.mobily.model.Battery;
//import org.example.mobily.model.ChargingInfo;
//import org.example.mobily.model.constants.BatteryType;
//import org.example.mobily.model.constants.ChargingMethod;
//import org.example.mobily.model.constants.ChargingStandard;
//import org.example.mobily.repository.BatteryRepository;
//import org.springframework.boot.CommandLineRunner;
//import org.springframework.stereotype.Component;
//import lombok.RequiredArgsConstructor;
//
//@Component
//@RequiredArgsConstructor
//public class DataLoader implements CommandLineRunner {
//
//    private final BatteryRepository batteryRepository;
//
//    @Override
//    public void run(String... args) {
//
//
//
//        // ✅ البطارية نفسها
//        Battery battery = Battery.builder()
//                .type(BatteryType.LI_ION)
//                .capacityMah(3149)
//                .wiredCharging(
//                        ChargingInfo.builder()
//                                .method(ChargingMethod.WIRED)
//                                .standard(ChargingStandard.PD)
//                                .powerWatts(20)
//                                .speed("50% in 30 min")
//                                .build()
//                )
//                .wirelessCharging(
//                        ChargingInfo.builder()
//                                .method(ChargingMethod.WIRELESS)
//                                .standard(ChargingStandard.MAGSAFE)
//                                .powerWatts(20)
//                                .speed("50% in 30 min")
//                                .regionNote("(15W - China)")
//                                .build()
//                )
//                .reverseCharging(
//                        ChargingInfo.builder()
//                                .method(ChargingMethod.REVERSE)
//                                .standard(ChargingStandard.OTHER)
//                                .powerWatts(4)
//                                .regionNote("Wired")
//                                .build()
//                )
//                .build();
//
//        batteryRepository.save(battery);
//
//
//        System.out.println("✅ Battery inserted successfully!");
//    }
//}
