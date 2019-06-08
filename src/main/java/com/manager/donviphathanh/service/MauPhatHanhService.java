package com.manager.donviphathanh.service;

import com.manager.donviphathanh.service.dto.CreateMauPhatHanhDTO;
import com.manager.donviphathanh.service.dto.MauPhatHanhDTO;
import com.manager.donviphathanh.service.dto.quytrinhdonvi.DuLieuTienTrinhDTO;

import java.util.List;
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
     * @return the list of entities
     */
    List<MauPhatHanhDTO> findAll();

    /**
     * Get all the mauPhatHanhs.
     *
     * @return the list of entities
     */
    List<MauPhatHanhDTO> findAllBySigned();


    /**
     * Get the "id" mauPhatHanh.
     *
     * @param id the id of the entity
     * @return the entity
     */
    Optional<MauPhatHanhDTO> findOne(String id);

    /**
     * Get the "mauPhatHanhCode" mauPhatHanh.
     *
     * @param mauPhatHanhCode the code of the entity
     * @return the entity
     */
    Optional<MauPhatHanhDTO> findOneByMauPhatHanhCode(String mauPhatHanhCode);

    /**
     * Delete the "id" mauPhatHanh.
     *
     * @param id the id of the entity
     */
    void delete(String id);

    Optional<MauPhatHanhDTO> create(CreateMauPhatHanhDTO createMauPhatHanhDTO);

    Optional<DuLieuTienTrinhDTO> updateQuyTrinh(String mauPhatHanhCode, DuLieuTienTrinhDTO duLieuTienTrinh);


}
