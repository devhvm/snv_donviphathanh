package com.manager.donviphathanh.service.impl;

import com.manager.donviphathanh.service.TieuChiBaoCaoService;
import com.manager.donviphathanh.domain.TieuChiBaoCao;
import com.manager.donviphathanh.repository.TieuChiBaoCaoRepository;
import com.manager.donviphathanh.service.dto.TieuChiBaoCaoDTO;
import com.manager.donviphathanh.service.mapper.TieuChiBaoCaoMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

/**
 * Service Implementation for managing TieuChiBaoCao.
 */
@Service
@Transactional
public class TieuChiBaoCaoServiceImpl implements TieuChiBaoCaoService {

    private final Logger log = LoggerFactory.getLogger(TieuChiBaoCaoServiceImpl.class);

    private final TieuChiBaoCaoRepository tieuChiBaoCaoRepository;

    private final TieuChiBaoCaoMapper tieuChiBaoCaoMapper;

    public TieuChiBaoCaoServiceImpl(TieuChiBaoCaoRepository tieuChiBaoCaoRepository, TieuChiBaoCaoMapper tieuChiBaoCaoMapper) {
        this.tieuChiBaoCaoRepository = tieuChiBaoCaoRepository;
        this.tieuChiBaoCaoMapper = tieuChiBaoCaoMapper;
    }

    /**
     * Save a tieuChiBaoCao.
     *
     * @param tieuChiBaoCaoDTO the entity to save
     * @return the persisted entity
     */
    @Override
    public TieuChiBaoCaoDTO save(TieuChiBaoCaoDTO tieuChiBaoCaoDTO) {
        log.debug("Request to save TieuChiBaoCao : {}", tieuChiBaoCaoDTO);
        TieuChiBaoCao tieuChiBaoCao = tieuChiBaoCaoMapper.toEntity(tieuChiBaoCaoDTO);
        tieuChiBaoCao = tieuChiBaoCaoRepository.save(tieuChiBaoCao);
        return tieuChiBaoCaoMapper.toDto(tieuChiBaoCao);
    }

    /**
     * Get all the tieuChiBaoCaos.
     *
     * @param pageable the pagination information
     * @return the list of entities
     */
    @Override
    @Transactional(readOnly = true)
    public Page<TieuChiBaoCaoDTO> findAll(Pageable pageable) {
        log.debug("Request to get all TieuChiBaoCaos");
        return tieuChiBaoCaoRepository.findAll(pageable)
            .map(tieuChiBaoCaoMapper::toDto);
    }


    /**
     * Get one tieuChiBaoCao by id.
     *
     * @param id the id of the entity
     * @return the entity
     */
    @Override
    @Transactional(readOnly = true)
    public Optional<TieuChiBaoCaoDTO> findOne(Long id) {
        log.debug("Request to get TieuChiBaoCao : {}", id);
        return tieuChiBaoCaoRepository.findById(id)
            .map(tieuChiBaoCaoMapper::toDto);
    }

    /**
     * Delete the tieuChiBaoCao by id.
     *
     * @param id the id of the entity
     */
    @Override
    public void delete(Long id) {
        log.debug("Request to delete TieuChiBaoCao : {}", id);        tieuChiBaoCaoRepository.deleteById(id);
    }
}
