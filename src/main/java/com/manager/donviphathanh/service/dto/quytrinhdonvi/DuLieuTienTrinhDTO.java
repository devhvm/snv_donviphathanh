package com.manager.donviphathanh.service.dto.quytrinhdonvi;

import com.manager.donviphathanh.service.dto.StatusDTO;

import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Objects;

/**
 * A DTO for the DuLieuTienTrinh entity.
 */
public class DuLieuTienTrinhDTO implements Serializable {

    private Long id;

    @NotNull
    private String tienTrinhCode;

    @NotNull
    private String duLieuCode;

    @NotNull
    private String fromUserId;

    @NotNull
    private String name;

    @NotNull
    private String toUserId;

    private String note;


    private Long quyTrinhDonViId;

    private String quyTrinhDonViName;
    @NotNull
    private StatusDTO status;

    public DuLieuTienTrinhDTO() {
    }

    public DuLieuTienTrinhDTO(@NotNull String name, @NotNull String tienTrinhCode, @NotNull String duLieuCode, @NotNull String fromUserId, @NotNull String toUserId, String note, Long quyTrinhDonViId, String quyTrinhDonViName, @NotNull StatusDTO status) {
        this.name = name;
        this.tienTrinhCode = tienTrinhCode;
        this.duLieuCode = duLieuCode;
        this.fromUserId = fromUserId;
        this.toUserId = toUserId;
        this.note = note;
        this.quyTrinhDonViId = quyTrinhDonViId;
        this.quyTrinhDonViName = quyTrinhDonViName;
        this.status = status;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTienTrinhCode() {
        return tienTrinhCode;
    }

    public void setTienTrinhCode(String tienTrinhCode) {
        this.tienTrinhCode = tienTrinhCode;
    }

    public String getDuLieuCode() {
        return duLieuCode;
    }

    public void setDuLieuCode(String duLieuCode) {
        this.duLieuCode = duLieuCode;
    }

    public String getFromUserId() {
        return fromUserId;
    }

    public void setFromUserId(String fromUserId) {
        this.fromUserId = fromUserId;
    }

    public String getToUserId() {
        return toUserId;
    }

    public void setToUserId(String toUserId) {
        this.toUserId = toUserId;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public Long getQuyTrinhDonViId() {
        return quyTrinhDonViId;
    }

    public void setQuyTrinhDonViId(Long quyTrinhDonViId) {
        this.quyTrinhDonViId = quyTrinhDonViId;
    }

    public String getQuyTrinhDonViName() {
        return quyTrinhDonViName;
    }

    public void setQuyTrinhDonViName(String quyTrinhDonViName) {
        this.quyTrinhDonViName = quyTrinhDonViName;
    }

    public StatusDTO getStatus() {
        return status;
    }

    public void setStatus(StatusDTO status) {
        this.status = status;
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

        DuLieuTienTrinhDTO duLieuTienTrinhDTO = (DuLieuTienTrinhDTO) o;
        if (duLieuTienTrinhDTO.getId() == null || getId() == null) {
            return false;
        }
        return Objects.equals(getId(), duLieuTienTrinhDTO.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getId());
    }

    @Override
    public String toString() {
        return "DuLieuTienTrinhDTO{" +
            "id=" + getId() +
            ", tienTrinhCode='" + getTienTrinhCode() + "'" +
            ", duLieuCode='" + getDuLieuCode() + "'" +
            ", fromUserId='" + getFromUserId() + "'" +
            ", toUserId='" + getToUserId() + "'" +
            ", note='" + getNote() + "'" +
            ", quyTrinhDonVi=" + getQuyTrinhDonViId() +
            ", quyTrinhDonVi='" + getQuyTrinhDonViName() + "'" +
            "}";
    }
}
