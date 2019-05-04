package com.manager.donviphathanh.service.mapper.common.coquanchutri;

import com.manager.donviphathanh.domain.common.coquanchutri.CoQuanChuTriDetail;
import com.manager.donviphathanh.service.dto.common.coquanchutri.CoQuanChuTriDetailDTO;
import com.manager.donviphathanh.service.mapper.EntityMapper;
import org.mapstruct.Mapper;

/**
 * Mapper for the entity MauPhatHanh and its DTO MauPhatHanhDTO.
 */
@Mapper(componentModel = "spring", uses = {})
public interface CoQuanChuTriDetailMapper extends EntityMapper<CoQuanChuTriDetailDTO, CoQuanChuTriDetail> {


}
