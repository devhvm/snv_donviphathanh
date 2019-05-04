package com.manager.donviphathanh.service.dto;

import com.manager.donviphathanh.service.dto.common.coquanchutri.TieuChiDetailDTO;
import com.manager.donviphathanh.service.dto.common.loaibaocao.LoaiBaoCaoDTO;
import com.manager.donviphathanh.service.dto.quytrinhdonvi.DuLieuTienTrinhDTO;

import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * A DTO for the MauPhatHanh entity.
 */
public class MauPhatHanhDTO implements Serializable {

    private String id;

    @NotNull
    private String mauPhatHanhCode;

    private LoaiBaoCaoDTO loaiBaoCao;

    @NotNull
    private String name;

    @NotNull
    private StatusDTO status;

    @NotNull
    private List<TieuChiDetailDTO> tieuChiDetails;

    private List<DuLieuTienTrinhDTO> duLieuTienTrinhs = new ArrayList<>();

//    @NotNull
//    private List<TieuChiMauPhatHanhDTO> tieuChiMauPhatHanhs;


    public MauPhatHanhDTO() {
    }

    public MauPhatHanhDTO(@NotNull String mauPhatHanhCode, LoaiBaoCaoDTO loaiBaoCao, @NotNull String name, @NotNull StatusDTO status, @NotNull List<TieuChiDetailDTO> tieuChiDetails) {
        this.mauPhatHanhCode = mauPhatHanhCode;
        this.loaiBaoCao = loaiBaoCao;
        this.name = name;
        this.status = status;
        this.tieuChiDetails = tieuChiDetails;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getMauPhatHanhCode() {
        return mauPhatHanhCode;
    }

    public void setMauPhatHanhCode(String mauPhatHanhCode) {
        this.mauPhatHanhCode = mauPhatHanhCode;
    }

    public static MauPhatHanhDTO of(CreateMauPhatHanhDTO createMauPhatHanhDTO, LoaiBaoCaoDTO loaiBaoCao, List<TieuChiDetailDTO> tieuChiDetailDTOS) {
        return new MauPhatHanhDTO(createMauPhatHanhDTO.getMaMauPhatHanh(), loaiBaoCao, createMauPhatHanhDTO.getTenMauPhatHanh(), StatusDTO.NEW, tieuChiDetailDTOS);
    }

    public LoaiBaoCaoDTO getLoaiBaoCao() {
        return loaiBaoCao;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setLoaiBaoCao(LoaiBaoCaoDTO loaiBaoCao) {
        this.loaiBaoCao = loaiBaoCao;
    }

    public StatusDTO getStatus() {
        return status;
    }

    public void setStatus(StatusDTO status) {
        this.status = status;
    }

    public List<TieuChiDetailDTO> getTieuChiDetails() {
        return tieuChiDetails;
    }

    public List<DuLieuTienTrinhDTO> getDuLieuTienTrinhs() {
        return duLieuTienTrinhs;
    }

    public void setDuLieuTienTrinhs(List<DuLieuTienTrinhDTO> duLieuTienTrinhs) {
        this.duLieuTienTrinhs = duLieuTienTrinhs;
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
            ", nhomPhanLoai='" + getLoaiBaoCao() + "'" +
            ", name='" + getName() + "'" +
            ", status='" + getStatus() + "'" +
            "}";
    }

    public void setTieuChiDetails(List<TieuChiDetailDTO> tieuChiDetails) {
        this.tieuChiDetails = tieuChiDetails;
    }
}
