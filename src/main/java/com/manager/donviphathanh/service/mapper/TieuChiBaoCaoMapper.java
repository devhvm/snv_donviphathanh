package com.manager.donviphathanh.service.mapper;

import com.manager.donviphathanh.domain.*;
import com.manager.donviphathanh.service.dto.TieuChiBaoCaoDTO;

import org.mapstruct.*;

/**
 * Mapper for the entity TieuChiBaoCao and its DTO TieuChiBaoCaoDTO.
 */
@Mapper(componentModel = "spring", uses = {TieuChiMapper.class})
public interface TieuChiBaoCaoMapper extends EntityMapper<TieuChiBaoCaoDTO, TieuChiBaoCao> {

    @Mapping(source = "tieuchi.id", target = "tieuchiId")
    TieuChiBaoCaoDTO toDto(TieuChiBaoCao tieuChiBaoCao);

    @Mapping(source = "tieuchiId", target = "tieuchi")
    TieuChiBaoCao toEntity(TieuChiBaoCaoDTO tieuChiBaoCaoDTO);

    default TieuChiBaoCao fromId(Long id) {
        if (id == null) {
            return null;
        }
        TieuChiBaoCao tieuChiBaoCao = new TieuChiBaoCao();
        tieuChiBaoCao.setId(id);
        return tieuChiBaoCao;
    }
}
