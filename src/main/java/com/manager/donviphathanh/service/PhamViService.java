package com.manager.donviphathanh.service;

import com.manager.donviphathanh.domain.PhamVi;
import com.manager.donviphathanh.repository.PhamViRepository;
import com.manager.donviphathanh.service.dto.PhamViDTO;
import com.manager.donviphathanh.service.mapper.PhamViMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

/**
 * Service Implementation for managing PhamVi.
 */
@Service
@Transactional
public class PhamViService {

    private final Logger log = LoggerFactory.getLogger(PhamViService.class);

    private final PhamViRepository phamViRepository;

    private final PhamViMapper phamViMapper;

    public PhamViService(PhamViRepository phamViRepository, PhamViMapper phamViMapper) {
        this.phamViRepository = phamViRepository;
        this.phamViMapper = phamViMapper;
    }

    /**
     * Save a phamVi.
     *
     * @param phamViDTO the entity to save
     * @return the persisted entity
     */
    public PhamViDTO save(PhamViDTO phamViDTO) {
        log.debug("Request to save PhamVi : {}", phamViDTO);
        PhamVi phamVi = phamViMapper.toEntity(phamViDTO);
        phamVi = phamViRepository.save(phamVi);
        return phamViMapper.toDto(phamVi);
    }

    /**
     * Get all the phamVis.
     *
     * @param pageable the pagination information
     * @return the list of entities
     */
    @Transactional(readOnly = true)
    public Page<PhamViDTO> findAll(Pageable pageable) {
        log.debug("Request to get all PhamVis");
        return phamViRepository.findAll(pageable)
            .map(phamViMapper::toDto);
    }


    /**
     * Get one phamVi by id.
     *
     * @param id the id of the entity
     * @return the entity
     */
    @Transactional(readOnly = true)
    public Optional<PhamViDTO> findOne(Long id) {
        log.debug("Request to get PhamVi : {}", id);
        return phamViRepository.findById(id)
            .map(phamViMapper::toDto);
    }

    /**
     * Delete the phamVi by id.
     *
     * @param id the id of the entity
     */
    public void delete(Long id) {
        log.debug("Request to delete PhamVi : {}", id);
        phamViRepository.deleteById(id);
    }
}
