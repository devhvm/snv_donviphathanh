package com.manager.donviphathanh.service.dto.common;


import com.manager.donviphathanh.service.dto.StatusDTO;

import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Objects;

/**
 * A DTO for the NoiDungDauVao entity.
 */
public class NoiDungDauVaoDTO extends AbstractAuditingDTO implements Serializable {

    private Long id;

    @NotNull
    private StatusDTO status;


    private Long noiDungId;

    private Long nhomDanhMucId;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public StatusDTO getStatus() {
        return status;
    }

    public void setStatus(StatusDTO status) {
        this.status = status;
    }

    public Long getNoiDungId() {
        return noiDungId;
    }

    public void setNoiDungId(Long noiDungId) {
        this.noiDungId = noiDungId;
    }

    public Long getNhomDanhMucId() {
        return nhomDanhMucId;
    }

    public void setNhomDanhMucId(Long nhomDanhMucId) {
        this.nhomDanhMucId = nhomDanhMucId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        NoiDungDauVaoDTO noiDungDauVaoDTO = (NoiDungDauVaoDTO) o;
        if (noiDungDauVaoDTO.getId() == null || getId() == null) {
            return false;
        }
        return Objects.equals(getId(), noiDungDauVaoDTO.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getId());
    }

    @Override
    public String toString() {
        return "NoiDungDauVaoDTO{" +
            "id=" + getId() +
            ", status='" + getStatus() + "'" +
            ", noiDung=" + getNoiDungId() +
            ", nhomDanhMuc=" + getNhomDanhMucId() +
            "}";
    }
}
