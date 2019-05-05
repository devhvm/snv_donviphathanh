package com.manager.donviphathanh.service.dto;

import javax.validation.constraints.NotNull;

public class CreateMauPhatHanhDTO {

    @NotNull
    private String maCoQuanChuTri;
    @NotNull
    private Long idCoQuanChuTri;
    @NotNull
    private String maMauPhatHanh;
    @NotNull
    private String tenMauPhatHanh;
    @NotNull
    private Integer min;
    @NotNull
    private Integer max;
    @NotNull
    private String tienTrinhCode;
    @NotNull
    private Long quyTrinhDonViId;
    @NotNull
    private String quyTrinhDonViName;

    private StatusDTO status;
    private String note;


    public CreateMauPhatHanhDTO() {
    }

    public String getMaCoQuanChuTri() {
        return maCoQuanChuTri;
    }

    public void setMaCoQuanChuTri(String maCoQuanChuTri) {
        this.maCoQuanChuTri = maCoQuanChuTri;
    }

    public String getMaMauPhatHanh() {
        return maMauPhatHanh;
    }

    public void setMaMauPhatHanh(String maMauPhatHanh) {
        this.maMauPhatHanh = maMauPhatHanh;
    }

    public String getTenMauPhatHanh() {
        return tenMauPhatHanh;
    }

    public void setTenMauPhatHanh(String tenMauPhatHanh) {
        this.tenMauPhatHanh = tenMauPhatHanh;
    }

    public Integer getMin() {
        return min;
    }

    public void setMin(Integer min) {
        this.min = min;
    }

    public Integer getMax() {
        return max;
    }

    public void setMax(Integer max) {
        this.max = max;
    }

    public Long getIdCoQuanChuTri() {
        return idCoQuanChuTri;
    }

    public void setIdCoQuanChuTri(Long idCoQuanChuTri) {
        this.idCoQuanChuTri = idCoQuanChuTri;
    }

    public String getTienTrinhCode() {
        return tienTrinhCode;
    }

    public void setTienTrinhCode(String tienTrinhCode) {
        this.tienTrinhCode = tienTrinhCode;
    }

    public Long getQuyTrinhDonViId() {
        return quyTrinhDonViId;
    }

    public void setQuyTrinhDonViId(Long quyTrinhDonViId) {
        this.quyTrinhDonViId = quyTrinhDonViId;
    }

    public StatusDTO getStatus() {
        return status;
    }

    public void setStatus(StatusDTO status) {
        this.status = status;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public String getQuyTrinhDonViName() {
        return quyTrinhDonViName;
    }

    public void setQuyTrinhDonViName(String quyTrinhDonViName) {
        this.quyTrinhDonViName = quyTrinhDonViName;
    }
}
