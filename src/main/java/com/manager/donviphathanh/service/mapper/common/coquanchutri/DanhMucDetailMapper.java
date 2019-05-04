package com.manager.donviphathanh.service.mapper.common.coquanchutri;

import com.manager.donviphathanh.domain.common.coquanchutri.DanhMucDetail;
import com.manager.donviphathanh.service.dto.common.coquanchutri.DanhMucDetailDTO;
import com.manager.donviphathanh.service.mapper.EntityMapper;
import org.mapstruct.Mapper;

/**
 * Mapper for the entity MauPhatHanh and its DTO MauPhatHanhDTO.
 */
@Mapper(componentModel = "spring", uses = {})
public interface DanhMucDetailMapper extends EntityMapper<DanhMucDetailDTO, DanhMucDetail> {


}
