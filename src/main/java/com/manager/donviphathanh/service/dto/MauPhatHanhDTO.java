package com.manager.donviphathanh.service.dto;

import com.manager.donviphathanh.domain.enumeration.Status;

import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.List;
import java.util.Objects;

/**
 * A DTO for the MauPhatHanh entity.
 */
public class MauPhatHanhDTO implements Serializable {

    private String id;

    @NotNull
    private String mauPhatHanhCode;

    private CustomTypeDTO nhomPhanLoai;

    @NotNull
    private String name;

    @NotNull
    private Status status;

    @NotNull
    private List<TieuChiMauPhatHanhDTO> tieuChiMauPhatHanhs;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getMauPhatHanhCode() {
        return mauPhatHanhCode;
    }

    public void setMauPhatHanhCode(String mauPhatHanhCode) {
        this.mauPhatHanhCode = mauPhatHanhCode;
    }

    public CustomTypeDTO getNhomPhanLoai() {
        return nhomPhanLoai;
    }

    public void setNhomPhanLoai(CustomTypeDTO nhomPhanLoai) {
        this.nhomPhanLoai = nhomPhanLoai;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public List<TieuChiMauPhatHanhDTO> getTieuChiMauPhatHanhs() {
        return tieuChiMauPhatHanhs;
    }

    public void setTieuChiMauPhatHanhs(List<TieuChiMauPhatHanhDTO> tieuChiMauPhatHanhs) {
        this.tieuChiMauPhatHanhs = tieuChiMauPhatHanhs;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        MauPhatHanhDTO mauPhatHanhDTO = (MauPhatHanhDTO) o;
        if (mauPhatHanhDTO.getId() == null || getId() == null) {
            return false;
        }
        return Objects.equals(getId(), mauPhatHanhDTO.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getId());
    }

    @Override
    public String toString() {
        return "MauPhatHanhDTO{" +
            "id=" + getId() +
            ", mauPhatHanhCode='" + getMauPhatHanhCode() + "'" +
            ", nhomPhanLoai='" + getNhomPhanLoai() + "'" +
            ", name='" + getName() + "'" +
            ", status='" + getStatus() + "'" +
            "}";
    }
}
