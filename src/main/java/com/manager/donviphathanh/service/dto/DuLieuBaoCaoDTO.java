package com.manager.donviphathanh.service.dto;

import com.manager.donviphathanh.domain.enumeration.Status;

import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Objects;

/**
 * A DTO for the DuLieuBaoCao entity.
 */
public class DuLieuBaoCaoDTO implements Serializable {

    private String id;

    @NotNull
    private String revisionId;

    private CustomTypeDTO duLieu;

    @NotNull
    private Integer male;

    @NotNull
    private Integer fmale;

    @NotNull
    private Status status;


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getRevisionId() {
        return revisionId;
    }

    public void setRevisionId(String revisionId) {
        this.revisionId = revisionId;
    }

    public CustomTypeDTO getDuLieu() {
        return duLieu;
    }

    public void setDuLieu(CustomTypeDTO duLieu) {
        this.duLieu = duLieu;
    }

    public Integer getMale() {
        return male;
    }

    public void setMale(Integer male) {
        this.male = male;
    }

    public Integer getFmale() {
        return fmale;
    }

    public void setFmale(Integer fmale) {
        this.fmale = fmale;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        DuLieuBaoCaoDTO duLieuBaoCaoDTO = (DuLieuBaoCaoDTO) o;
        if (duLieuBaoCaoDTO.getId() == null || getId() == null) {
            return false;
        }
        return Objects.equals(getId(), duLieuBaoCaoDTO.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getId());
    }

    @Override
    public String toString() {
        return "DuLieuBaoCaoDTO{" +
            "id=" + getId() +
            ", revisionId='" + getRevisionId() + "'" +
            ", duLieu='" + getDuLieu() + "'" +
            ", male=" + getMale() +
            ", fmale=" + getFmale() +
            ", status='" + getStatus() + "'" +
            "}";
    }
}
