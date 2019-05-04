package com.manager.donviphathanh.domain.common.loaibaocao;

import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * A DTO for the NhomPhanLoai entity.
 */
public class LoaiBaoCao implements Serializable {

    @NotNull
    private String loaiBaoCaoCode;

    @NotNull
    private String name;

    private DonViTinhDetail donViTinh;

    private List<DoiTuongDetail> doiTuongs = new ArrayList<>();

    public String getLoaiBaoCaoCode() {
        return loaiBaoCaoCode;
    }

    public void setLoaiBaoCaoCode(String loaiBaoCaoCode) {
        this.loaiBaoCaoCode = loaiBaoCaoCode;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public DonViTinhDetail getDonViTinh() {
        return donViTinh;
    }

    public void setDonViTinh(DonViTinhDetail donViTinh) {
        this.donViTinh = donViTinh;
    }

    public List<DoiTuongDetail> getDoiTuongs() {
        return doiTuongs;
    }

    public void setDoiTuongs(List<DoiTuongDetail> doiTuongs) {
        this.doiTuongs = doiTuongs;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        LoaiBaoCao nhomPhanLoaiDTO = (LoaiBaoCao) o;
        if (nhomPhanLoaiDTO.getLoaiBaoCaoCode() == null || getLoaiBaoCaoCode() == null) {
            return false;
        }
        return Objects.equals(getLoaiBaoCaoCode(), nhomPhanLoaiDTO.getLoaiBaoCaoCode());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getLoaiBaoCaoCode());
    }

}
