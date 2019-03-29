package com.manager.donviphathanh.service.dto;
import java.time.ZonedDateTime;
import javax.validation.constraints.*;
import java.io.Serializable;
import java.util.Objects;
import com.manager.donviphathanh.domain.enumeration.ReportStatus;

/**
 * A DTO for the MauPhatHanh entity.
 */
public class MauPhatHanhDTO implements Serializable {

    private Long id;

    @NotNull
    private String mauPhatHanhCode;

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


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getMauPhatHanhCode() {
        return mauPhatHanhCode;
    }

    public void setMauPhatHanhCode(String mauPhatHanhCode) {
        this.mauPhatHanhCode = mauPhatHanhCode;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        MauPhatHanhDTO mauPhatHanhDTO = (MauPhatHanhDTO) o;
        if (mauPhatHanhDTO.getId() == null || getId() == null) {
            return false;
        }
        return Objects.equals(getId(), mauPhatHanhDTO.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getId());
    }

    @Override
    public String toString() {
        return "MauPhatHanhDTO{" +
            "id=" + getId() +
            ", mauPhatHanhCode='" + getMauPhatHanhCode() + "'" +
            ", name='" + getName() + "'" +
            ", userName='" + getUserName() + "'" +
            ", createTime='" + getCreateTime() + "'" +
            ", updateTime='" + getUpdateTime() + "'" +
            ", status='" + getStatus() + "'" +
            ", program='" + getProgram() + "'" +
            "}";
    }
}
