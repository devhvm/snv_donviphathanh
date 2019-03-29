package com.manager.donviphathanh.service.mapper;

import com.manager.donviphathanh.domain.*;
import com.manager.donviphathanh.service.dto.MauPhatHanhDTO;

import org.mapstruct.*;

/**
 * Mapper for the entity MauPhatHanh and its DTO MauPhatHanhDTO.
 */
@Mapper(componentModel = "spring", uses = {})
public interface MauPhatHanhMapper extends EntityMapper<MauPhatHanhDTO, MauPhatHanh> {


    @Mapping(target = "mauphathanhtieuchis", ignore = true)
    MauPhatHanh toEntity(MauPhatHanhDTO mauPhatHanhDTO);

    default MauPhatHanh fromId(Long id) {
        if (id == null) {
            return null;
        }
        MauPhatHanh mauPhatHanh = new MauPhatHanh();
        mauPhatHanh.setId(id);
        return mauPhatHanh;
    }
}
