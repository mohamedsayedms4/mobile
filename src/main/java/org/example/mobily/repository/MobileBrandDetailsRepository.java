package org.example.mobily.repository;

import org.example.mobily.model.MobileBrandDetails;
import org.example.mobily.model.constants.MobileBrand;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface MobileBrandDetailsRepository extends JpaRepository<MobileBrandDetails, Long> {
    Optional<MobileBrandDetails> findByBrand(MobileBrand brand);
}
