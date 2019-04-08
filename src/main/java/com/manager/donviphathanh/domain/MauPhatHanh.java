package com.manager.donviphathanh.domain;


import com.fasterxml.jackson.annotation.JsonIgnore;
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
 * A MauPhatHanh.
 */
@Entity
@Table(name = "mau_phat_hanh")
@Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
public class MauPhatHanh extends AbstractAuditingEntity implements Serializable {

    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @Column(name = "mau_phat_hanh_code", nullable = false)
    private String mauPhatHanhCode;

    @NotNull
    @Column(name = "name", nullable = false)
    private String name;

    @NotNull
    @Enumerated(EnumType.STRING)
    @Column(name = "status", nullable = false)
    private ReportStatus status;

    @OneToOne
    @JoinColumn(unique = true)
    private PhamVi phamvi;

    @OneToMany(mappedBy = "mauphathanh")
    @Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
    private Set<MauPhatHanhTieuChi> mauphathanhtieuchis = new HashSet<>();
    // jhipster-needle-entity-add-field - JHipster will add fields here, do not remove
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getMauPhatHanhCode() {
        return mauPhatHanhCode;
    }

    public MauPhatHanh mauPhatHanhCode(String mauPhatHanhCode) {
        this.mauPhatHanhCode = mauPhatHanhCode;
        return this;
    }

    public void setMauPhatHanhCode(String mauPhatHanhCode) {
        this.mauPhatHanhCode = mauPhatHanhCode;
    }

    public String getName() {
        return name;
    }

    public MauPhatHanh name(String name) {
        this.name = name;
        return this;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ReportStatus getStatus() {
        return status;
    }

    public MauPhatHanh status(ReportStatus status) {
        this.status = status;
        return this;
    }

    public void setStatus(ReportStatus status) {
        this.status = status;
    }

    public PhamVi getPhamvi() {
        return phamvi;
    }

    public MauPhatHanh phamvi(PhamVi phamVi) {
        this.phamvi = phamVi;
        return this;
    }

    public void setPhamvi(PhamVi phamVi) {
        this.phamvi = phamVi;
    }

    public Set<MauPhatHanhTieuChi> getMauphathanhtieuchis() {
        return mauphathanhtieuchis;
    }

    public MauPhatHanh mauphathanhtieuchis(Set<MauPhatHanhTieuChi> mauPhatHanhTieuChis) {
        this.mauphathanhtieuchis = mauPhatHanhTieuChis;
        return this;
    }

    public MauPhatHanh addMauphathanhtieuchi(MauPhatHanhTieuChi mauPhatHanhTieuChi) {
        this.mauphathanhtieuchis.add(mauPhatHanhTieuChi);
        mauPhatHanhTieuChi.setMauphathanh(this);
        return this;
    }

    public MauPhatHanh removeMauphathanhtieuchi(MauPhatHanhTieuChi mauPhatHanhTieuChi) {
        this.mauphathanhtieuchis.remove(mauPhatHanhTieuChi);
        mauPhatHanhTieuChi.setMauphathanh(null);
        return this;
    }

    public void setMauphathanhtieuchis(Set<MauPhatHanhTieuChi> mauPhatHanhTieuChis) {
        this.mauphathanhtieuchis = mauPhatHanhTieuChis;
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

    @Override
    public String toString() {
        return "MauPhatHanh{" +
            "id=" + getId() +
            ", mauPhatHanhCode='" + getMauPhatHanhCode() + "'" +
            ", name='" + getName() + "'" +
            ", status='" + getStatus() + "'" +
            "}";
    }
}
