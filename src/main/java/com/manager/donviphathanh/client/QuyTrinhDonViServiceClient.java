package com.manager.donviphathanh.client;

import org.springframework.cloud.openfeign.FeignClient;

@FeignClient(name = "common", qualifier = "common", url = "${application.gateway.quytrinhdonvi}", path = "api", fallback = QuyTrinhDonViServiceClientFallback.class)
public interface QuyTrinhDonViServiceClient {

}
