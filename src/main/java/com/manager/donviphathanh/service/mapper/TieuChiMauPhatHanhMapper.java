package com.manager.donviphathanh.service.mapper;

import com.manager.donviphathanh.domain.TieuChiMauPhatHanh;
import com.manager.donviphathanh.service.dto.TieuChiMauPhatHanhDTO;
import org.mapstruct.Mapper;

/**
 * Mapper for the entity MauPhatHanh and its DTO MauPhatHanhDTO.
 */
@Mapper(componentModel = "spring", uses = {})
public interface TieuChiMauPhatHanhMapper extends EntityMapper<TieuChiMauPhatHanhDTO, TieuChiMauPhatHanh> {


    //@Mapping(source = "noiDungBaoCaoIns", target = "noiDungBaoCaoIns")
    //@Mapping(source = "noiDungBaoCaoOuts", target = "noiDungBaoCaoOuts")
    TieuChiMauPhatHanh toEntity(TieuChiMauPhatHanhDTO dto);

    default TieuChiMauPhatHanh fromId(String id) {
        if (id == null) {
            return null;
        }
        TieuChiMauPhatHanh tieuChiMauPhatHanh = new TieuChiMauPhatHanh();
        return tieuChiMauPhatHanh;
    }
}
