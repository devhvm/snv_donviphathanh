package com.manager.donviphathanh.domain.common.coquanchutri;


import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Objects;

/**
 * A DTO for the DanhMuc entity.
 */
public class DanhMucDetail implements Serializable {

    @NotNull
    private String danhMucCode;

    @NotNull
    private String name;

    public String getDanhMucCode() {
        return danhMucCode;
    }

    public void setDanhMucCode(String danhMucCode) {
        this.danhMucCode = danhMucCode;
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

        DanhMucDetail danhMucDTO = (DanhMucDetail) o;
        if (danhMucDTO.getDanhMucCode() == null || getDanhMucCode() == null) {
            return false;
        }
        return Objects.equals(getDanhMucCode(), danhMucDTO.getDanhMucCode());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getDanhMucCode());
    }

    @Override
    public String toString() {
        return "DanhMucDTO{" +
            ", danhMucCode='" + getDanhMucCode() + "'" +
            ", name='" + getName() + "'" +
            "}";
    }
}
