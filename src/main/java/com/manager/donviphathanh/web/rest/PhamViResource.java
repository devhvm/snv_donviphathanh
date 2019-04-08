package com.manager.donviphathanh.web.rest;
import com.manager.donviphathanh.service.PhamViService;
import com.manager.donviphathanh.web.rest.errors.BadRequestAlertException;
import com.manager.donviphathanh.web.rest.util.HeaderUtil;
import com.manager.donviphathanh.web.rest.util.PaginationUtil;
import com.manager.donviphathanh.service.dto.PhamViDTO;
import io.github.jhipster.web.util.ResponseUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.net.URI;
import java.net.URISyntaxException;

import java.util.List;
import java.util.Optional;

/**
 * REST controller for managing PhamVi.
 */
@RestController
@RequestMapping("/api")
public class PhamViResource {

    private final Logger log = LoggerFactory.getLogger(PhamViResource.class);

    private static final String ENTITY_NAME = "donviphathanhPhamVi";

    private final PhamViService phamViService;

    public PhamViResource(PhamViService phamViService) {
        this.phamViService = phamViService;
    }

    /**
     * POST  /pham-vis : Create a new phamVi.
     *
     * @param phamViDTO the phamViDTO to create
     * @return the ResponseEntity with status 201 (Created) and with body the new phamViDTO, or with status 400 (Bad Request) if the phamVi has already an ID
     * @throws URISyntaxException if the Location URI syntax is incorrect
     */
    @PostMapping("/pham-vis")
    public ResponseEntity<PhamViDTO> createPhamVi(@Valid @RequestBody PhamViDTO phamViDTO) throws URISyntaxException {
        log.debug("REST request to save PhamVi : {}", phamViDTO);
        if (phamViDTO.getId() != null) {
            throw new BadRequestAlertException("A new phamVi cannot already have an ID", ENTITY_NAME, "idexists");
        }
        PhamViDTO result = phamViService.save(phamViDTO);
        return ResponseEntity.created(new URI("/api/pham-vis/" + result.getId()))
            .headers(HeaderUtil.createEntityCreationAlert(ENTITY_NAME, result.getId().toString()))
            .body(result);
    }

    /**
     * PUT  /pham-vis : Updates an existing phamVi.
     *
     * @param phamViDTO the phamViDTO to update
     * @return the ResponseEntity with status 200 (OK) and with body the updated phamViDTO,
     * or with status 400 (Bad Request) if the phamViDTO is not valid,
     * or with status 500 (Internal Server Error) if the phamViDTO couldn't be updated
     * @throws URISyntaxException if the Location URI syntax is incorrect
     */
    @PutMapping("/pham-vis")
    public ResponseEntity<PhamViDTO> updatePhamVi(@Valid @RequestBody PhamViDTO phamViDTO) throws URISyntaxException {
        log.debug("REST request to update PhamVi : {}", phamViDTO);
        if (phamViDTO.getId() == null) {
            throw new BadRequestAlertException("Invalid id", ENTITY_NAME, "idnull");
        }
        PhamViDTO result = phamViService.save(phamViDTO);
        return ResponseEntity.ok()
            .headers(HeaderUtil.createEntityUpdateAlert(ENTITY_NAME, phamViDTO.getId().toString()))
            .body(result);
    }

    /**
     * GET  /pham-vis : get all the phamVis.
     *
     * @param pageable the pagination information
     * @return the ResponseEntity with status 200 (OK) and the list of phamVis in body
     */
    @GetMapping("/pham-vis")
    public ResponseEntity<List<PhamViDTO>> getAllPhamVis(Pageable pageable) {
        log.debug("REST request to get a page of PhamVis");
        Page<PhamViDTO> page = phamViService.findAll(pageable);
        HttpHeaders headers = PaginationUtil.generatePaginationHttpHeaders(page, "/api/pham-vis");
        return ResponseEntity.ok().headers(headers).body(page.getContent());
    }

    /**
     * GET  /pham-vis/:id : get the "id" phamVi.
     *
     * @param id the id of the phamViDTO to retrieve
     * @return the ResponseEntity with status 200 (OK) and with body the phamViDTO, or with status 404 (Not Found)
     */
    @GetMapping("/pham-vis/{id}")
    public ResponseEntity<PhamViDTO> getPhamVi(@PathVariable Long id) {
        log.debug("REST request to get PhamVi : {}", id);
        Optional<PhamViDTO> phamViDTO = phamViService.findOne(id);
        return ResponseUtil.wrapOrNotFound(phamViDTO);
    }

    /**
     * DELETE  /pham-vis/:id : delete the "id" phamVi.
     *
     * @param id the id of the phamViDTO to delete
     * @return the ResponseEntity with status 200 (OK)
     */
    @DeleteMapping("/pham-vis/{id}")
    public ResponseEntity<Void> deletePhamVi(@PathVariable Long id) {
        log.debug("REST request to delete PhamVi : {}", id);
        phamViService.delete(id);
        return ResponseEntity.ok().headers(HeaderUtil.createEntityDeletionAlert(ENTITY_NAME, id.toString())).build();
    }
}
