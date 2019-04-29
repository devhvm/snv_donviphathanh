package com.manager.donviphathanh.domain;

import org.springframework.data.mongodb.core.mapping.Field;

import javax.validation.constraints.NotNull;

public class CustomType {
    @NotNull
    @Field("code")
    private String code;
    @NotNull
    @Field("name")
    private String name;
    @Field("description")
    private String description;

    public CustomType() {
    }

    public CustomType(@NotNull String code, @NotNull String name, String description) {
        this.code = code;
        this.name = name;
        this.description = description;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
