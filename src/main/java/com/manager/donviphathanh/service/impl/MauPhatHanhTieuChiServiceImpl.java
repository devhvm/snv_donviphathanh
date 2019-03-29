package com.manager.donviphathanh.service.impl;

import com.manager.donviphathanh.service.MauPhatHanhTieuChiService;
import com.manager.donviphathanh.domain.MauPhatHanhTieuChi;
import com.manager.donviphathanh.repository.MauPhatHanhTieuChiRepository;
import com.manager.donviphathanh.service.dto.MauPhatHanhTieuChiDTO;
import com.manager.donviphathanh.service.mapper.MauPhatHanhTieuChiMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

/**
 * Service Implementation for managing MauPhatHanhTieuChi.
 */
@Service
@Transactional
public class MauPhatHanhTieuChiServiceImpl implements MauPhatHanhTieuChiService {

    private final Logger log = LoggerFactory.getLogger(MauPhatHanhTieuChiServiceImpl.class);

    private final MauPhatHanhTieuChiRepository mauPhatHanhTieuChiRepository;

    private final MauPhatHanhTieuChiMapper mauPhatHanhTieuChiMapper;

    public MauPhatHanhTieuChiServiceImpl(MauPhatHanhTieuChiRepository mauPhatHanhTieuChiRepository, MauPhatHanhTieuChiMapper mauPhatHanhTieuChiMapper) {
        this.mauPhatHanhTieuChiRepository = mauPhatHanhTieuChiRepository;
        this.mauPhatHanhTieuChiMapper = mauPhatHanhTieuChiMapper;
    }

    /**
     * Save a mauPhatHanhTieuChi.
     *
     * @param mauPhatHanhTieuChiDTO the entity to save
     * @return the persisted entity
     */
    @Override
    public MauPhatHanhTieuChiDTO save(MauPhatHanhTieuChiDTO mauPhatHanhTieuChiDTO) {
        log.debug("Request to save MauPhatHanhTieuChi : {}", mauPhatHanhTieuChiDTO);
        MauPhatHanhTieuChi mauPhatHanhTieuChi = mauPhatHanhTieuChiMapper.toEntity(mauPhatHanhTieuChiDTO);
        mauPhatHanhTieuChi = mauPhatHanhTieuChiRepository.save(mauPhatHanhTieuChi);
        return mauPhatHanhTieuChiMapper.toDto(mauPhatHanhTieuChi);
    }

    /**
     * Get all the mauPhatHanhTieuChis.
     *
     * @param pageable the pagination information
     * @return the list of entities
     */
    @Override
    @Transactional(readOnly = true)
    public Page<MauPhatHanhTieuChiDTO> findAll(Pageable pageable) {
        log.debug("Request to get all MauPhatHanhTieuChis");
        return mauPhatHanhTieuChiRepository.findAll(pageable)
            .map(mauPhatHanhTieuChiMapper::toDto);
    }


    /**
     * Get one mauPhatHanhTieuChi by id.
     *
     * @param id the id of the entity
     * @return the entity
     */
    @Override
    @Transactional(readOnly = true)
    public Optional<MauPhatHanhTieuChiDTO> findOne(Long id) {
        log.debug("Request to get MauPhatHanhTieuChi : {}", id);
        return mauPhatHanhTieuChiRepository.findById(id)
            .map(mauPhatHanhTieuChiMapper::toDto);
    }

    /**
     * Delete the mauPhatHanhTieuChi by id.
     *
     * @param id the id of the entity
     */
    @Override
    public void delete(Long id) {
        log.debug("Request to delete MauPhatHanhTieuChi : {}", id);        mauPhatHanhTieuChiRepository.deleteById(id);
    }
}
