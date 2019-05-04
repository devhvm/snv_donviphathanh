package com.manager.donviphathanh.service.dto.common.loaibaocao;

import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Objects;

/**
 * A DTO for the DonViTinh entity.
 */
public class DonViTinhDetailDTO implements Serializable {

    private Long id;

    @NotNull
    private String donViTinhCode;

    @NotNull
    private String name;

    private String status;

    //@NotNull
    private PhamViDetailDTO phamvi;


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


    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
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

        DonViTinhDetailDTO donViTinhDTO = (DonViTinhDetailDTO) o;
        if (donViTinhDTO.getId() == null || getId() == null) {
            return false;
        }
        return Objects.equals(getId(), donViTinhDTO.getId());
    }

    public PhamViDetailDTO getPhamvi() {
        return phamvi;
    }

    public void setPhamvi(PhamViDetailDTO phamvi) {
        this.phamvi = phamvi;
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

            "}";
    }
}
