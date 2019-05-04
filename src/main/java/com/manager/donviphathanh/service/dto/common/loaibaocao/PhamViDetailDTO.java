package com.manager.donviphathanh.service.dto.common.loaibaocao;

import javax.validation.constraints.NotNull;
import java.io.Serializable;

/**
 * A DTO for the DonViTinh entity.
 */
public class PhamViDetailDTO implements Serializable {
    @NotNull
    private Integer begin;
    @NotNull
    private Integer end;

    public PhamViDetailDTO() {
    }

    public PhamViDetailDTO(@NotNull Integer begin, @NotNull Integer end) {
        this.begin = begin;
        this.end = end;
    }

    public Integer getBegin() {
        return begin;
    }

    public void setBegin(Integer begin) {
        this.begin = begin;
    }

    public Integer getEnd() {
        return end;
    }

    public void setEnd(Integer end) {
        this.end = end;
    }
}
