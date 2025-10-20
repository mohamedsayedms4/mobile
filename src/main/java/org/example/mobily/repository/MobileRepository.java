package org.example.mobily.repository;

import org.example.mobily.dto.MobileListDto;
import org.example.mobily.model.constants.MobileBrand;
import org.example.mobily.model.constants.MobileCategory;
import org.example.mobily.model.MobilePhone;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MobileRepository extends JpaRepository<MobilePhone, Long> {

    // جلب كل الموبايلات بشكل DTO
    @Query("SELECT new org.example.mobily.dto.MobileListDto(m.id, m.brand, m.name, m.rating, m.mainImage) FROM MobilePhone m")
    List<MobileListDto> findAllMobileList();

    // جلب الموبايلات حسب الماركة بشكل DTO مع Pagination
    @Query("SELECT new org.example.mobily.dto.MobileListDto(m.id, m.brand, m.name, m.rating, m.mainImage) " +
            "FROM MobilePhone m WHERE m.brand = :brand")
    Page<MobileListDto> findAllMobileByBrand(MobileBrand brand, Pageable pageable);

    // جلب الموبايلات حسب التصنيف (Category) بشكل DTO مع Pagination
    @Query("SELECT new org.example.mobily.dto.MobileListDto(m.id, m.brand, m.name, m.rating, m.mainImage) " +
            "FROM MobilePhone m WHERE m.category = :category")
    Page<MobileListDto> findAllMobileByCategory(MobileCategory category, Pageable pageable);
    @Query("SELECT new org.example.mobily.dto.MobileListDto(" +
            "m.id, m.brand,m.name, m.rating ,m.mainImage) " +
            "FROM MobilePhone m " +
            "WHERE LOWER(REPLACE(REPLACE(m.name,'أ','ا'),'إ','ا')) LIKE LOWER(CONCAT('%', :keyword, '%')) " +
            "OR LOWER(REPLACE(REPLACE(m.brandAr,'أ','ا'),'إ','ا')) LIKE LOWER(CONCAT('%', :keyword, '%')) " +
            "OR LOWER(REPLACE(REPLACE(m.shortReviewAr,'أ','ا'),'إ','ا')) LIKE LOWER(CONCAT('%', :keyword, '%')) " +
            "OR LOWER(m.name) LIKE LOWER(CONCAT('%', :keyword, '%')) " +
            "OR LOWER(m.brandAr) LIKE LOWER(CONCAT('%', :keyword, '%')) " +
            "OR LOWER(m.shortReviewAr) LIKE LOWER(CONCAT('%', :keyword, '%'))")
    Page<MobileListDto> searchByKeyword(@Param("keyword") String keyword, Pageable pageable);

//    @Query("SELECT new org.example.mobily.dto.MobileListDto(" +
//            "m.id, m.brand, m.name,m.rating, m.mainImage ) " +
//            "FROM MobilePhone m " +
//            "WHERE m.category = :category AND m.id <> :mobileId")
//    Page<MobileListDto> findSimilarByCategory(@Param("category") String category,
//                                              @Param("mobileId") Long mobileId,
//                                              Pageable pageable);

    @Query("SELECT new org.example.mobily.dto.MobileListDto(" +
            "m.id, m.brand, m.name, m.rating, m.mainImage ) " +
            "FROM MobilePhone m " +
            "WHERE m.category = :category AND m.id <> :mobileId")
    Page<MobileListDto> findSimilarByCategory(@Param("category") MobileCategory category,
                                              @Param("mobileId") Long mobileId,
                                              Pageable pageable);


//    @Query("SELECT new org.example.mobily.dto.MobileListDto(" +
//            "m.id, m.brand, m.name,m.rating, m.mainImage ) " +
//            "FROM MobilePhone m " +
//            "WHERE m.brand = :brand AND m.id <> :mobileId")
//    Page<MobileListDto> findSimilarByBrand(@Param("brand") String brand,
//                                           @Param("mobileId") Long mobileId,
//                                           Pageable pageable);

    @Query("SELECT new org.example.mobily.dto.MobileListDto(" +
            "m.id, m.brand, m.name,m.rating, m.mainImage ) " +
            "FROM MobilePhone m " +
            "WHERE m.brand = :brand AND m.id <> :mobileId")
    Page<MobileListDto> findSimilarByBrand(@Param("brand") MobileBrand brand,
                                           @Param("mobileId") Long mobileId,
                                           Pageable pageable);

    @Query("SELECT m.category FROM MobilePhone m WHERE m.id = :mobileId")
    MobileCategory findCategoryByMobileId(@Param("mobileId") Long mobileId);

    @Query("SELECT m.brand FROM MobilePhone m WHERE m.id = :mobileId")
    MobileBrand findBrandByMobileId(@Param("mobileId") Long mobileId);

    @Query("SELECT new org.example.mobily.dto.MobileListDto(m.id, m.brand, m.name, m.rating, m.mainImage) FROM MobilePhone m ORDER BY m.createdAt DESC")
    Page<MobileListDto> findAllByOrderByCreatedAtDesc(Pageable pageable);


}

