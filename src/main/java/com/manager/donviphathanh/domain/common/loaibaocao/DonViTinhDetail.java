package com.manager.donviphathanh.domain.common.loaibaocao;

import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Objects;

/**
 * A DTO for the DonViTinh entity.
 */
public class DonViTinhDetail implements Serializable {

    private Long id;

    @NotNull
    private String donViTinhCode;

    @NotNull
    private String name;

    private PhamViDetail phamvi;


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

    public PhamViDetail getPhamvi() {
        return phamvi;
    }

    public void setPhamvi(PhamViDetail phamvi) {
        this.phamvi = phamvi;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        DonViTinhDetail donViTinhDTO = (DonViTinhDetail) o;
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
            "}";
    }
}
