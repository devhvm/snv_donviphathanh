package com.manager.donviphathanh.web.rest;

import com.manager.donviphathanh.service.MauPhatHanhService;
import com.manager.donviphathanh.service.dto.TienTrinhXuLyDTO;
import io.github.jhipster.web.util.ResponseUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * REST controller for managing MauPhatHanhHistory.
 */
@RestController
@RequestMapping("/api/history")
public class MauPhatHanhHistoryResource {

    private final Logger log = LoggerFactory.getLogger(MauPhatHanhHistoryResource.class);

    private final MauPhatHanhService mauPhatHanhService;


    public MauPhatHanhHistoryResource(MauPhatHanhService mauPhatHanhService) {
        this.mauPhatHanhService = mauPhatHanhService;
    }


    /**
     * GET  /mau-phat-hanh/:code : get the "code" mauPhatHanh.
     *
     * @param code the code of the mauPhatHanhDTO to retrieve
     * @return the ResponseEntity with status 200 (OK) and with body the mauPhatHanhDTO, or with status 404 (Not Found)
     */
    @GetMapping("/mau-phat-hanh/{code}")
    public ResponseEntity<List<TienTrinhXuLyDTO>> get(@PathVariable String code) {
        log.debug("REST request to get MauPhatHanh : {}", code);
        //Optional<MauPhatHanhDTO> mauPhatHanhDTO = mauPhatHanhService.findOne(code);
        return ResponseUtil.wrapOrNotFound(null);
    }


}
