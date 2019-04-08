package com.manager.donviphathanh.service.mapper;

import com.manager.donviphathanh.domain.*;
import com.manager.donviphathanh.service.dto.PhamViDTO;

import org.mapstruct.*;

/**
 * Mapper for the entity PhamVi and its DTO PhamViDTO.
 */
@Mapper(componentModel = "spring", uses = {})
public interface PhamViMapper extends EntityMapper<PhamViDTO, PhamVi> {


    @Mapping(target = "mauphathanh", ignore = true)
    PhamVi toEntity(PhamViDTO phamViDTO);

    default PhamVi fromId(Long id) {
        if (id == null) {
            return null;
        }
        PhamVi phamVi = new PhamVi();
        phamVi.setId(id);
        return phamVi;
    }
}
