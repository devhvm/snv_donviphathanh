package com.manager.donviphathanh.service.mapper;

import com.manager.donviphathanh.domain.*;
import com.manager.donviphathanh.service.dto.TieuChiDTO;

import org.mapstruct.*;

/**
 * Mapper for the entity TieuChi and its DTO TieuChiDTO.
 */
@Mapper(componentModel = "spring", uses = {KyCongBoMapper.class})
public interface TieuChiMapper extends EntityMapper<TieuChiDTO, TieuChi> {

    @Mapping(source = "kycongbo.id", target = "kycongboId")
    TieuChiDTO toDto(TieuChi tieuChi);

    @Mapping(target = "tieuchibaocaos", ignore = true)
    @Mapping(target = "mauphathanhtieuchis", ignore = true)
    @Mapping(source = "kycongboId", target = "kycongbo")
    TieuChi toEntity(TieuChiDTO tieuChiDTO);

    default TieuChi fromId(Long id) {
        if (id == null) {
            return null;
        }
        TieuChi tieuChi = new TieuChi();
        tieuChi.setId(id);
        return tieuChi;
    }
}
