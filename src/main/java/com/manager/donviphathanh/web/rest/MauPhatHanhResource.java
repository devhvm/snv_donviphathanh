package com.manager.donviphathanh.web.rest;

import com.manager.donviphathanh.service.MauPhatHanhService;
import com.manager.donviphathanh.service.dto.CreateMauPhatHanhDTO;
import com.manager.donviphathanh.service.dto.MauPhatHanhDTO;
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

    private static final String ENTITY_NAME = "donviphathanhMauPhatHanh";

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
    @PostMapping("/mau-phat-hanhs")
    public ResponseEntity<MauPhatHanhDTO> createMauPhatHanh(@Valid @RequestBody CreateMauPhatHanhDTO createMauPhatHanhDTO) throws URISyntaxException {
        log.debug("REST request to save MauPhatHanh : {}", createMauPhatHanhDTO);

        MauPhatHanhDTO result = mauPhatHanhService.create(createMauPhatHanhDTO);

        return ResponseEntity.created(new URI("/api/mau-phat-hanhs/" + result.getId()))
            .headers(HeaderUtil.createEntityCreationAlert(ENTITY_NAME, result.getId()))
            .body(result);
    }

//    /**
//     * PUT  /mau-phat-hanhs : Updates an existing mauPhatHanh.
//     *
//     * @param mauPhatHanhDTO the mauPhatHanhDTO to update
//     * @return the ResponseEntity with status 200 (OK) and with body the updated mauPhatHanhDTO,
//     * or with status 400 (Bad Request) if the mauPhatHanhDTO is not valid,
//     * or with status 500 (Internal Server Error) if the mauPhatHanhDTO couldn't be updated
//     * @throws URISyntaxException if the Location URI syntax is incorrect
//     */
//    @PutMapping("/mau-phat-hanhs")
//    public ResponseEntity<MauPhatHanhDTO> updateMauPhatHanh(@Valid @RequestBody MauPhatHanhDTO mauPhatHanhDTO) throws URISyntaxException {
//        log.debug("REST request to update MauPhatHanh : {}", mauPhatHanhDTO);
//        if (mauPhatHanhDTO.getId() == null) {
//            throw new BadRequestAlertException("Invalid id", ENTITY_NAME, "idnull");
//        }
//        MauPhatHanhDTO result = mauPhatHanhService.save(mauPhatHanhDTO);
//        return ResponseEntity.ok()
//            .headers(HeaderUtil.createEntityUpdateAlert(ENTITY_NAME, mauPhatHanhDTO.getId().toString()))
//            .body(result);
//    }

    /**
     * GET  /mau-phat-hanhs : get all the mauPhatHanhs.
     *
     * @return the ResponseEntity with status 200 (OK) and the list of mauPhatHanhs in body
     */
    @GetMapping("/mau-phat-hanhs")
    public List<MauPhatHanhDTO> getAllMauPhatHanhs() {
        log.debug("REST request to get all MauPhatHanhs");
        return mauPhatHanhService.findAll();
    }

    /**
     * GET  /mau-phat-hanhs/:id : get the "id" mauPhatHanh.
     *
     * @param id the id of the mauPhatHanhDTO to retrieve
     * @return the ResponseEntity with status 200 (OK) and with body the mauPhatHanhDTO, or with status 404 (Not Found)
     */
    @GetMapping("/mau-phat-hanhs/{id}")
    public ResponseEntity<MauPhatHanhDTO> getMauPhatHanh(@PathVariable String id) {
        log.debug("REST request to get MauPhatHanh : {}", id);
        Optional<MauPhatHanhDTO> mauPhatHanhDTO = mauPhatHanhService.findOne(id);
        return ResponseUtil.wrapOrNotFound(mauPhatHanhDTO);
    }

    /**
     * DELETE  /mau-phat-hanhs/:id : delete the "id" mauPhatHanh.
     *
     * @param id the id of the mauPhatHanhDTO to delete
     * @return the ResponseEntity with status 200 (OK)
     */
    @DeleteMapping("/mau-phat-hanhs/{id}")
    public ResponseEntity<Void> deleteMauPhatHanh(@PathVariable String id) {
        log.debug("REST request to delete MauPhatHanh : {}", id);
        mauPhatHanhService.delete(id);
        return ResponseEntity.ok().headers(HeaderUtil.createEntityDeletionAlert(ENTITY_NAME, id)).build();
    }
}
