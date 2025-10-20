package org.example.mobily.mapper;

import org.example.mobily.dto.MobilePhoneDTO;
import org.example.mobily.dto.MobileListDto;
import org.example.mobily.model.MobilePhone;
import org.mapstruct.*;

import java.util.List;

@Mapper(componentModel = "spring")
public interface MobileMapper {

    // ====== MobileListDto Mappings ======
    MobileListDto toMobileListDto(MobilePhone mobile);

    List<MobileListDto> toMobileListDtos(List<MobilePhone> mobiles);

    // ====== MobilePhoneDTO Mappings ======
    MobilePhoneDTO toMobilePhoneDTO(MobilePhone mobile);

    List<MobilePhoneDTO> toMobilePhoneDTOs(List<MobilePhone> mobiles);

    MobilePhone toEntity(MobilePhoneDTO dto);

    void updateEntityFromDTO(MobilePhoneDTO dto, @MappingTarget MobilePhone mobile);
}