package org.example.mobily.service;

import org.example.mobily.dto.MobileListDto;
import org.example.mobily.dto.MobilePhoneDTO;
import org.example.mobily.model.MobilePhone;
import org.example.mobily.model.constants.MobileBrand;
import org.example.mobily.model.constants.MobileCategory;
import org.springframework.data.domain.Page;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface MobileService {

    MobilePhone addMobilePhone(MobilePhoneDTO mobilePhoneDTO, MultipartFile mainImage, MultipartFile[] images);

    List<MobilePhone> addMobilePhoneList(List<MobilePhone> mobilePhoneList);
     Page<MobileListDto> getMobilePhoneList(int page, int size);
    List<MobilePhone> getMobilePhoneListALl();

    MobilePhone getMobilePhoneById(Long mobilePhoneId);

    Page<MobileListDto> getMobileByBrand(MobileBrand brand, int page, int size);

    Page<MobileListDto> getMobileByCategory(MobileCategory category , int page, int size);

    Page<MobileListDto> searchByNameOrBrand(String keyword , int page, int size);

    Page<MobileListDto> getSimilarMobilesByCategory(Long mobileId, int page, int size);

    Page<MobileListDto> getSimilarMobilesByBrand(Long mobileId, int page, int size);

    void deleteMobile(Long id);


    Page<MobileListDto> getLatestMobiles(int page, int size);




}
