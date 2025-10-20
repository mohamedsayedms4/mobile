package org.example.mobily.dto;


import com.fasterxml.jackson.annotation.JsonFormat;
import org.example.mobily.model.constants.*;
import org.example.mobily.model.*;

import java.time.LocalDateTime;
import java.util.List;

public record MobilePhoneDTO(
        Long id,
        MobileBrand brand,
        String brandAr,
        String name,
        String shortReviewEn,
        String shortReviewAr,
        List<String> detailedSpecsEn,
        List<String> detailedSpecsAr,
        List<String> screenDetailsEN,
        List<String> screenDetailsAR,
        List<String> cameraDetailsEN,
        List<String> cameraDetailsAR,
        Processor processor,
        Screen screen,
        Battery battery,
        OperatingSystem os,
        MainCamera rearCamera,
        FrontCamera frontCamera,
        List<Price> prices,
        List<RAM> rams,
        MobileCategory category,
        List<StorageCapacity> storageCapacity,
        List<ManufacturingMaterial> manufacturingMaterial,
        List<String> advantageEn,
        List<String> advantageAR,
        List<String> disadvantageEN,
        List<String> disadvantageAR,
        String colorAr,
        String colorEN,
        List<String> designEN,
        List<String> designAR,
        List<String> performanceEN,
        List<String> performanceAR,
        List<String> boxIncludedEN,
        List<String> boxIncludedAR,
        Integer yearOfReleased,
        List<String> linksForBuy,
        Rating rating,
        Integer cameraImage,
        Integer advantageImage,
        Integer disadvantageImage,
        Integer boxIncludedImage
) {

}