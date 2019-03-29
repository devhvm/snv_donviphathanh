package com.manager.donviphathanh.service.dto;
import java.time.ZonedDateTime;
import javax.validation.constraints.*;
import java.io.Serializable;
import java.util.Objects;
import com.manager.donviphathanh.domain.enumeration.ReportStatus;

/**
 * A DTO for the TieuChi entity.
 */
public class TieuChiDTO implements Serializable {

    private Long id;

    @NotNull
    private String tieuChiCode;

    @NotNull
    private String name;

    @NotNull
    private String userName;

    @NotNull
    private ZonedDateTime createTime;

    @NotNull
    private ZonedDateTime updateTime;

    @NotNull
    private ReportStatus status;

    @NotNull
    private String program;


    private Long kycongboId;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTieuChiCode() {
        return tieuChiCode;
    }

    public void setTieuChiCode(String tieuChiCode) {
        this.tieuChiCode = tieuChiCode;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public ZonedDateTime getCreateTime() {
        return createTime;
    }

    public void setCreateTime(ZonedDateTime createTime) {
        this.createTime = createTime;
    }

    public ZonedDateTime getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(ZonedDateTime updateTime) {
        this.updateTime = updateTime;
    }

    public ReportStatus getStatus() {
        return status;
    }

    public void setStatus(ReportStatus status) {
        this.status = status;
    }

    public String getProgram() {
        return program;
    }

    public void setProgram(String program) {
        this.program = program;
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
            ", tieuChiCode='" + getTieuChiCode() + "'" +
            ", name='" + getName() + "'" +
            ", userName='" + getUserName() + "'" +
            ", createTime='" + getCreateTime() + "'" +
            ", updateTime='" + getUpdateTime() + "'" +
            ", status='" + getStatus() + "'" +
            ", program='" + getProgram() + "'" +
            ", kycongbo=" + getKycongboId() +
            "}";
    }
}
