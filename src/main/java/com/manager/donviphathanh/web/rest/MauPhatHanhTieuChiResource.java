package com.manager.donviphathanh.web.rest;
import com.manager.donviphathanh.service.MauPhatHanhTieuChiService;
import com.manager.donviphathanh.web.rest.errors.BadRequestAlertException;
import com.manager.donviphathanh.web.rest.util.HeaderUtil;
import com.manager.donviphathanh.web.rest.util.PaginationUtil;
import com.manager.donviphathanh.service.dto.MauPhatHanhTieuChiDTO;
import io.github.jhipster.web.util.ResponseUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.net.URISyntaxException;

import java.util.List;
import java.util.Optional;

/**
 * REST controller for managing MauPhatHanhTieuChi.
 */
@RestController
@RequestMapping("/api")
public class MauPhatHanhTieuChiResource {

    private final Logger log = LoggerFactory.getLogger(MauPhatHanhTieuChiResource.class);

    private static final String ENTITY_NAME = "donviphathanhMauPhatHanhTieuChi";

    private final MauPhatHanhTieuChiService mauPhatHanhTieuChiService;

    public MauPhatHanhTieuChiResource(MauPhatHanhTieuChiService mauPhatHanhTieuChiService) {
        this.mauPhatHanhTieuChiService = mauPhatHanhTieuChiService;
    }

    /**
     * POST  /mau-phat-hanh-tieu-chis : Create a new mauPhatHanhTieuChi.
     *
     * @param mauPhatHanhTieuChiDTO the mauPhatHanhTieuChiDTO to create
     * @return the ResponseEntity with status 201 (Created) and with body the new mauPhatHanhTieuChiDTO, or with status 400 (Bad Request) if the mauPhatHanhTieuChi has already an ID
     * @throws URISyntaxException if the Location URI syntax is incorrect
     */
    @PostMapping("/mau-phat-hanh-tieu-chis")
    public ResponseEntity<MauPhatHanhTieuChiDTO> createMauPhatHanhTieuChi(@RequestBody MauPhatHanhTieuChiDTO mauPhatHanhTieuChiDTO) throws URISyntaxException {
        log.debug("REST request to save MauPhatHanhTieuChi : {}", mauPhatHanhTieuChiDTO);
        if (mauPhatHanhTieuChiDTO.getId() != null) {
            throw new BadRequestAlertException("A new mauPhatHanhTieuChi cannot already have an ID", ENTITY_NAME, "idexists");
        }
        MauPhatHanhTieuChiDTO result = mauPhatHanhTieuChiService.save(mauPhatHanhTieuChiDTO);
        return ResponseEntity.created(new URI("/api/mau-phat-hanh-tieu-chis/" + result.getId()))
            .headers(HeaderUtil.createEntityCreationAlert(ENTITY_NAME, result.getId().toString()))
            .body(result);
    }

    /**
     * PUT  /mau-phat-hanh-tieu-chis : Updates an existing mauPhatHanhTieuChi.
     *
     * @param mauPhatHanhTieuChiDTO the mauPhatHanhTieuChiDTO to update
     * @return the ResponseEntity with status 200 (OK) and with body the updated mauPhatHanhTieuChiDTO,
     * or with status 400 (Bad Request) if the mauPhatHanhTieuChiDTO is not valid,
     * or with status 500 (Internal Server Error) if the mauPhatHanhTieuChiDTO couldn't be updated
     * @throws URISyntaxException if the Location URI syntax is incorrect
     */
    @PutMapping("/mau-phat-hanh-tieu-chis")
    public ResponseEntity<MauPhatHanhTieuChiDTO> updateMauPhatHanhTieuChi(@RequestBody MauPhatHanhTieuChiDTO mauPhatHanhTieuChiDTO) throws URISyntaxException {
        log.debug("REST request to update MauPhatHanhTieuChi : {}", mauPhatHanhTieuChiDTO);
        if (mauPhatHanhTieuChiDTO.getId() == null) {
            throw new BadRequestAlertException("Invalid id", ENTITY_NAME, "idnull");
        }
        MauPhatHanhTieuChiDTO result = mauPhatHanhTieuChiService.save(mauPhatHanhTieuChiDTO);
        return ResponseEntity.ok()
            .headers(HeaderUtil.createEntityUpdateAlert(ENTITY_NAME, mauPhatHanhTieuChiDTO.getId().toString()))
            .body(result);
    }

    /**
     * GET  /mau-phat-hanh-tieu-chis : get all the mauPhatHanhTieuChis.
     *
     * @param pageable the pagination information
     * @return the ResponseEntity with status 200 (OK) and the list of mauPhatHanhTieuChis in body
     */
    @GetMapping("/mau-phat-hanh-tieu-chis")
    public ResponseEntity<List<MauPhatHanhTieuChiDTO>> getAllMauPhatHanhTieuChis(Pageable pageable) {
        log.debug("REST request to get a page of MauPhatHanhTieuChis");
        Page<MauPhatHanhTieuChiDTO> page = mauPhatHanhTieuChiService.findAll(pageable);
        HttpHeaders headers = PaginationUtil.generatePaginationHttpHeaders(page, "/api/mau-phat-hanh-tieu-chis");
        return ResponseEntity.ok().headers(headers).body(page.getContent());
    }

    /**
     * GET  /mau-phat-hanh-tieu-chis/:id : get the "id" mauPhatHanhTieuChi.
     *
     * @param id the id of the mauPhatHanhTieuChiDTO to retrieve
     * @return the ResponseEntity with status 200 (OK) and with body the mauPhatHanhTieuChiDTO, or with status 404 (Not Found)
     */
    @GetMapping("/mau-phat-hanh-tieu-chis/{id}")
    public ResponseEntity<MauPhatHanhTieuChiDTO> getMauPhatHanhTieuChi(@PathVariable Long id) {
        log.debug("REST request to get MauPhatHanhTieuChi : {}", id);
        Optional<MauPhatHanhTieuChiDTO> mauPhatHanhTieuChiDTO = mauPhatHanhTieuChiService.findOne(id);
        return ResponseUtil.wrapOrNotFound(mauPhatHanhTieuChiDTO);
    }

    /**
     * DELETE  /mau-phat-hanh-tieu-chis/:id : delete the "id" mauPhatHanhTieuChi.
     *
     * @param id the id of the mauPhatHanhTieuChiDTO to delete
     * @return the ResponseEntity with status 200 (OK)
     */
    @DeleteMapping("/mau-phat-hanh-tieu-chis/{id}")
    public ResponseEntity<Void> deleteMauPhatHanhTieuChi(@PathVariable Long id) {
        log.debug("REST request to delete MauPhatHanhTieuChi : {}", id);
        mauPhatHanhTieuChiService.delete(id);
        return ResponseEntity.ok().headers(HeaderUtil.createEntityDeletionAlert(ENTITY_NAME, id.toString())).build();
    }
}
