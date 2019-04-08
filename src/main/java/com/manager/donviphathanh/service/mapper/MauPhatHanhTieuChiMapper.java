package com.manager.donviphathanh.service.mapper;

import com.manager.donviphathanh.domain.*;
import com.manager.donviphathanh.service.dto.MauPhatHanhTieuChiDTO;

import org.mapstruct.*;

/**
 * Mapper for the entity MauPhatHanhTieuChi and its DTO MauPhatHanhTieuChiDTO.
 */
@Mapper(componentModel = "spring", uses = {TieuChiMapper.class, MauPhatHanhMapper.class})
public interface MauPhatHanhTieuChiMapper extends EntityMapper<MauPhatHanhTieuChiDTO, MauPhatHanhTieuChi> {

    @Mapping(source = "tieuchi.id", target = "tieuchiId")
    @Mapping(source = "mauphathanh.id", target = "mauphathanhId")
    @Mapping(source = "mauphathanh.mauPhatHanhCode", target = "mauphathanhMauPhatHanhCode")
    MauPhatHanhTieuChiDTO toDto(MauPhatHanhTieuChi mauPhatHanhTieuChi);

    @Mapping(source = "tieuchiId", target = "tieuchi")
    @Mapping(source = "mauphathanhId", target = "mauphathanh")
    MauPhatHanhTieuChi toEntity(MauPhatHanhTieuChiDTO mauPhatHanhTieuChiDTO);

    default MauPhatHanhTieuChi fromId(Long id) {
        if (id == null) {
            return null;
        }
        MauPhatHanhTieuChi mauPhatHanhTieuChi = new MauPhatHanhTieuChi();
        mauPhatHanhTieuChi.setId(id);
        return mauPhatHanhTieuChi;
    }
}
