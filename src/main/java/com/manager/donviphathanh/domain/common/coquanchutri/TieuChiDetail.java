package com.manager.donviphathanh.domain.common.coquanchutri;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * A DTO for the TieuChi entity.
 */
public class TieuChiDetail implements Serializable {

    private Long id;

    private KyCongBoDetail kyCongBo;

    private CoQuanChuTriDetail coQuanChuTri;

    private ChiTieuDetail chiTieu;

    private List<NoiDungDetail> noiDungs = new ArrayList();

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public KyCongBoDetail getKyCongBo() {
        return kyCongBo;
    }

    public void setKyCongBo(KyCongBoDetail kyCongBo) {
        this.kyCongBo = kyCongBo;
    }

    public ChiTieuDetail getChiTieu() {
        return chiTieu;
    }

    public void setChiTieu(ChiTieuDetail chiTieu) {
        this.chiTieu = chiTieu;
    }

    public CoQuanChuTriDetail getCoQuanChuTri() {
        return coQuanChuTri;
    }

    public void setCoQuanChuTri(CoQuanChuTriDetail coQuanChuTri) {
        this.coQuanChuTri = coQuanChuTri;
    }

    public List<NoiDungDetail> getNoiDungs() {
        return noiDungs;
    }

    public void setNoiDungs(List<NoiDungDetail> noiDungs) {
        this.noiDungs = noiDungs;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        TieuChiDetail tieuChiDTO = (TieuChiDetail) o;
        if (tieuChiDTO.getId() == null || getId() == null) {
            return false;
        }
        return Objects.equals(getId(), tieuChiDTO.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getId());
    }

    @Override
    public String toString() {
        return "TieuChiDetail{" +
            "id=" + id +
            ", kyCongBo=" + kyCongBo +
            ", coQuanChuTri=" + coQuanChuTri +
            ", chiTieu=" + chiTieu +
            ", noiDungs=" + noiDungs +
            '}';
    }
}
