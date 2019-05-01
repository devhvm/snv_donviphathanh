package com.manager.donviphathanh.domain;

import org.springframework.data.mongodb.core.mapping.Field;

import javax.validation.constraints.NotNull;

public class TienTrinhXuLy extends AbstractAuditingEntity {
    @NotNull
    @Field("quy_trinh_code")
    private String quyTrinhCode;
    @NotNull
    @Field("tien_trinh_code")
    private String tienTrinhCode;
    @Field("name")
    private String name;
    @Field("screen_code")
    private String screenCode;
    @Field("from_user_id")
    private String fromUserId;
    @Field("to_user_id")
    private String toUserId;
    @Field("note")
    private String note;


    public TienTrinhXuLy() {
    }

    public String getQuyTrinhCode() {
        return quyTrinhCode;
    }

    public void setQuyTrinhCode(String quyTrinhCode) {
        this.quyTrinhCode = quyTrinhCode;
    }

    public String getTienTrinhCode() {
        return tienTrinhCode;
    }

    public void setTienTrinhCode(String tienTrinhCode) {
        this.tienTrinhCode = tienTrinhCode;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getScreenCode() {
        return screenCode;
    }

    public void setScreenCode(String screenCode) {
        this.screenCode = screenCode;
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
}
