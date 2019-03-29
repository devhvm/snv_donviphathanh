package com.manager.donviphathanh.service;

import com.manager.donviphathanh.service.dto.TieuChiBaoCaoDTO;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

/**
 * Service Interface for managing TieuChiBaoCao.
 */
public interface TieuChiBaoCaoService {

    /**
     * Save a tieuChiBaoCao.
     *
     * @param tieuChiBaoCaoDTO the entity to save
     * @return the persisted entity
     */
    TieuChiBaoCaoDTO save(TieuChiBaoCaoDTO tieuChiBaoCaoDTO);

    /**
     * Get all the tieuChiBaoCaos.
     *
     * @param pageable the pagination information
     * @return the list of entities
     */
    Page<TieuChiBaoCaoDTO> findAll(Pageable pageable);


    /**
     * Get the "id" tieuChiBaoCao.
     *
     * @param id the id of the entity
     * @return the entity
     */
    Optional<TieuChiBaoCaoDTO> findOne(Long id);

    /**
     * Delete the "id" tieuChiBaoCao.
     *
     * @param id the id of the entity
     */
    void delete(Long id);
}
