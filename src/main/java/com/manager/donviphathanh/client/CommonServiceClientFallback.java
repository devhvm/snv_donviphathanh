package com.manager.donviphathanh.client;

import com.manager.donviphathanh.service.dto.common.coquanchutri.TieuChiDetailDTO;
import com.manager.donviphathanh.service.dto.common.loaibaocao.LoaiBaoCaoDTO;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class CommonServiceClientFallback implements CommonServiceClient {


    @Override
    public List<TieuChiDetailDTO> getTieuChisByCoQuanChuTriID(Long id) throws RuntimeException {
        throw new RuntimeException("Khong tao duoc quy trinh");
    }

    @Override
    public LoaiBaoCaoDTO getLoaiBaoCao(Long id) throws RuntimeException {
        throw new RuntimeException("Khong tao duoc quy trinh");
    }
}
