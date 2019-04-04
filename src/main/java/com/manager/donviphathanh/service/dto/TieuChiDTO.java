package com.manager.donviphathanh.service.dto;
import javax.validation.constraints.*;
import java.io.Serializable;
import java.util.Objects;
import com.manager.donviphathanh.domain.enumeration.ReportStatus;

/**
 * A DTO for the TieuChi entity.
 */
public class TieuChiDTO extends AbstractAuditingDTO implements Serializable {

    private Long id;

    @NotNull
    private String name;

    @NotNull
    private ReportStatus status;


    private Long kycongboId;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ReportStatus getStatus() {
        return status;
    }

    public void setStatus(ReportStatus status) {
        this.status = status;
    }

    public Long getKycongboId() {
        return kycongboId;
    }

    public void setKycongboId(Long kyCongBoId) {
        this.kycongboId = kyCongBoId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        TieuChiDTO tieuChiDTO = (TieuChiDTO) o;
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
        return "TieuChiDTO{" +
            "id=" + getId() +
            ", name='" + getName() + "'" +
            ", status='" + getStatus() + "'" +
            ", kycongbo=" + getKycongboId() +
            "}";
    }
}
