package com.manager.donviphathanh.domain.common.coquanchutri;

import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * A DTO for the NoiDung entity.
 */
public class NoiDungDetail implements Serializable {

    private Long id;

    @NotNull
    private String noiDungCode;

    @NotNull
    private String name;


    private List<NoiDungDauVaoDetail> noiDungDauVaos = new ArrayList();

    private List<NoiDungDauRaDetail> noiDungDauRas = new ArrayList();


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNoiDungCode() {
        return noiDungCode;
    }

    public void setNoiDungCode(String noiDungCode) {
        this.noiDungCode = noiDungCode;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<NoiDungDauVaoDetail> getNoiDungDauVaos() {
        return noiDungDauVaos;
    }

    public void setNoiDungDauVaos(List<NoiDungDauVaoDetail> noiDungDauVaos) {
        this.noiDungDauVaos = noiDungDauVaos;
    }

    public List<NoiDungDauRaDetail> getNoiDungDauRas() {
        return noiDungDauRas;
    }

    public void setNoiDungDauRas(List<NoiDungDauRaDetail> noiDungDauRas) {
        this.noiDungDauRas = noiDungDauRas;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        NoiDungDetail noiDungDTO = (NoiDungDetail) o;
        if (noiDungDTO.getId() == null || getId() == null) {
            return false;
        }
        return Objects.equals(getId(), noiDungDTO.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getId());
    }

    @Override
    public String toString() {
        return "NoiDungDTO{" +
            "id=" + getId() +
            ", noiDungCode='" + getNoiDungCode() + "'" +
            ", name='" + getName() + "'" +
            "}";
    }
}
