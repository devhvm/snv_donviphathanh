package com.manager.donviphathanh.service.dto;
import javax.validation.constraints.*;
import java.io.Serializable;
import java.util.Objects;

/**
 * A DTO for the PhamVi entity.
 */
public class PhamViDTO extends AbstractAuditingDTO implements Serializable {

    private Long id;

    @NotNull
    private String begin;

    @NotNull
    private String end;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getBegin() {
        return begin;
    }

    public void setBegin(String begin) {
        this.begin = begin;
    }

    public String getEnd() {
        return end;
    }

    public void setEnd(String end) {
        this.end = end;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        PhamViDTO phamViDTO = (PhamViDTO) o;
        if (phamViDTO.getId() == null || getId() == null) {
            return false;
        }
        return Objects.equals(getId(), phamViDTO.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getId());
    }

    @Override
    public String toString() {
        return "PhamViDTO{" +
            "id=" + getId() +
            ", begin='" + getBegin() + "'" +
            ", end='" + getEnd() + "'" +
            "}";
    }
}
