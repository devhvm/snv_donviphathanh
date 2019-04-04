package com.manager.donviphathanh.service;

import com.manager.donviphathanh.domain.MauPhatHanh;
import com.manager.donviphathanh.repository.MauPhatHanhRepository;
import com.manager.donviphathanh.service.dto.MauPhatHanhDTO;
import com.manager.donviphathanh.service.mapper.MauPhatHanhMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

/**
 * Service Implementation for managing MauPhatHanh.
 */
@Service
@Transactional
public class MauPhatHanhService {

    private final Logger log = LoggerFactory.getLogger(MauPhatHanhService.class);

    private final MauPhatHanhRepository mauPhatHanhRepository;

    private final MauPhatHanhMapper mauPhatHanhMapper;

    public MauPhatHanhService(MauPhatHanhRepository mauPhatHanhRepository, MauPhatHanhMapper mauPhatHanhMapper) {
        this.mauPhatHanhRepository = mauPhatHanhRepository;
        this.mauPhatHanhMapper = mauPhatHanhMapper;
    }

    /**
     * Save a mauPhatHanh.
     *
     * @param mauPhatHanhDTO the entity to save
     * @return the persisted entity
     */
    public MauPhatHanhDTO save(MauPhatHanhDTO mauPhatHanhDTO) {
        log.debug("Request to save MauPhatHanh : {}", mauPhatHanhDTO);
        MauPhatHanh mauPhatHanh = mauPhatHanhMapper.toEntity(mauPhatHanhDTO);
        mauPhatHanh = mauPhatHanhRepository.save(mauPhatHanh);
        return mauPhatHanhMapper.toDto(mauPhatHanh);
    }

    /**
     * Get all the mauPhatHanhs.
     *
     * @param pageable the pagination information
     * @return the list of entities
     */
    @Transactional(readOnly = true)
    public Page<MauPhatHanhDTO> findAll(Pageable pageable) {
        log.debug("Request to get all MauPhatHanhs");
        return mauPhatHanhRepository.findAll(pageable)
            .map(mauPhatHanhMapper::toDto);
    }


    /**
     * Get one mauPhatHanh by id.
     *
     * @param id the id of the entity
     * @return the entity
     */
    @Transactional(readOnly = true)
    public Optional<MauPhatHanhDTO> findOne(Long id) {
        log.debug("Request to get MauPhatHanh : {}", id);
        return mauPhatHanhRepository.findById(id)
            .map(mauPhatHanhMapper::toDto);
    }

    /**
     * Delete the mauPhatHanh by id.
     *
     * @param id the id of the entity
     */
    public void delete(Long id) {
        log.debug("Request to delete MauPhatHanh : {}", id);
        mauPhatHanhRepository.deleteById(id);
    }
}
