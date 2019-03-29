package com.manager.donviphathanh.service.dto;
import java.time.ZonedDateTime;
import javax.validation.constraints.*;
import java.io.Serializable;
import java.util.Objects;
import com.manager.donviphathanh.domain.enumeration.ReportStatus;

/**
 * A DTO for the TieuChiBaoCao entity.
 */
public class TieuChiBaoCaoDTO implements Serializable {

    private Long id;

    @NotNull
    private String tieuChiBaoCaoCode;

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


    private Long tieuchiId;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTieuChiBaoCaoCode() {
        return tieuChiBaoCaoCode;
    }

    public void setTieuChiBaoCaoCode(String tieuChiBaoCaoCode) {
        this.tieuChiBaoCaoCode = tieuChiBaoCaoCode;
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

    public Long getTieuchiId() {
        return tieuchiId;
    }

    public void setTieuchiId(Long tieuChiId) {
        this.tieuchiId = tieuChiId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        TieuChiBaoCaoDTO tieuChiBaoCaoDTO = (TieuChiBaoCaoDTO) o;
        if (tieuChiBaoCaoDTO.getId() == null || getId() == null) {
            return false;
        }
        return Objects.equals(getId(), tieuChiBaoCaoDTO.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getId());
    }

    @Override
    public String toString() {
        return "TieuChiBaoCaoDTO{" +
            "id=" + getId() +
            ", tieuChiBaoCaoCode='" + getTieuChiBaoCaoCode() + "'" +
            ", userName='" + getUserName() + "'" +
            ", createTime='" + getCreateTime() + "'" +
            ", updateTime='" + getUpdateTime() + "'" +
            ", status='" + getStatus() + "'" +
            ", program='" + getProgram() + "'" +
            ", tieuchi=" + getTieuchiId() +
            "}";
    }
}
