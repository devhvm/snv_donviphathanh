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
 * A KyCongBo.
 */
@Entity
@Table(name = "ky_cong_bo")
@Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
public class KyCongBo implements Serializable {

    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @Column(name = "ky_cong_bo_code", nullable = false)
    private String kyCongBoCode;

    @NotNull
    @Column(name = "name", nullable = false)
    private String name;

    @NotNull
    @Enumerated(EnumType.STRING)
    @Column(name = "status", nullable = false)
    private ReportStatus status;

    @OneToMany(mappedBy = "kycongbo")
    @Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
    private Set<TieuChi> tieuchis = new HashSet<>();
    // jhipster-needle-entity-add-field - JHipster will add fields here, do not remove
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getKyCongBoCode() {
        return kyCongBoCode;
    }

    public KyCongBo kyCongBoCode(String kyCongBoCode) {
        this.kyCongBoCode = kyCongBoCode;
        return this;
    }

    public void setKyCongBoCode(String kyCongBoCode) {
        this.kyCongBoCode = kyCongBoCode;
    }

    public String getName() {
        return name;
    }

    public KyCongBo name(String name) {
        this.name = name;
        return this;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ReportStatus getStatus() {
        return status;
    }

    public KyCongBo status(ReportStatus status) {
        this.status = status;
        return this;
    }

    public void setStatus(ReportStatus status) {
        this.status = status;
    }

    public Set<TieuChi> getTieuchis() {
        return tieuchis;
    }

    public KyCongBo tieuchis(Set<TieuChi> tieuChis) {
        this.tieuchis = tieuChis;
        return this;
    }

    public KyCongBo addTieuchi(TieuChi tieuChi) {
        this.tieuchis.add(tieuChi);
        tieuChi.setKycongbo(this);
        return this;
    }

    public KyCongBo removeTieuchi(TieuChi tieuChi) {
        this.tieuchis.remove(tieuChi);
        tieuChi.setKycongbo(null);
        return this;
    }

    public void setTieuchis(Set<TieuChi> tieuChis) {
        this.tieuchis = tieuChis;
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
        KyCongBo kyCongBo = (KyCongBo) o;
        if (kyCongBo.getId() == null || getId() == null) {
            return false;
        }
        return Objects.equals(getId(), kyCongBo.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getId());
    }

    @Override
    public String toString() {
        return "KyCongBo{" +
            "id=" + getId() +
            ", kyCongBoCode='" + getKyCongBoCode() + "'" +
            ", name='" + getName() + "'" +
            ", status='" + getStatus() + "'" +
            "}";
    }
}
