package com.manager.donviphathanh.service.dto;
import java.io.Serializable;
import java.util.Objects;

/**
 * A DTO for the MauPhatHanhTieuChi entity.
 */
public class MauPhatHanhTieuChiDTO extends AbstractAuditingDTO implements Serializable {

    private Long id;


    private Long tieuchiId;

    private Long mauphathanhId;

    private String mauphathanhMauPhatHanhCode;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getTieuchiId() {
        return tieuchiId;
    }

    public void setTieuchiId(Long tieuChiId) {
        this.tieuchiId = tieuChiId;
    }

    public Long getMauphathanhId() {
        return mauphathanhId;
    }

    public void setMauphathanhId(Long mauPhatHanhId) {
        this.mauphathanhId = mauPhatHanhId;
    }

    public String getMauphathanhMauPhatHanhCode() {
        return mauphathanhMauPhatHanhCode;
    }

    public void setMauphathanhMauPhatHanhCode(String mauPhatHanhMauPhatHanhCode) {
        this.mauphathanhMauPhatHanhCode = mauPhatHanhMauPhatHanhCode;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        MauPhatHanhTieuChiDTO mauPhatHanhTieuChiDTO = (MauPhatHanhTieuChiDTO) o;
        if (mauPhatHanhTieuChiDTO.getId() == null || getId() == null) {
            return false;
        }
        return Objects.equals(getId(), mauPhatHanhTieuChiDTO.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getId());
    }

    @Override
    public String toString() {
        return "MauPhatHanhTieuChiDTO{" +
            "id=" + getId() +
            ", tieuchi=" + getTieuchiId() +
            ", mauphathanh=" + getMauphathanhId() +
            ", mauphathanh='" + getMauphathanhMauPhatHanhCode() + "'" +
            "}";
    }
}
