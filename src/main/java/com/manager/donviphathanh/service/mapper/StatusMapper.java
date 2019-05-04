package com.manager.donviphathanh.service.mapper;

import com.manager.donviphathanh.domain.enumeration.Status;
import com.manager.donviphathanh.service.dto.StatusDTO;
import org.mapstruct.Mapper;

/**
 * Mapper for the entity DuLieuTienTrinh and its DTO DuLieuTienTrinhDTO.
 */
@Mapper(componentModel = "spring", uses = {})
public interface StatusMapper extends EntityMapper<StatusDTO, Status> {

    default Status fromId(String id) {
        if (id == null) {
            return null;
        }
        Status status = Status.NEW;
        return status;
    }
}
