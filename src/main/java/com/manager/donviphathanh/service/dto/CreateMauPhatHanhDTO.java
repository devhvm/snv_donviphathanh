package com.manager.donviphathanh.service.dto;

public class CreateMauPhatHanhDTO {

    private String maCoQuanChuTri;

    private String maMauPhatHanh;

    private String tenMauPhatHanh;

    private Integer min;
    private Integer max;

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
}
