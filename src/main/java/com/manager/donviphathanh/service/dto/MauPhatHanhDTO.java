package com.manager.donviphathanh.service.dto;

import com.manager.donviphathanh.domain.enumeration.Status;
import com.manager.donviphathanh.service.dto.common.TieuChiDetailDTO;

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
    private List<TieuChiDetailDTO> tieuChiDetails;

//    @NotNull
//    private List<TieuChiMauPhatHanhDTO> tieuChiMauPhatHanhs;


    public MauPhatHanhDTO() {
    }

    public MauPhatHanhDTO(@NotNull String mauPhatHanhCode, CustomTypeDTO nhomPhanLoai, @NotNull String name, @NotNull Status status, @NotNull List<TieuChiDetailDTO> tieuChiDetails) {
        this.mauPhatHanhCode = mauPhatHanhCode;
        this.nhomPhanLoai = nhomPhanLoai;
        this.name = name;
        this.status = status;
        this.tieuChiDetails = tieuChiDetails;
    }

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

    public static MauPhatHanhDTO of(CreateMauPhatHanhDTO createMauPhatHanhDTO, List<TieuChiDetailDTO> tieuChiDetailDTOS) {
        return new MauPhatHanhDTO(createMauPhatHanhDTO.getMaMauPhatHanh(), null, createMauPhatHanhDTO.getTenMauPhatHanh(), Status.NEW, tieuChiDetailDTOS);
    }

    public List<TieuChiDetailDTO> getTieuChiDetails() {
        return tieuChiDetails;
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

    public void setTieuChiDetails(List<TieuChiDetailDTO> tieuChiDetails) {
        this.tieuChiDetails = tieuChiDetails;
    }
}
