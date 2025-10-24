package org.example.mobily.service.impl;

import lombok.RequiredArgsConstructor;
import org.example.mobily.model.MobileBrandDetails;
import org.example.mobily.model.constants.MobileBrand;
import org.example.mobily.repository.MobileBrandDetailsRepository;
import org.example.mobily.service.ImageUploadUtil;
import org.example.mobily.service.MobileBrandDetailsService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@Service
@RequiredArgsConstructor
public class MobileBrandDetailsServiceImpl implements MobileBrandDetailsService {

    private final MobileBrandDetailsRepository repository;
    private final ImageUploadUtil imageUploadUtil;

    public List<MobileBrandDetails> getAllBrands() {
        return repository.findAll();
    }

    @Override
    public Page<MobileBrandDetails> getAllBrands(Pageable pageable) {
        return repository.findAll(pageable);
    }

    @Override
    public MobileBrandDetails getByBrand(MobileBrand brand) {
        return repository.findByBrand(brand)
                .orElseThrow(() -> new RuntimeException("No details found for brand: " + brand.name()));
    }

    @Override
    public MobileBrandDetails save(MobileBrandDetails details) {
        return repository.save(details);
    }

    public MobileBrandDetails saveWithImage(MobileBrand brand,  String description, MultipartFile logo) {
        String logoUrl = imageUploadUtil.saveImage(logo);

        MobileBrandDetails details = new MobileBrandDetails();
        details.setBrand(brand);
        details.setDescription(description);
        details.setLogoUrl(logoUrl);

        return repository.save(details);
    }
}
