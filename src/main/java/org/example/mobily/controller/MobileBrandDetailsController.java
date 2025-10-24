package org.example.mobily.controller;

import lombok.RequiredArgsConstructor;
import org.example.mobily.model.MobileBrandDetails;
import org.example.mobily.model.constants.MobileBrand;
import org.example.mobily.service.MobileBrandDetailsService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/api/v1/brands")
@RequiredArgsConstructor
public class MobileBrandDetailsController {

    private final MobileBrandDetailsService service;

    @GetMapping
    public Page<MobileBrandDetails> getAllBrands(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size) {
        return service.getAllBrands(PageRequest.of(page, size));
    }

    @GetMapping("/{brand}")
    public MobileBrandDetails getByBrand(@PathVariable String brand) {
        MobileBrand mobileBrand = MobileBrand.valueOf(brand.toUpperCase());
        return service.getByBrand(mobileBrand);
    }

    // ✅ endpoint جديد لرفع الصورة وتخزين البيانات
    @PostMapping(consumes = {"multipart/form-data"})
    public MobileBrandDetails addBrandDetails(
            @RequestParam("brand") String brand,
            @RequestParam("description") String description,
            @RequestParam("logo") MultipartFile logo) {

        MobileBrand mobileBrand = MobileBrand.valueOf(brand.toUpperCase());
        return service.saveWithImage(mobileBrand,  description, logo);
    }
}
