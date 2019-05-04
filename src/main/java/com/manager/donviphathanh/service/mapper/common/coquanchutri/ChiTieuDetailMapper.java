package com.manager.donviphathanh.service.mapper.common.coquanchutri;

import com.manager.donviphathanh.domain.common.coquanchutri.ChiTieuDetail;
import com.manager.donviphathanh.service.dto.common.coquanchutri.ChiTieuDetailDTO;
import com.manager.donviphathanh.service.mapper.EntityMapper;
import org.mapstruct.Mapper;

/**
 * Mapper for the entity MauPhatHanh and its DTO MauPhatHanhDTO.
 */
@Mapper(componentModel = "spring", uses = {})
public interface ChiTieuDetailMapper extends EntityMapper<ChiTieuDetailDTO, ChiTieuDetail> {


}
