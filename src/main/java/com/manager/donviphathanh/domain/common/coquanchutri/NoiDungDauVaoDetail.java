package com.manager.donviphathanh.domain.common.coquanchutri;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * A DTO for the NoiDungDauRa entity.
 */
public class NoiDungDauVaoDetail implements Serializable {

    private String nhomDanhMucCode;

    private String nhomDanhMucName;

    private List<DanhMucDetail> danhMucs = new ArrayList();

    public String getNhomDanhMucCode() {
        return nhomDanhMucCode;
    }

    public void setNhomDanhMucCode(String nhomDanhMucCode) {
        this.nhomDanhMucCode = nhomDanhMucCode;
    }

    public String getNhomDanhMucName() {
        return nhomDanhMucName;
    }

    public void setNhomDanhMucName(String nhomDanhMucName) {
        this.nhomDanhMucName = nhomDanhMucName;
    }

    public List<DanhMucDetail> getDanhMucs() {
        return danhMucs;
    }

    public void setDanhMucs(List<DanhMucDetail> danhMucs) {
        this.danhMucs = danhMucs;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        NoiDungDauVaoDetail noiDungDauVaoDTO = (NoiDungDauVaoDetail) o;
        if (noiDungDauVaoDTO.getNhomDanhMucCode() == null || getNhomDanhMucCode() == null) {
            return false;
        }
        return Objects.equals(getNhomDanhMucCode(), noiDungDauVaoDTO.getNhomDanhMucCode());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getNhomDanhMucCode());
    }

    @Override
    public String toString() {
        return "NoiDungDauVaoDetailDTO{" +
            "nhomDanhMucCode='" + nhomDanhMucCode + '\'' +
            ", nhomDanhMucName='" + nhomDanhMucName + '\'' +
            ", danhMucs=" + danhMucs +
            '}';
    }
}
