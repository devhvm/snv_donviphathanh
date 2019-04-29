package com.manager.donviphathanh.domain;

import org.springframework.data.mongodb.core.mapping.Field;

import javax.validation.constraints.NotNull;
import java.util.List;

public class NhomDanhMucBaoCao {
    @NotNull
    @Field("nhom_danh_muc")
    private CustomType nhomDanhMuc;
    @NotNull
    @Field("danh_muc_bao_cao")
    private List<DanhMucBaoCao> danhMucBaoCaos;

    public NhomDanhMucBaoCao() {
    }

    public CustomType getNhomDanhMuc() {
        return nhomDanhMuc;
    }

    public void setNhomDanhMuc(CustomType nhomDanhMuc) {
        this.nhomDanhMuc = nhomDanhMuc;
    }

    public List<DanhMucBaoCao> getDanhMucBaoCaos() {
        return danhMucBaoCaos;
    }

    public void setDanhMucBaoCaos(List<DanhMucBaoCao> danhMucBaoCaos) {
        this.danhMucBaoCaos = danhMucBaoCaos;
    }
}
