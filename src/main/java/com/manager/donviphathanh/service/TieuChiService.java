package com.manager.donviphathanh.service;

import com.manager.donviphathanh.service.dto.TieuChiDTO;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

/**
 * Service Interface for managing TieuChi.
 */
public interface TieuChiService {

    /**
     * Save a tieuChi.
     *
     * @param tieuChiDTO the entity to save
     * @return the persisted entity
     */
    TieuChiDTO save(TieuChiDTO tieuChiDTO);

    /**
     * Get all the tieuChis.
     *
     * @param pageable the pagination information
     * @return the list of entities
     */
    Page<TieuChiDTO> findAll(Pageable pageable);


    /**
     * Get the "id" tieuChi.
     *
     * @param id the id of the entity
     * @return the entity
     */
    Optional<TieuChiDTO> findOne(Long id);

    /**
     * Delete the "id" tieuChi.
     *
     * @param id the id of the entity
     */
    void delete(Long id);
}
