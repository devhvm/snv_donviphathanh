package com.manager.donviphathanh.service.dto;

import com.manager.donviphathanh.domain.CustomType;
import org.springframework.data.mongodb.core.mapping.Field;

import javax.validation.constraints.NotNull;
import java.util.List;

public class NoiDungBaoCaoDTO {
    @NotNull
    @Field("noi_dung")
    private CustomType noiDung;
    @NotNull
    @Field("nhom_danh_muc_bao_cao")
    private List<NhomDanhMucBaoCaoDTO> nhomDanhMucBaoCaos;

    public NoiDungBaoCaoDTO() {
    }

    public CustomType getNoiDung() {
        return noiDung;
    }

    public void setNoiDung(CustomType noiDung) {
        this.noiDung = noiDung;
    }

    public List<NhomDanhMucBaoCaoDTO> getNhomDanhMucBaoCaos() {
        return nhomDanhMucBaoCaos;
    }

    public void setNhomDanhMucBaoCaos(List<NhomDanhMucBaoCaoDTO> nhomDanhMucBaoCaos) {
        this.nhomDanhMucBaoCaos = nhomDanhMucBaoCaos;
    }
}
