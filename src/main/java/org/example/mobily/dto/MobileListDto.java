package org.example.mobily.dto;

import org.example.mobily.model.constants.MobileBrand;
import org.example.mobily.model.constants.Rating;

public record MobileListDto(
        Long id,
        MobileBrand brand,
        String name,
        Rating rating,
        String mainImage // رابط الصورة المختارة
) {}
