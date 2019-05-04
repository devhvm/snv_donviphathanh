package com.manager.donviphathanh.domain.common.coquanchutri;

import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Objects;

/**
 * A DTO for the ChiTieu entity.
 */
public class ChiTieuDetail implements Serializable {

    @NotNull
    private String chiTieuCode;

    @NotNull
    private String name;

    public String getChiTieuCode() {
        return chiTieuCode;
    }

    public void setChiTieuCode(String chiTieuCode) {
        this.chiTieuCode = chiTieuCode;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        ChiTieuDetail chiTieuDTO = (ChiTieuDetail) o;
        if (chiTieuDTO.getChiTieuCode() == null || getChiTieuCode() == null) {
            return false;
        }
        return Objects.equals(getChiTieuCode(), chiTieuDTO.getChiTieuCode());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getChiTieuCode());
    }

    @Override
    public String toString() {
        return "ChiTieuDTO{" +
            ", chiTieuCode='" + getChiTieuCode() + "'" +
            ", name='" + getName() + "'" +
            "}";
    }
}
