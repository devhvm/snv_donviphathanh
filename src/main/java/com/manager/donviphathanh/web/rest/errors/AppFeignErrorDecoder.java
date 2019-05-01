package com.manager.donviphathanh.web.rest.errors;

import feign.Response;
import feign.codec.ErrorDecoder;
import org.springframework.stereotype.Component;

@Component
public class AppFeignErrorDecoder implements ErrorDecoder {

    private final ErrorDecoder defaultErrorDecoder = new Default();

    @Override
    public Exception decode(String methodKey, Response response) {
        if (response.status() >= 404) {
            throw new ResourceNotFoundException("Resource Not Found");
        }

        return defaultErrorDecoder.decode(methodKey, response);
    }

}
