package com.manager.donviphathanh.service;

import com.manager.donviphathanh.service.dto.MauPhatHanhDTO;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

/**
 * Service Interface for managing MauPhatHanh.
 */
public interface MauPhatHanhService {

    /**
     * Save a mauPhatHanh.
     *
     * @param mauPhatHanhDTO the entity to save
     * @return the persisted entity
     */
    MauPhatHanhDTO save(MauPhatHanhDTO mauPhatHanhDTO);

    /**
     * Get all the mauPhatHanhs.
     *
     * @param pageable the pagination information
     * @return the list of entities
     */
    Page<MauPhatHanhDTO> findAll(Pageable pageable);


    /**
     * Get the "id" mauPhatHanh.
     *
     * @param id the id of the entity
     * @return the entity
     */
    Optional<MauPhatHanhDTO> findOne(Long id);

    /**
     * Delete the "id" mauPhatHanh.
     *
     * @param id the id of the entity
     */
    void delete(Long id);
}
