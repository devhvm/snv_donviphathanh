package com.manager.donviphathanh.service.dto;

import com.manager.donviphathanh.domain.CustomType;
import org.springframework.data.mongodb.core.mapping.Field;

import javax.validation.constraints.NotNull;
import java.util.List;

public class TieuChiMauPhatHanhDTO {
    @NotNull
    @Field("tieu_chi")
    private CustomType tieuChi;
    @NotNull
    @Field("co_quan_chu_quan")
    private CustomType coQuanChuQuan;
    @NotNull
    @Field("ky_cong_bo")
    private CustomType kyCongBo;
    @NotNull
    @Field("noi_dung_bao_cao_in")
    private List<NoiDungBaoCaoDTO> noiDungBaoCaoIns;
    @NotNull
    @Field("noi_dung_bao_cao_out")
    private List<NoiDungBaoCaoDTO> noiDungBaoCaoOuts;

    public TieuChiMauPhatHanhDTO() {
    }

    public TieuChiMauPhatHanhDTO(@NotNull CustomType tieuChi, @NotNull CustomType coQuanChuQuan, @NotNull CustomType kyCongBo, @NotNull List<NoiDungBaoCaoDTO> noiDungBaoCaoIns, @NotNull List<NoiDungBaoCaoDTO> noiDungBaoCaoOuts) {
        this.tieuChi = tieuChi;
        this.coQuanChuQuan = coQuanChuQuan;
        this.kyCongBo = kyCongBo;
        this.noiDungBaoCaoIns = noiDungBaoCaoIns;
        this.noiDungBaoCaoOuts = noiDungBaoCaoOuts;
    }

    public CustomType getTieuChi() {
        return tieuChi;
    }

    public void setTieuChi(CustomType tieuChi) {
        this.tieuChi = tieuChi;
    }

    public CustomType getCoQuanChuQuan() {
        return coQuanChuQuan;
    }

    public void setCoQuanChuQuan(CustomType coQuanChuQuan) {
        this.coQuanChuQuan = coQuanChuQuan;
    }

    public CustomType getKyCongBo() {
        return kyCongBo;
    }

    public void setKyCongBo(CustomType kyCongBo) {
        this.kyCongBo = kyCongBo;
    }

    public List<NoiDungBaoCaoDTO> getNoiDungBaoCaoIns() {
        return noiDungBaoCaoIns;
    }

    public void setNoiDungBaoCaoIns(List<NoiDungBaoCaoDTO> noiDungBaoCaoIns) {
        this.noiDungBaoCaoIns = noiDungBaoCaoIns;
    }

    public List<NoiDungBaoCaoDTO> getNoiDungBaoCaoOuts() {
        return noiDungBaoCaoOuts;
    }

    public void setNoiDungBaoCaoOuts(List<NoiDungBaoCaoDTO> noiDungBaoCaoOuts) {
        this.noiDungBaoCaoOuts = noiDungBaoCaoOuts;
    }

}
