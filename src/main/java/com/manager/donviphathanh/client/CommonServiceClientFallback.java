package com.manager.donviphathanh.client;

import com.manager.donviphathanh.service.dto.common.TieuChiDetailDTO;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class CommonServiceClientFallback implements CommonServiceClient {


    @Override
    public List<TieuChiDetailDTO> getTieuChisByCoQuanChuTriID(Long id) throws RuntimeException {
        return null;
    }
}
