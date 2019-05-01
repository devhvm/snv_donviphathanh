package com.manager.donviphathanh.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.mongodb.core.mapping.Field;

import javax.validation.constraints.NotNull;
import java.time.Instant;
import java.util.List;

public class DuLieuBaoCao {
    @NotNull
    @Field("revision_id")
    private String revisionId;
    @NotNull
    @Field("du_lieu")
    private CustomType duLieu;
    @NotNull
    @Field("male")
    private Integer male;
    @NotNull
    @Field("fmale")
    private Integer fmale;
    @CreatedBy
    @Field("created_by")
    @JsonIgnore
    private String createdBy;
    @CreatedDate
    @Field("created_date")
    @JsonIgnore
    private Instant createdDate = Instant.now();

    @Field("historys")
    private List<DuLieuBaoCao> historys;

    public String getRevisionId() {
        return revisionId;
    }

    public void setRevisionId(String revisionId) {
        this.revisionId = revisionId;
    }

}
