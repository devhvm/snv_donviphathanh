package com.manager.donviphathanh.web.rest;

import com.manager.donviphathanh.service.MauPhatHanhService;
import com.manager.donviphathanh.service.dto.CreateMauPhatHanhDTO;
import com.manager.donviphathanh.service.dto.MauPhatHanhDTO;
import com.manager.donviphathanh.service.dto.quytrinhdonvi.DuLieuTienTrinhDTO;
import com.manager.donviphathanh.web.rest.util.HeaderUtil;
import io.github.jhipster.web.util.ResponseUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;
import java.util.Optional;

/**
 * REST controller for managing MauPhatHanh.
 */
@RestController
@RequestMapping("/api")
public class MauPhatHanhResource {

    private final Logger log = LoggerFactory.getLogger(MauPhatHanhResource.class);

    private static final String ENTITY_NAME = "MauPhatHanh";

    private final MauPhatHanhService mauPhatHanhService;


    public MauPhatHanhResource(MauPhatHanhService mauPhatHanhService) {
        this.mauPhatHanhService = mauPhatHanhService;
    }

    /**
     * POST  /mau-phat-hanhs : Create a new mauPhatHanh.
     *
     * @param createMauPhatHanhDTO the mauPhatHanhDTO to create
     * @return the ResponseEntity with status 201 (Created) and with body the new mauPhatHanhDTO, or with status 400 (Bad Request) if the mauPhatHanh has already an ID
     * @throws URISyntaxException if the Location URI syntax is incorrect
     */
    @PostMapping("/mau-phat-hanh")
    public ResponseEntity<MauPhatHanhDTO> createMauPhatHanh(@Valid @RequestBody CreateMauPhatHanhDTO createMauPhatHanhDTO) throws URISyntaxException {
        log.debug("REST request to save MauPhatHanh : {}", createMauPhatHanhDTO);

        MauPhatHanhDTO result = mauPhatHanhService.create(createMauPhatHanhDTO).get();

        return ResponseEntity.created(new URI("/api/mau-phat-hanh/" + result.getMauPhatHanhCode()))
            .headers(HeaderUtil.createEntityCreationAlert(ENTITY_NAME, result.getId()))
            .body(result);
    }

    //feedback
    @PutMapping("/mau-phat-hanh/{mauPhatHanhCode}/cap-nhat-quy-trinh")
    public ResponseEntity<DuLieuTienTrinhDTO> updateMauPhatHanh(@PathVariable String mauPhatHanhCode, @Valid @RequestBody DuLieuTienTrinhDTO duLieuTienTrinh) {
        log.debug("REST request to save MauPhatHanh : {}", mauPhatHanhCode);

        DuLieuTienTrinhDTO result = mauPhatHanhService.updateQuyTrinh(mauPhatHanhCode, duLieuTienTrinh).get();

        return ResponseEntity.ok()
            .headers(HeaderUtil.createEntityUpdateAlert("DuLieuTienTrinh", result.getId().toString()))
            .body(result);

    }
    /**
     * GET  /mau-phat-hanhs : get all the mauPhatHanhs.
     *
     * @return the ResponseEntity with status 200 (OK) and the list of mauPhatHanhs in body
     */
    @GetMapping("/list")
    public List<MauPhatHanhDTO> list() {
        log.debug("REST request to get all MauPhatHanhs");
        return mauPhatHanhService.findAll();
    }
    /**
     * GET  /mau-phat-hanhs : get all the mauPhatHanhs.
     *
     * @return the ResponseEntity with status 200 (OK) and the list of mauPhatHanhs in body
     */
    @GetMapping("/signed")
    public List<MauPhatHanhDTO> signed() {
        log.debug("REST request to get all MauPhatHanhs");
        return mauPhatHanhService.findAllBySigned();
    }
    /**
     * GET  /mau-phat-hanh/:code : get the "code" mauPhatHanh.
     *
     * @param mauPhatHanhCode the code of the mauPhatHanhDTO to retrieve
     * @return the ResponseEntity with status 200 (OK) and with body the mauPhatHanhDTO, or with status 404 (Not Found)
     */
    @GetMapping("/mau-phat-hanh/{mauPhatHanhCode}")
    public ResponseEntity<MauPhatHanhDTO> getMauPhatHanh(@PathVariable String mauPhatHanhCode) {
        log.debug("REST request to get MauPhatHanh : {}", mauPhatHanhCode);
        Optional<MauPhatHanhDTO> mauPhatHanhDTO = mauPhatHanhService.findOneByMauPhatHanhCode(mauPhatHanhCode);
        return ResponseUtil.wrapOrNotFound(mauPhatHanhDTO);
    }

    /**
     * DELETE  /mau-phat-hanhs/:code : delete the "code" mauPhatHanh.
     *
     * @param code the id of the mauPhatHanhDTO to delete
     * @return the ResponseEntity with status 200 (OK)
     */
    @DeleteMapping("/mau-phat-hanh/{code}")
    public ResponseEntity<Void> deleteMauPhatHanh(@PathVariable String code) {
        log.debug("REST request to delete MauPhatHanh : {}", code);
        mauPhatHanhService.delete(code);
        return ResponseEntity.ok().headers(HeaderUtil.createEntityDeletionAlert(ENTITY_NAME, code)).build();
    }
}
