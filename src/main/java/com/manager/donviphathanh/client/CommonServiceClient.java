package com.manager.donviphathanh.client;

import com.manager.donviphathanh.service.dto.common.TieuChiDetailDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@FeignClient(name = "common", qualifier = "common", url = "${application.gateway.common}", path = "api", fallback = CommonServiceClientFallback.class)
public interface CommonServiceClient {

    @GetMapping("/tieu-chis/co_quan_chu_tri")
    List<TieuChiDetailDTO> getTieuChisByCoQuanChuTriID(@RequestParam("id") Long id) throws RuntimeException;
}
