package com.manager.donviphathanh.client;

import com.manager.donviphathanh.service.dto.ChiTieuDTO;
import com.manager.donviphathanh.service.dto.CreateMauPhatHanhDTO;
import com.manager.donviphathanh.service.dto.MauPhatHanhDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import javax.validation.Valid;
import java.util.List;

@FeignClient(name = "common", qualifier = "common", url = "${application.gateway.common}", path = "api", fallback = CommonServiceClientFallback.class)
public interface CommonServiceClient {
    @GetMapping("/chi-tieus")
    List<ChiTieuDTO> getAllChiTieus(@RequestParam("page") Integer page, @RequestParam("size") Integer size, @RequestParam("sort") String[] sort);

    @PostMapping("/create-mau-phat-hanh")
    MauPhatHanhDTO createMauPhatHanh(@Valid @RequestBody CreateMauPhatHanhDTO createMauPhatHanhDTO) throws RuntimeException;
}
