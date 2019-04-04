package com.manager.donviphathanh.service.mapper;

import com.manager.donviphathanh.domain.*;
import com.manager.donviphathanh.service.dto.KyCongBoDTO;

import org.mapstruct.*;

/**
 * Mapper for the entity KyCongBo and its DTO KyCongBoDTO.
 */
@Mapper(componentModel = "spring", uses = {})
public interface KyCongBoMapper extends EntityMapper<KyCongBoDTO, KyCongBo> {


    @Mapping(target = "tieuchis", ignore = true)
    KyCongBo toEntity(KyCongBoDTO kyCongBoDTO);

    default KyCongBo fromId(Long id) {
        if (id == null) {
            return null;
        }
        KyCongBo kyCongBo = new KyCongBo();
        kyCongBo.setId(id);
        return kyCongBo;
    }
}
