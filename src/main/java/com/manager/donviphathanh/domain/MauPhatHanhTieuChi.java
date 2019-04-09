package com.manager.donviphathanh.domain;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import javax.persistence.*;

import java.io.Serializable;
import java.util.Objects;

/**
 * A MauPhatHanhTieuChi.
 */
@Entity
@Table(name = "mau_phat_hanh_tieu_chi")
@Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
public class MauPhatHanhTieuChi extends AbstractAuditingEntity implements Serializable {

    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JsonIgnoreProperties("mauphathanhtieuchis")
    private TieuChi tieuchi;

    @ManyToOne
    @JsonIgnoreProperties("mauphathanhtieuchis")
    private MauPhatHanh mauphathanh;

    // jhipster-needle-entity-add-field - JHipster will add fields here, do not remove
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public TieuChi getTieuchi() {
        return tieuchi;
    }

    public MauPhatHanhTieuChi tieuchi(TieuChi tieuChi) {
        this.tieuchi = tieuChi;
        return this;
    }

    public void setTieuchi(TieuChi tieuChi) {
        this.tieuchi = tieuChi;
    }

    public MauPhatHanh getMauphathanh() {
        return mauphathanh;
    }

    public MauPhatHanhTieuChi mauphathanh(MauPhatHanh mauPhatHanh) {
        this.mauphathanh = mauPhatHanh;
        return this;
    }

    public void setMauphathanh(MauPhatHanh mauPhatHanh) {
        this.mauphathanh = mauPhatHanh;
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
        MauPhatHanhTieuChi mauPhatHanhTieuChi = (MauPhatHanhTieuChi) o;
        if (mauPhatHanhTieuChi.getId() == null || getId() == null) {
            return false;
        }
        return Objects.equals(getId(), mauPhatHanhTieuChi.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getId());
    }

    @Override
    public String toString() {
        return "MauPhatHanhTieuChi{" +
            "id=" + getId() +
            "}";
    }
}
