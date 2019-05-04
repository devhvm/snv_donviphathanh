package com.manager.donviphathanh.service.mapper.common.loaibaocao;

import com.manager.donviphathanh.domain.common.loaibaocao.DonViTinhDetail;
import com.manager.donviphathanh.service.dto.common.loaibaocao.DonViTinhDetailDTO;
import com.manager.donviphathanh.service.mapper.EntityMapper;
import org.mapstruct.Mapper;

/**
 * Mapper for the entity MauPhatHanh and its DTO MauPhatHanhDTO.
 */
@Mapper(componentModel = "spring", uses = {})
public interface DonViTinhDetailMapper extends EntityMapper<DonViTinhDetailDTO, DonViTinhDetail> {

    //@Mapping(target = "status", ignore = true)
    DonViTinhDetail toEntity(DonViTinhDetailDTO dto);

}
