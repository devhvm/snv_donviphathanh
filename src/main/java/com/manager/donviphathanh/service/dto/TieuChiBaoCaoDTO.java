package com.manager.donviphathanh.service.dto;
import javax.validation.constraints.*;
import java.io.Serializable;
import java.util.Objects;
import com.manager.donviphathanh.domain.enumeration.ReportStatus;

/**
 * A DTO for the TieuChiBaoCao entity.
 */
public class TieuChiBaoCaoDTO implements Serializable {

    private Long id;

    @NotNull
    private String tieuChiBaoCaoCode;

    @NotNull
    private ReportStatus status;


    private Long tieuchiId;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTieuChiBaoCaoCode() {
        return tieuChiBaoCaoCode;
    }

    public void setTieuChiBaoCaoCode(String tieuChiBaoCaoCode) {
        this.tieuChiBaoCaoCode = tieuChiBaoCaoCode;
    }

    public ReportStatus getStatus() {
        return status;
    }

    public void setStatus(ReportStatus status) {
        this.status = status;
    }

    public Long getTieuchiId() {
        return tieuchiId;
    }

    public void setTieuchiId(Long tieuChiId) {
        this.tieuchiId = tieuChiId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        TieuChiBaoCaoDTO tieuChiBaoCaoDTO = (TieuChiBaoCaoDTO) o;
        if (tieuChiBaoCaoDTO.getId() == null || getId() == null) {
            return false;
        }
        return Objects.equals(getId(), tieuChiBaoCaoDTO.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getId());
    }

    @Override
    public String toString() {
        return "TieuChiBaoCaoDTO{" +
            "id=" + getId() +
            ", tieuChiBaoCaoCode='" + getTieuChiBaoCaoCode() + "'" +
            ", status='" + getStatus() + "'" +
            ", tieuchi=" + getTieuchiId() +
            "}";
    }
}
