package com.manager.donviphathanh.domain;

import com.manager.donviphathanh.domain.common.coquanchutri.TieuChiDetail;
import com.manager.donviphathanh.domain.common.loaibaocao.LoaiBaoCao;
import com.manager.donviphathanh.domain.enumeration.Status;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * A MauPhatHanh.
 */
@Document(collection = "mau_phat_hanh")
public class MauPhatHanh extends AbstractAuditingEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    private String id;

    @NotNull
    @Field("mau_phat_hanh_code")
    private String mauPhatHanhCode;

    //@NotNull
    @Field("loai_bao_cao")
    private LoaiBaoCao loaiBaoCao;

    @NotNull
    @Field("name")
    private String name;

    @NotNull
    @Field("status")
    private Status status;

    @NotNull
    @Field("tieu_chi_mau_phat_hanh")
    private List<TieuChiDetail> tieuChiDetails;

    @Field("du_lieu_tien_trinh")
    private List<DuLieuTienTrinh> duLieuTienTrinhs = new ArrayList<>();

    // jhipster-needle-entity-add-field - JHipster will add fields here, do not
    // remove
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getMauPhatHanhCode() {
        return mauPhatHanhCode;
    }

    public void setMauPhatHanhCode(String mauPhatHanhCode) {
        this.mauPhatHanhCode = mauPhatHanhCode;
    }

    public MauPhatHanh mauPhatHanhCode(String mauPhatHanhCode) {
        this.mauPhatHanhCode = mauPhatHanhCode;
        return this;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public MauPhatHanh name(String name) {
        this.name = name;
        return this;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public MauPhatHanh status(Status status) {
        this.status = status;
        return this;
    }


    // jhipster-needle-entity-add-getters-setters - JHipster will add getters and
    // setters here, do not remove


    public LoaiBaoCao getLoaiBaoCao() {
        return loaiBaoCao;
    }

    public void setLoaiBaoCao(LoaiBaoCao loaiBaoCao) {
        this.loaiBaoCao = loaiBaoCao;
    }

    public List<TieuChiDetail> getTieuChiDetails() {
        return tieuChiDetails;
    }

    public void setTieuChiDetails(List<TieuChiDetail> tieuChiDetails) {
        this.tieuChiDetails = tieuChiDetails;
    }

    public void setDuLieuTienTrinhs(List<DuLieuTienTrinh> duLieuTienTrinhs) {
        this.duLieuTienTrinhs = duLieuTienTrinhs;
    }

    public List<DuLieuTienTrinh> getDuLieuTienTrinhs() {
        return duLieuTienTrinhs;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        MauPhatHanh mauPhatHanh = (MauPhatHanh) o;
        if (mauPhatHanh.getId() == null || getId() == null) {
            return false;
        }
        return Objects.equals(getId(), mauPhatHanh.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getId());
    }

}
