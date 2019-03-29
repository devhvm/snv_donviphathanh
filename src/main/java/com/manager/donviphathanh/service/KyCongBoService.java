package com.manager.donviphathanh.service;

import com.manager.donviphathanh.service.dto.KyCongBoDTO;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

/**
 * Service Interface for managing KyCongBo.
 */
public interface KyCongBoService {

    /**
     * Save a kyCongBo.
     *
     * @param kyCongBoDTO the entity to save
     * @return the persisted entity
     */
    KyCongBoDTO save(KyCongBoDTO kyCongBoDTO);

    /**
     * Get all the kyCongBos.
     *
     * @param pageable the pagination information
     * @return the list of entities
     */
    Page<KyCongBoDTO> findAll(Pageable pageable);


    /**
     * Get the "id" kyCongBo.
     *
     * @param id the id of the entity
     * @return the entity
     */
    Optional<KyCongBoDTO> findOne(Long id);

    /**
     * Delete the "id" kyCongBo.
     *
     * @param id the id of the entity
     */
    void delete(Long id);
}
