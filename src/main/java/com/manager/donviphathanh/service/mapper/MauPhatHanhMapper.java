package com.manager.donviphathanh.service.mapper;

import com.manager.donviphathanh.domain.MauPhatHanh;
import com.manager.donviphathanh.service.dto.MauPhatHanhDTO;
import org.mapstruct.Mapper;

/**
 * Mapper for the entity MauPhatHanh and its DTO MauPhatHanhDTO.
 */
@Mapper(componentModel = "spring", uses = {})
public interface MauPhatHanhMapper extends EntityMapper<MauPhatHanhDTO, MauPhatHanh> {


    default MauPhatHanh fromId(String id) {
        if (id == null) {
            return null;
        }
        MauPhatHanh mauPhatHanh = new MauPhatHanh();
        mauPhatHanh.setId(id);
        return mauPhatHanh;
    }
}
