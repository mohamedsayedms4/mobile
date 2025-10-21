package org.example.mobily.service.impl;

import lombok.RequiredArgsConstructor;
import org.example.mobily.dto.MobileListDto;
import org.example.mobily.dto.MobilePhoneDTO;
import org.example.mobily.mapper.MobileMapper;
import org.example.mobily.model.MobilePhone;
import org.example.mobily.model.constants.MobileBrand;
import org.example.mobily.model.constants.MobileCategory;
import org.example.mobily.repository.MobileRepository;
import org.example.mobily.service.ImageUploadUtil;
import org.example.mobily.service.MobileService;
import org.springframework.cache.CacheManager;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

import org.springframework.cache.annotation.Cacheable;
import org.springframework.cache.annotation.CachePut;
import org.springframework.web.multipart.MultipartFile;

@Service
@RequiredArgsConstructor
public class MobileServiceImpl implements MobileService {

    private final MobileRepository mobileRepository;
    private final MobileMapper mobileMapper;
    private final ImageUploadUtil imageUploadUtil;
    private final CacheManager cacheManager; // ✅ لتحديث الكاش يدوياً

    @Override
    @CachePut(value = "mobiles", key = "#result.id")
    public MobilePhone addMobilePhone(MobilePhoneDTO mobilePhoneDTO, MultipartFile mainImage, MultipartFile[] images) {

        MobilePhone mobile = mobileMapper.toEntity(mobilePhoneDTO);

        String mainImageUrl = imageUploadUtil.saveImage(mainImage);
        mobile.setMainImage(mainImageUrl);

        List<String> imageUrls = (images != null && images.length > 0)
                ? imageUploadUtil.saveImages(images)
                : List.of();

        mobile.setImages(imageUrls);

        MobilePhone saved = mobileRepository.save(mobile);

        // ✅ مسح الكاش بالكامل بعد إضافة هاتف جديد
        if (cacheManager.getCache("mobiles") != null) {
            cacheManager.getCache("mobiles").clear();
        }

        return saved;
    }

    @Override
    @CachePut(value = "mobiles", key = "'all'")
    public List<MobilePhone> addMobilePhoneList(List<MobilePhone> mobilePhoneList) {
        return mobileRepository.saveAll(mobilePhoneList);
    }

    @Override
    @Cacheable(value = "mobiles", key = "'page_' + #page + '_size_' + #size")
    public Page<MobileListDto> getMobilePhoneList(int page, int size) {
        Pageable pageable = PageRequest.of(page, size);
        return mobileRepository.findAllMobileList(pageable);
    }

    @Override
    @Cacheable(value = "mobiles", key = "'allall'")
    public List<MobilePhone> getMobilePhoneListALl() {
        return mobileRepository.findAll();
    }

    @Override
    @Cacheable(value = "mobiles", key = "#mobilePhoneId")
    public MobilePhone getMobilePhoneById(Long mobilePhoneId) {
        return mobileRepository.findById(mobilePhoneId).orElse(null);
    }

    @Override
    public Page<MobileListDto> getMobileByBrand(MobileBrand brand, int page, int size) {
        Pageable pageable = PageRequest.of(page, size);
        return mobileRepository.findAllMobileByBrand(brand,pageable);
    }

    @Override
    public Page<MobileListDto> getMobileByCategory(MobileCategory category, int page, int size) {
        Pageable pageable = PageRequest.of(page, size);
        return mobileRepository.findAllMobileByCategory(category,pageable);
    }

    @Override
    public Page<MobileListDto> searchByNameOrBrand(String keyword, int page, int size) {
        Pageable pageable = PageRequest.of(page, size);
        return mobileRepository.searchByKeyword(keyword,pageable);
    }

    @Override
    public Page<MobileListDto> getSimilarMobilesByCategory(Long mobileId, int page, int size) {
        MobileCategory categoryEnum = mobileRepository.findCategoryByMobileId(mobileId);
        return mobileRepository.findSimilarByCategory(categoryEnum, mobileId, PageRequest.of(page, size));
    }

    @Override
    public Page<MobileListDto> getSimilarMobilesByBrand(Long mobileId, int page, int size) {
        MobileBrand brandEnum = mobileRepository.findBrandByMobileId(mobileId);
        return mobileRepository.findSimilarByBrand(brandEnum, mobileId, PageRequest.of(page, size));
    }

    @Override
    public void deleteMobile(Long id) {
        // TODO: delete with cache evict if needed
    }

    public Page<MobileListDto> getLatestMobiles(int page, int size) {
        Pageable pageable = PageRequest.of(page, size);
        return mobileRepository.findAllByOrderByCreatedAtDesc(pageable);
    }
}
