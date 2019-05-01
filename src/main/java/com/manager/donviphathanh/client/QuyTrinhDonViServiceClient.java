package com.manager.donviphathanh.client;

import org.springframework.cloud.openfeign.FeignClient;

@FeignClient(name = "quytrinhdonvi", qualifier = "quytrinhdonvi", url = "${application.gateway.quytrinhdonvi}", path = "api", fallback = QuyTrinhDonViServiceClientFallback.class)
public interface QuyTrinhDonViServiceClient {

}
