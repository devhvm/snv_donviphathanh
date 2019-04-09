package com.manager.donviphathanh.service.dto;
import javax.validation.constraints.*;
import java.io.Serializable;
import java.util.Objects;
import com.manager.donviphathanh.domain.enumeration.ReportStatus;

/**
 * A DTO for the MauPhatHanh entity.
 */
public class MauPhatHanhDTO extends AbstractAuditingDTO implements Serializable {

    private Long id;

    @NotNull
    private String mauPhatHanhCode;

    @NotNull
    private String name;

    @NotNull
    private ReportStatus status;


    private Long phamviId;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getMauPhatHanhCode() {
        return mauPhatHanhCode;
    }

    public void setMauPhatHanhCode(String mauPhatHanhCode) {
        this.mauPhatHanhCode = mauPhatHanhCode;
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

    public Long getPhamviId() {
        return phamviId;
    }

    public void setPhamviId(Long phamViId) {
        this.phamviId = phamViId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        MauPhatHanhDTO mauPhatHanhDTO = (MauPhatHanhDTO) o;
        if (mauPhatHanhDTO.getId() == null || getId() == null) {
            return false;
        }
        return Objects.equals(getId(), mauPhatHanhDTO.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getId());
    }

    @Override
    public String toString() {
        return "MauPhatHanhDTO{" +
            "id=" + getId() +
            ", mauPhatHanhCode='" + getMauPhatHanhCode() + "'" +
            ", name='" + getName() + "'" +
            ", status='" + getStatus() + "'" +
            ", phamvi=" + getPhamviId() +
            "}";
    }
}
