package com.manager.donviphathanh.domain;

import org.springframework.data.mongodb.core.mapping.Field;

import javax.validation.constraints.NotNull;
import java.util.List;

public class NoiDungBaoCao {
    @NotNull
    @Field("noi_dung")
    private CustomType noiDung;
    @NotNull
    @Field("nhom_danh_muc_bao_cao")
    private List<NhomDanhMucBaoCao> nhomDanhMucBaoCaos;

    public NoiDungBaoCao() {
    }

    public CustomType getNoiDung() {
        return noiDung;
    }

    public void setNoiDung(CustomType noiDung) {
        this.noiDung = noiDung;
    }

    public List<NhomDanhMucBaoCao> getNhomDanhMucBaoCaos() {
        return nhomDanhMucBaoCaos;
    }

    public void setNhomDanhMucBaoCaos(List<NhomDanhMucBaoCao> nhomDanhMucBaoCaos) {
        this.nhomDanhMucBaoCaos = nhomDanhMucBaoCaos;
    }
}
