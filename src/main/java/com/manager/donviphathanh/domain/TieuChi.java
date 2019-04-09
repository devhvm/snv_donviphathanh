package com.manager.donviphathanh.domain;


import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import javax.persistence.*;
import javax.validation.constraints.*;

import java.io.Serializable;
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
    @Column(name = "chi_tieu_code", nullable = false)
    private String chiTieuCode;

    @NotNull
    @Column(name = "name", nullable = false)
    private String name;

    @NotNull
    @Enumerated(EnumType.STRING)
    @Column(name = "status", nullable = false)
    private ReportStatus status;

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

    public String getChiTieuCode() {
        return chiTieuCode;
    }

    public TieuChi chiTieuCode(String chiTieuCode) {
        this.chiTieuCode = chiTieuCode;
        return this;
    }

    public void setChiTieuCode(String chiTieuCode) {
        this.chiTieuCode = chiTieuCode;
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
            ", chiTieuCode='" + getChiTieuCode() + "'" +
            ", name='" + getName() + "'" +
            ", status='" + getStatus() + "'" +
            "}";
    }
}
