package com.manager.donviphathanh.domain.common.loaibaocao;

import javax.validation.constraints.NotNull;
import java.io.Serializable;

/**
 * A DTO for the DonViTinh entity.
 */
public class PhamViDetail implements Serializable {
    @NotNull
    private Integer begin;
    @NotNull
    private Integer end;

    public PhamViDetail() {
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
