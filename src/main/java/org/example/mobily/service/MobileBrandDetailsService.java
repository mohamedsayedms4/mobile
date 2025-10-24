package org.example.mobily.service;

import org.example.mobily.model.MobileBrandDetails;
import org.example.mobily.model.constants.MobileBrand;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface MobileBrandDetailsService {
    Page<MobileBrandDetails> getAllBrands(Pageable pageable);
    MobileBrandDetails getByBrand(MobileBrand brand);
    MobileBrandDetails save(MobileBrandDetails details);
    MobileBrandDetails saveWithImage(MobileBrand brand,  String description, MultipartFile logo);
}
