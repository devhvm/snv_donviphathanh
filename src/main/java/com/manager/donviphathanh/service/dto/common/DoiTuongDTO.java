package com.manager.donviphathanh.service.dto.common;

import com.manager.donviphathanh.service.dto.StatusDTO;

import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Objects;

/**
 * A DTO for the DoiTuong entity.
 */
public class DoiTuongDTO extends AbstractAuditingDTO implements Serializable {

    private Long id;

    @NotNull
    private String doiTuongCode;

    @NotNull
    private String name;

    @NotNull
    private StatusDTO status;


    private Long nhomPhanLoaiId;

    private String nhomPhanLoaiNhomPhanLoaiCode;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDoiTuongCode() {
        return doiTuongCode;
    }

    public void setDoiTuongCode(String doiTuongCode) {
        this.doiTuongCode = doiTuongCode;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public StatusDTO getStatus() {
        return status;
    }

    public void setStatus(StatusDTO status) {
        this.status = status;
    }

    public Long getNhomPhanLoaiId() {
        return nhomPhanLoaiId;
    }

    public void setNhomPhanLoaiId(Long nhomPhanLoaiId) {
        this.nhomPhanLoaiId = nhomPhanLoaiId;
    }

    public String getNhomPhanLoaiNhomPhanLoaiCode() {
        return nhomPhanLoaiNhomPhanLoaiCode;
    }

    public void setNhomPhanLoaiNhomPhanLoaiCode(String nhomPhanLoaiNhomPhanLoaiCode) {
        this.nhomPhanLoaiNhomPhanLoaiCode = nhomPhanLoaiNhomPhanLoaiCode;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        DoiTuongDTO doiTuongDTO = (DoiTuongDTO) o;
        if (doiTuongDTO.getId() == null || getId() == null) {
            return false;
        }
        return Objects.equals(getId(), doiTuongDTO.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getId());
    }

    @Override
    public String toString() {
        return "DoiTuongDTO{" +
            "id=" + getId() +
            ", doiTuongCode='" + getDoiTuongCode() + "'" +
            ", name='" + getName() + "'" +
            ", status='" + getStatus() + "'" +
            ", nhomPhanLoai=" + getNhomPhanLoaiId() +
            ", nhomPhanLoai='" + getNhomPhanLoaiNhomPhanLoaiCode() + "'" +
            "}";
    }
}
