package com.manager.donviphathanh.service.dto;

import com.manager.donviphathanh.domain.CustomType;
import org.springframework.data.mongodb.core.mapping.Field;

import javax.validation.constraints.NotNull;
import java.util.List;

public class NhomDanhMucBaoCaoDTO {
    @NotNull
    @Field("nhom_danh_muc")
    private CustomType nhomDanhMuc;
    @NotNull
    @Field("danh_muc_bao_cao")
    private List<DanhMucBaoCaoDTO> danhMucBaoCaos;

    public NhomDanhMucBaoCaoDTO() {
    }

    public CustomType getNhomDanhMuc() {
        return nhomDanhMuc;
    }

    public void setNhomDanhMuc(CustomType nhomDanhMuc) {
        this.nhomDanhMuc = nhomDanhMuc;
    }

    public List<DanhMucBaoCaoDTO> getDanhMucBaoCaos() {
        return danhMucBaoCaos;
    }

    public void setDanhMucBaoCaos(List<DanhMucBaoCaoDTO> danhMucBaoCaos) {
        this.danhMucBaoCaos = danhMucBaoCaos;
    }
}
