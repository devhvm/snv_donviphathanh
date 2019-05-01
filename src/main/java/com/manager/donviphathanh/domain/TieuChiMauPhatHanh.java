package com.manager.donviphathanh.domain;

import org.springframework.data.mongodb.core.mapping.Field;

import javax.validation.constraints.NotNull;
import java.util.List;

public class TieuChiMauPhatHanh {
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
    private List<NoiDungBaoCao> noiDungBaoCaoIns;
    @NotNull
    @Field("noi_dung_bao_cao_out")
    private List<NoiDungBaoCao> noiDungBaoCaoOuts;

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

    public List<NoiDungBaoCao> getNoiDungBaoCaoIns() {
        return noiDungBaoCaoIns;
    }

    public void setNoiDungBaoCaoIns(List<NoiDungBaoCao> noiDungBaoCaoIns) {
        this.noiDungBaoCaoIns = noiDungBaoCaoIns;
    }

    public List<NoiDungBaoCao> getNoiDungBaoCaoOuts() {
        return noiDungBaoCaoOuts;
    }

    public void setNoiDungBaoCaoOuts(List<NoiDungBaoCao> noiDungBaoCaoOuts) {
        this.noiDungBaoCaoOuts = noiDungBaoCaoOuts;
    }
}
