package com.manager.donviphathanh.client;

import com.manager.donviphathanh.service.dto.quytrinhdonvi.DuLieuTienTrinhDTO;
import org.springframework.stereotype.Component;

import javax.validation.Valid;

@Component
public class QuyTrinhDonViServiceClientFallback implements QuyTrinhDonViServiceClient {


    @Override
    public DuLieuTienTrinhDTO createDuLieuTienTrinh(@Valid DuLieuTienTrinhDTO duLieuTienTrinhDTO) {
        throw new RuntimeException("Loi truy cap service");
    }
}
