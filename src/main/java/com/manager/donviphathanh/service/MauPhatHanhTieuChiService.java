package com.manager.donviphathanh.service;

import com.manager.donviphathanh.service.dto.MauPhatHanhTieuChiDTO;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

/**
 * Service Interface for managing MauPhatHanhTieuChi.
 */
public interface MauPhatHanhTieuChiService {

    /**
     * Save a mauPhatHanhTieuChi.
     *
     * @param mauPhatHanhTieuChiDTO the entity to save
     * @return the persisted entity
     */
    MauPhatHanhTieuChiDTO save(MauPhatHanhTieuChiDTO mauPhatHanhTieuChiDTO);

    /**
     * Get all the mauPhatHanhTieuChis.
     *
     * @param pageable the pagination information
     * @return the list of entities
     */
    Page<MauPhatHanhTieuChiDTO> findAll(Pageable pageable);


    /**
     * Get the "id" mauPhatHanhTieuChi.
     *
     * @param id the id of the entity
     * @return the entity
     */
    Optional<MauPhatHanhTieuChiDTO> findOne(Long id);

    /**
     * Delete the "id" mauPhatHanhTieuChi.
     *
     * @param id the id of the entity
     */
    void delete(Long id);
}
