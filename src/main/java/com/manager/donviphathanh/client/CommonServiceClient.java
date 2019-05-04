package com.manager.donviphathanh.client;

import com.manager.donviphathanh.service.dto.common.coquanchutri.TieuChiDetailDTO;
import com.manager.donviphathanh.service.dto.common.loaibaocao.LoaiBaoCaoDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@FeignClient(name = "common", qualifier = "common", url = "${snv.gateway.common:}", path = "api", fallback = CommonServiceClientFallback.class)
public interface CommonServiceClient {

    @GetMapping("/tieu-chis/co_quan_chu_tri")
    List<TieuChiDetailDTO> getTieuChisByCoQuanChuTriID(@RequestParam("id") Long id) throws RuntimeException;

    @GetMapping("/loai-bao-caos/{id}")
    LoaiBaoCaoDTO getLoaiBaoCao(@PathVariable("id") Long id) throws RuntimeException;

}
