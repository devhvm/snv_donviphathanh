package com.manager.donviphathanh.domain;


import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import javax.persistence.*;
import javax.validation.constraints.*;

import java.io.Serializable;
import java.time.ZonedDateTime;
import java.util.HashSet;
import java.util.Set;
import java.util.Objects;

import com.manager.donviphathanh.domain.enumeration.ReportStatus;

/**
 * A TieuChi.
 */
@Entity
@Table(name = "tieu_chi")
@Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
public class TieuChi implements Serializable {

    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @Column(name = "tieu_chi_code", nullable = false)
    private String tieuChiCode;

    @NotNull
    @Column(name = "name", nullable = false)
    private String name;

    @NotNull
    @Column(name = "user_name", nullable = false)
    private String userName;

    @NotNull
    @Column(name = "create_time", nullable = false)
    private ZonedDateTime createTime;

    @NotNull
    @Column(name = "update_time", nullable = false)
    private ZonedDateTime updateTime;

    @NotNull
    @Enumerated(EnumType.STRING)
    @Column(name = "status", nullable = false)
    private ReportStatus status;

    @NotNull
    @Column(name = "program", nullable = false)
    private String program;

    @OneToMany(mappedBy = "tieuchi")
    @Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
    private Set<TieuChiBaoCao> tieuchibaocaos = new HashSet<>();
    @OneToMany(mappedBy = "tieuchi")
    @Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
    private Set<MauPhatHanhTieuChi> mauphathanhtieuchis = new HashSet<>();
    @ManyToOne
    @JsonIgnoreProperties("tieuchis")
    private KyCongBo kycongbo;

    // jhipster-needle-entity-add-field - JHipster will add fields here, do not remove
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTieuChiCode() {
        return tieuChiCode;
    }

    public TieuChi tieuChiCode(String tieuChiCode) {
        this.tieuChiCode = tieuChiCode;
        return this;
    }

    public void setTieuChiCode(String tieuChiCode) {
        this.tieuChiCode = tieuChiCode;
    }

    public String getName() {
        return name;
    }

    public TieuChi name(String name) {
        this.name = name;
        return this;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUserName() {
        return userName;
    }

    public TieuChi userName(String userName) {
        this.userName = userName;
        return this;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public ZonedDateTime getCreateTime() {
        return createTime;
    }

    public TieuChi createTime(ZonedDateTime createTime) {
        this.createTime = createTime;
        return this;
    }

    public void setCreateTime(ZonedDateTime createTime) {
        this.createTime = createTime;
    }

    public ZonedDateTime getUpdateTime() {
        return updateTime;
    }

    public TieuChi updateTime(ZonedDateTime updateTime) {
        this.updateTime = updateTime;
        return this;
    }

    public void setUpdateTime(ZonedDateTime updateTime) {
        this.updateTime = updateTime;
    }

    public ReportStatus getStatus() {
        return status;
    }

    public TieuChi status(ReportStatus status) {
        this.status = status;
        return this;
    }

    public void setStatus(ReportStatus status) {
        this.status = status;
    }

    public String getProgram() {
        return program;
    }

    public TieuChi program(String program) {
        this.program = program;
        return this;
    }

    public void setProgram(String program) {
        this.program = program;
    }

    public Set<TieuChiBaoCao> getTieuchibaocaos() {
        return tieuchibaocaos;
    }

    public TieuChi tieuchibaocaos(Set<TieuChiBaoCao> tieuChiBaoCaos) {
        this.tieuchibaocaos = tieuChiBaoCaos;
        return this;
    }

    public TieuChi addTieuchibaocao(TieuChiBaoCao tieuChiBaoCao) {
        this.tieuchibaocaos.add(tieuChiBaoCao);
        tieuChiBaoCao.setTieuchi(this);
        return this;
    }

    public TieuChi removeTieuchibaocao(TieuChiBaoCao tieuChiBaoCao) {
        this.tieuchibaocaos.remove(tieuChiBaoCao);
        tieuChiBaoCao.setTieuchi(null);
        return this;
    }

    public void setTieuchibaocaos(Set<TieuChiBaoCao> tieuChiBaoCaos) {
        this.tieuchibaocaos = tieuChiBaoCaos;
    }

    public Set<MauPhatHanhTieuChi> getMauphathanhtieuchis() {
        return mauphathanhtieuchis;
    }

    public TieuChi mauphathanhtieuchis(Set<MauPhatHanhTieuChi> mauPhatHanhTieuChis) {
        this.mauphathanhtieuchis = mauPhatHanhTieuChis;
        return this;
    }

    public TieuChi addMauphathanhtieuchi(MauPhatHanhTieuChi mauPhatHanhTieuChi) {
        this.mauphathanhtieuchis.add(mauPhatHanhTieuChi);
        mauPhatHanhTieuChi.setTieuchi(this);
        return this;
    }

    public TieuChi removeMauphathanhtieuchi(MauPhatHanhTieuChi mauPhatHanhTieuChi) {
        this.mauphathanhtieuchis.remove(mauPhatHanhTieuChi);
        mauPhatHanhTieuChi.setTieuchi(null);
        return this;
    }

    public void setMauphathanhtieuchis(Set<MauPhatHanhTieuChi> mauPhatHanhTieuChis) {
        this.mauphathanhtieuchis = mauPhatHanhTieuChis;
    }

    public KyCongBo getKycongbo() {
        return kycongbo;
    }

    public TieuChi kycongbo(KyCongBo kyCongBo) {
        this.kycongbo = kyCongBo;
        return this;
    }

    public void setKycongbo(KyCongBo kyCongBo) {
        this.kycongbo = kyCongBo;
    }
    // jhipster-needle-entity-add-getters-setters - JHipster will add getters and setters here, do not remove

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        TieuChi tieuChi = (TieuChi) o;
        if (tieuChi.getId() == null || getId() == null) {
            return false;
        }
        return Objects.equals(getId(), tieuChi.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getId());
    }

    @Override
    public String toString() {
        return "TieuChi{" +
            "id=" + getId() +
            ", tieuChiCode='" + getTieuChiCode() + "'" +
            ", name='" + getName() + "'" +
            ", userName='" + getUserName() + "'" +
            ", createTime='" + getCreateTime() + "'" +
            ", updateTime='" + getUpdateTime() + "'" +
            ", status='" + getStatus() + "'" +
            ", program='" + getProgram() + "'" +
            "}";
    }
}
