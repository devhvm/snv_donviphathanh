package com.manager.donviphathanh.domain;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import javax.persistence.*;
import javax.validation.constraints.*;

import java.io.Serializable;
import java.time.ZonedDateTime;
import java.util.Objects;

import com.manager.donviphathanh.domain.enumeration.ReportStatus;

/**
 * A TieuChiBaoCao.
 */
@Entity
@Table(name = "tieu_chi_bao_cao")
@Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
public class TieuChiBaoCao implements Serializable {

    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @Column(name = "tieu_chi_bao_cao_code", nullable = false)
    private String tieuChiBaoCaoCode;

    @NotNull
    @Column(name = "user_name", nullable = false)
    private String userName;

    @NotNull
    @Column(name = "create_time", nullable = false)
    private ZonedDateTime createTime;

    @NotNull
    @Column(name = "update_time", nullable = false)
    private ZonedDateTime updateTime;

    @NotNull
    @Enumerated(EnumType.STRING)
    @Column(name = "status", nullable = false)
    private ReportStatus status;

    @NotNull
    @Column(name = "program", nullable = false)
    private String program;

    @ManyToOne
    @JsonIgnoreProperties("tieuchibaocaos")
    private TieuChi tieuchi;

    // jhipster-needle-entity-add-field - JHipster will add fields here, do not remove
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTieuChiBaoCaoCode() {
        return tieuChiBaoCaoCode;
    }

    public TieuChiBaoCao tieuChiBaoCaoCode(String tieuChiBaoCaoCode) {
        this.tieuChiBaoCaoCode = tieuChiBaoCaoCode;
        return this;
    }

    public void setTieuChiBaoCaoCode(String tieuChiBaoCaoCode) {
        this.tieuChiBaoCaoCode = tieuChiBaoCaoCode;
    }

    public String getUserName() {
        return userName;
    }

    public TieuChiBaoCao userName(String userName) {
        this.userName = userName;
        return this;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public ZonedDateTime getCreateTime() {
        return createTime;
    }

    public TieuChiBaoCao createTime(ZonedDateTime createTime) {
        this.createTime = createTime;
        return this;
    }

    public void setCreateTime(ZonedDateTime createTime) {
        this.createTime = createTime;
    }

    public ZonedDateTime getUpdateTime() {
        return updateTime;
    }

    public TieuChiBaoCao updateTime(ZonedDateTime updateTime) {
        this.updateTime = updateTime;
        return this;
    }

    public void setUpdateTime(ZonedDateTime updateTime) {
        this.updateTime = updateTime;
    }

    public ReportStatus getStatus() {
        return status;
    }

    public TieuChiBaoCao status(ReportStatus status) {
        this.status = status;
        return this;
    }

    public void setStatus(ReportStatus status) {
        this.status = status;
    }

    public String getProgram() {
        return program;
    }

    public TieuChiBaoCao program(String program) {
        this.program = program;
        return this;
    }

    public void setProgram(String program) {
        this.program = program;
    }

    public TieuChi getTieuchi() {
        return tieuchi;
    }

    public TieuChiBaoCao tieuchi(TieuChi tieuChi) {
        this.tieuchi = tieuChi;
        return this;
    }

    public void setTieuchi(TieuChi tieuChi) {
        this.tieuchi = tieuChi;
    }
    // jhipster-needle-entity-add-getters-setters - JHipster will add getters and setters here, do not remove

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        TieuChiBaoCao tieuChiBaoCao = (TieuChiBaoCao) o;
        if (tieuChiBaoCao.getId() == null || getId() == null) {
            return false;
        }
        return Objects.equals(getId(), tieuChiBaoCao.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getId());
    }

    @Override
    public String toString() {
        return "TieuChiBaoCao{" +
            "id=" + getId() +
            ", tieuChiBaoCaoCode='" + getTieuChiBaoCaoCode() + "'" +
            ", userName='" + getUserName() + "'" +
            ", createTime='" + getCreateTime() + "'" +
            ", updateTime='" + getUpdateTime() + "'" +
            ", status='" + getStatus() + "'" +
            ", program='" + getProgram() + "'" +
            "}";
    }
}
