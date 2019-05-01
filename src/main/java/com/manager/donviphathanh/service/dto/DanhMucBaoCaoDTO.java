package com.manager.donviphathanh.service.dto;

import com.manager.donviphathanh.domain.CustomType;
import org.springframework.data.mongodb.core.mapping.Field;

import javax.validation.constraints.NotNull;

public class DanhMucBaoCaoDTO {
    @NotNull
    @Field("danh_muc")
    private CustomType danhMuc;
    @NotNull
    @Field("hien_thi_nhap_lieu")
    private Boolean hienThiNhapLieu;
//    @NotNull
//    @Field("du_lieu_bao_cao")
//    private List<DuLieuBaoCaoDTO> duLieuBaoCaos;

    public DanhMucBaoCaoDTO() {
    }

    public CustomType getDanhMuc() {
        return danhMuc;
    }

    public void setDanhMuc(CustomType danhMuc) {
        this.danhMuc = danhMuc;
    }

    public Boolean getHienThiNhapLieu() {
        return hienThiNhapLieu;
    }

    public void setHienThiNhapLieu(Boolean hienThiNhapLieu) {
        this.hienThiNhapLieu = hienThiNhapLieu;
    }

//    public List<DuLieuBaoCaoDTO> getDuLieuBaoCaos() {
//        return duLieuBaoCaos;
//    }
//
//    public void setDuLieuBaoCaos(List<DuLieuBaoCaoDTO> duLieuBaoCaos) {
//        this.duLieuBaoCaos = duLieuBaoCaos;
//    }
}
