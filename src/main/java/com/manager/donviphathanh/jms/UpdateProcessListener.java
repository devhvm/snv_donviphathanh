package com.manager.donviphathanh.jms;

import com.manager.donviphathanh.service.dto.TienTrinhXuLyDTO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

@Component
public class UpdateProcessListener {
    private static Logger log = LoggerFactory.getLogger(UpdateProcessListener.class);

    @JmsListener(
        destination = "${spring.snv.process.updated:Consumer.DVPH.VirtualTopic.PROCESS.UPDATED}",
        selector = "_type = 'TienTrinhBaoCaoDTO'"
    )
    public String onEvent(TienTrinhXuLyDTO tienTrinhXuLyDTO) {
        log.info("received <" + tienTrinhXuLyDTO + ">");
        return tienTrinhXuLyDTO.toString();
    }
}
