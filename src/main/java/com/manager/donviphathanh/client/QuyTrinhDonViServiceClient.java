package com.manager.donviphathanh.client;

import com.manager.donviphathanh.service.dto.quytrinhdonvi.DuLieuTienTrinhDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import javax.validation.Valid;
import java.net.URISyntaxException;

@FeignClient(name = "quytrinhdonvi", qualifier = "quytrinhdonvi", url = "${snv.gateway.quytrinhdonvi:}", path = "api", fallback = QuyTrinhDonViServiceClientFallback.class)
public interface QuyTrinhDonViServiceClient {

    @PostMapping("/du-lieu-tien-trinhs")
    DuLieuTienTrinhDTO createDuLieuTienTrinh(@Valid @RequestBody DuLieuTienTrinhDTO duLieuTienTrinhDTO) throws URISyntaxException;
}
