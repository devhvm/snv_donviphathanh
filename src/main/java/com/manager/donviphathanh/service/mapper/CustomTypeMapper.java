package com.manager.donviphathanh.service.mapper;

import com.manager.donviphathanh.domain.CustomType;
import com.manager.donviphathanh.service.dto.CustomTypeDTO;
import org.mapstruct.Mapper;

/**
 * Mapper for the entity MauPhatHanh and its DTO MauPhatHanhDTO.
 */
@Mapper(componentModel = "spring", uses = {})
public interface CustomTypeMapper extends EntityMapper<CustomTypeDTO, CustomType> {

    default CustomType fromId(String id) {
        if (id == null) {
            return null;
        }
        CustomType customType = new CustomType();
        return customType;
    }
}
