package com.manager.donviphathanh.service.mapper;

import com.manager.donviphathanh.domain.NoiDungBaoCao;
import com.manager.donviphathanh.service.dto.NoiDungBaoCaoDTO;
import org.mapstruct.Mapper;

/**
 * Mapper for the entity MauPhatHanh and its DTO MauPhatHanhDTO.
 */
@Mapper(componentModel = "spring", uses = {})
public interface NoiDungBaoCaoMapper extends EntityMapper<NoiDungBaoCaoDTO, NoiDungBaoCao> {

    default NoiDungBaoCao fromId(String id) {
        if (id == null) {
            return null;
        }
        NoiDungBaoCao noiDungBaoCao = new NoiDungBaoCao();
        return noiDungBaoCao;
    }
}
