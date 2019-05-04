package com.manager.donviphathanh.service.mapper.common.loaibaocao;

import com.manager.donviphathanh.domain.common.loaibaocao.DoiTuongDetail;
import com.manager.donviphathanh.service.dto.common.loaibaocao.DoiTuongDetailDTO;
import com.manager.donviphathanh.service.mapper.EntityMapper;
import org.mapstruct.Mapper;

/**
 * Mapper for the entity MauPhatHanh and its DTO MauPhatHanhDTO.
 */
@Mapper(componentModel = "spring", uses = {})
public interface DoiTuongDetailMapper extends EntityMapper<DoiTuongDetailDTO, DoiTuongDetail> {


}
