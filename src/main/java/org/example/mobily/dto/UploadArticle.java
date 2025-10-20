package org.example.mobily.dto;

import java.util.List;

public record UploadArticle(
        String title,
        String description,
        List<String> specificationsSection,
        List<String> priceSection
) {
}
