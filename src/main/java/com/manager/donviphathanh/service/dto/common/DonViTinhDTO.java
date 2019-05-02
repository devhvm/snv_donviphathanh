package com.manager.donviphathanh.service.dto.common;

import com.manager.donviphathanh.service.dto.StatusDTO;

import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Objects;

/**
 * A DTO for the DonViTinh entity.
 */
public class DonViTinhDTO extends AbstractAuditingDTO implements Serializable {

    private Long id;

    @NotNull
    private String donViTinhCode;

    @NotNull
    private String name;

    @NotNull
    private StatusDTO status;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDonViTinhCode() {
        return donViTinhCode;
    }

    public void setDonViTinhCode(String donViTinhCode) {
        this.donViTinhCode = donViTinhCode;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public StatusDTO getStatus() {
        return status;
    }

    public void setStatus(StatusDTO status) {
        this.status = status;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        DonViTinhDTO donViTinhDTO = (DonViTinhDTO) o;
        if (donViTinhDTO.getId() == null || getId() == null) {
            return false;
        }
        return Objects.equals(getId(), donViTinhDTO.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getId());
    }

    @Override
    public String toString() {
        return "DonViTinhDTO{" +
            "id=" + getId() +
            ", donViTinhCode='" + getDonViTinhCode() + "'" +
            ", name='" + getName() + "'" +
            ", status='" + getStatus() + "'" +
            "}";
    }
}
