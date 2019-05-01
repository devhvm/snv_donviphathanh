package com.manager.donviphathanh.web.rest.errors;

public class ResourceNotFoundException extends RuntimeException {

    private static final long serialVersionUID = 4598453723723898776L;

    public ResourceNotFoundException(String msg) {
        super(msg);
    }
}
