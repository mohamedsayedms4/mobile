package org.example.mobily.controller;

import lombok.RequiredArgsConstructor;
import org.example.mobily.dto.MobileListDto;
import org.example.mobily.dto.MobilePhoneDTO;
import org.example.mobily.model.MobilePhone;
import org.example.mobily.model.constants.MobileBrand;
import org.example.mobily.model.constants.MobileCategory;
import org.example.mobily.service.ImageUploadUtil;
import org.example.mobily.service.MobileService;
import org.springframework.data.domain.Page;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@RestController
@RequestMapping("/api/v1/mobiles")
@RequiredArgsConstructor
@CrossOrigin("*")
public class MobileController {

    private final MobileService mobileService;
    private final ImageUploadUtil imageUploadUtil;

    @PostMapping(consumes = {"multipart/form-data"})
    public ResponseEntity<MobilePhone> addMobile(
            @RequestPart("mobilePhone") MobilePhoneDTO mobilePhoneDTO,
            @RequestPart("mainImage") MultipartFile mainImage,
            @RequestPart(value = "images",required = false) MultipartFile[] images
    ) {
        MobilePhone savedMobile = mobileService.addMobilePhone(mobilePhoneDTO, mainImage, images);
        return ResponseEntity.ok(savedMobile);
    }
    @PostMapping("/all")
    public ResponseEntity<List<MobilePhone>> addListMobile(@RequestBody List<MobilePhone> s ) {
        List<MobilePhone> savedMobile = mobileService.addMobilePhoneList(s);
        return ResponseEntity.ok(savedMobile);
    }

    @GetMapping
    public ResponseEntity<Page<MobileListDto>> getAllMobile(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size) {

        return ResponseEntity.ok(mobileService.getMobilePhoneList(page, size));
    }

    @GetMapping("/all1")
    public ResponseEntity<List<MobilePhone>> getAllMobileAll() {
        return ResponseEntity.ok(mobileService.getMobilePhoneListALl());
    }
    @GetMapping("/{id}")
    public ResponseEntity<MobilePhone> getMobileById(@PathVariable Long id) {
        return ResponseEntity.ok(mobileService.getMobilePhoneById(id));
    }

    @GetMapping("/brand/{brand}")
    public Page<MobileListDto> getMobilesByBrand(
            @PathVariable MobileBrand brand,
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size
    ) {
        return mobileService.getMobileByBrand(brand, page, size);
    }

    @GetMapping("/category/{category}")
    public Page<MobileListDto> getMobilesByCategory(
            @PathVariable MobileCategory category,
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size
    ) {
        return mobileService.getMobileByCategory(category, page, size);
    }

    @GetMapping("/search")
    public Page<MobileListDto> searchMobiles(
            @RequestParam("keyword") String keyword,
            @RequestParam(value = "page", defaultValue = "0") int page,
            @RequestParam(value = "size", defaultValue = "10") int size
    ) {
        return mobileService.searchByNameOrBrand(keyword, page, size);
    }

    @GetMapping("/{mobileId}/similar/category")
    public Page<MobileListDto> getSimilarByCategory(
            @PathVariable Long mobileId,
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size
    ) {
        return mobileService.getSimilarMobilesByCategory(mobileId, page, size);
    }

    @GetMapping("/{mobileId}/similar/brand")
    public Page<MobileListDto> getSimilarByBrand(
            @PathVariable Long mobileId,
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size
    ) {
        return mobileService.getSimilarMobilesByBrand(mobileId, page, size);
    }

    @DeleteMapping("/{id}")
    public void deleteMobile(@PathVariable("id") Long id) {
        mobileService.deleteMobile(id);
    }

    @GetMapping("/latest")
    public Page<MobileListDto> getLatestMobiles(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size
    ) {
        return mobileService.getLatestMobiles(page, size);
    }

}
