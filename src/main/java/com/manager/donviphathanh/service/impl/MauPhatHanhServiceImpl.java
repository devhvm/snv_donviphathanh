package com.manager.donviphathanh.service.impl;

import com.manager.donviphathanh.client.CommonServiceClient;
import com.manager.donviphathanh.client.QuyTrinhDonViServiceClient;
import com.manager.donviphathanh.domain.DuLieuTienTrinh;
import com.manager.donviphathanh.domain.MauPhatHanh;
import com.manager.donviphathanh.repository.MauPhatHanhRepository;
import com.manager.donviphathanh.security.SecurityUtils;
import com.manager.donviphathanh.service.MauPhatHanhService;
import com.manager.donviphathanh.service.dto.CreateMauPhatHanhDTO;
import com.manager.donviphathanh.service.dto.MauPhatHanhDTO;
import com.manager.donviphathanh.service.dto.common.coquanchutri.TieuChiDetailDTO;
import com.manager.donviphathanh.service.dto.common.loaibaocao.LoaiBaoCaoDTO;
import com.manager.donviphathanh.service.dto.common.loaibaocao.PhamViDetailDTO;
import com.manager.donviphathanh.service.dto.quytrinhdonvi.DuLieuTienTrinhDTO;
import com.manager.donviphathanh.service.mapper.DuLieuTienTrinhMapper;
import com.manager.donviphathanh.service.mapper.MauPhatHanhMapper;
import com.manager.donviphathanh.web.rest.errors.ResourceNotFoundException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.net.URISyntaxException;
import java.util.LinkedList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * Service Implementation for managing MauPhatHanh.
 */
@Service
public class MauPhatHanhServiceImpl implements MauPhatHanhService {

    private final Logger log = LoggerFactory.getLogger(MauPhatHanhServiceImpl.class);
    private final MauPhatHanhRepository mauPhatHanhRepository;
    private final MauPhatHanhMapper mauPhatHanhMapper;
    @Autowired
    @Qualifier("common")
    CommonServiceClient commonServiceClient;
    @Autowired
    @Qualifier("quytrinhdonvi")
    QuyTrinhDonViServiceClient quyTrinhDonViServiceClient;
    @Autowired
    DuLieuTienTrinhMapper duLieuTienTrinhMapper;

    public MauPhatHanhServiceImpl(MauPhatHanhRepository mauPhatHanhRepository, MauPhatHanhMapper mauPhatHanhMapper) {
        this.mauPhatHanhRepository = mauPhatHanhRepository;
        this.mauPhatHanhMapper = mauPhatHanhMapper;
    }

    /**
     * create a mauPhatHanh.
     *
     * @param createMauPhatHanhDTO the entity to save
     * @return the persisted entity
     */
    @Transactional
    @Override
    public Optional<MauPhatHanhDTO> create(CreateMauPhatHanhDTO createMauPhatHanhDTO) {
        log.debug("Request to save createMauPhatHanhDTO : {}", createMauPhatHanhDTO);


        Optional<MauPhatHanhDTO> mauPH = findOneByMauPhatHanhCode(createMauPhatHanhDTO.getMaMauPhatHanh());

        if (mauPH.isPresent()) {
            throw new RuntimeException("Ma Mau da ton tai");
        }

        List<TieuChiDetailDTO> tieuChiDetailDTOList;
        //call api common create
        tieuChiDetailDTOList = commonServiceClient.getTieuChisByCoQuanChuTriID(createMauPhatHanhDTO.getIdCoQuanChuTri().longValue());

        if (Objects.isNull(tieuChiDetailDTOList) || tieuChiDetailDTOList.isEmpty()) {
            throw new ResourceNotFoundException("Không tồn tại danh sách tiêu chi của CQTT này");
        }
        DuLieuTienTrinhDTO duLieuTienTrinhDTO = new DuLieuTienTrinhDTO(createMauPhatHanhDTO.getTenMauPhatHanh(), createMauPhatHanhDTO.getTienTrinhCode(), createMauPhatHanhDTO.getMaMauPhatHanh(), SecurityUtils.getCurrentUserLogin().get(), "", createMauPhatHanhDTO.getNote(), createMauPhatHanhDTO.getQuyTrinhDonViId(), createMauPhatHanhDTO.getQuyTrinhDonViName(), createMauPhatHanhDTO.getStatus());

        try {
            //call API thêm quy trình
            quyTrinhDonViServiceClient.createDuLieuTienTrinh(duLieuTienTrinhDTO);
        } catch (URISyntaxException e) {
            throw new RuntimeException("Khong tao duoc quy trinh");
        }


        LoaiBaoCaoDTO loaiBaoCaoDTO = commonServiceClient.getLoaiBaoCao(1l);
        loaiBaoCaoDTO.getDonViTinh().setPhamvi(new PhamViDetailDTO(createMauPhatHanhDTO.getMin(), createMauPhatHanhDTO.getMax()));

        MauPhatHanhDTO mauPhatHanhDTO = MauPhatHanhDTO.of(createMauPhatHanhDTO, loaiBaoCaoDTO, tieuChiDetailDTOList);

        MauPhatHanh mauPhatHanh = mauPhatHanhMapper.toEntity(mauPhatHanhDTO);

        DuLieuTienTrinh duLieuTienTrinh = duLieuTienTrinhMapper.toEntity(duLieuTienTrinhDTO);

        mauPhatHanh.getDuLieuTienTrinhs().add(duLieuTienTrinh);
        mauPhatHanh.setStatus(duLieuTienTrinh.getStatus());

        mauPhatHanh = mauPhatHanhRepository.save(mauPhatHanh);



        return Optional.of(mauPhatHanhMapper.toDto(mauPhatHanh));
    }

    @Override
    public Optional<DuLieuTienTrinhDTO> updateQuyTrinh(String mauPhatHanhCode, DuLieuTienTrinhDTO duLieuTienTrinhDTO) {
        Optional<MauPhatHanh> mauPhatHanhOptional = mauPhatHanhRepository.findByMauPhatHanhCode(mauPhatHanhCode);
        if (!mauPhatHanhOptional.isPresent()) throw new ResourceNotFoundException("Mau phat hanh khong ton tai.");

        MauPhatHanh mauPhatHanh = mauPhatHanhOptional.get();

        DuLieuTienTrinh duLieuTienTrinh = duLieuTienTrinhMapper.toEntity(duLieuTienTrinhDTO);

        mauPhatHanh.getDuLieuTienTrinhs().add(duLieuTienTrinh);
        mauPhatHanh.setStatus(duLieuTienTrinh.getStatus());
        mauPhatHanhRepository.save(mauPhatHanh);

        return Optional.of(duLieuTienTrinhMapper.toDto(duLieuTienTrinh));
    }


    /**
     * Save a mauPhatHanh.
     *
     * @param mauPhatHanhDTO the entity to save
     * @return the persisted entity
     */
    @Override
    public MauPhatHanhDTO save(MauPhatHanhDTO mauPhatHanhDTO) {
        log.debug("Request to save MauPhatHanh : {}", mauPhatHanhDTO);
        MauPhatHanh mauPhatHanh = mauPhatHanhMapper.toEntity(mauPhatHanhDTO);
        mauPhatHanh = mauPhatHanhRepository.save(mauPhatHanh);
        return mauPhatHanhMapper.toDto(mauPhatHanh);
    }

    /**
     * Get all the mauPhatHanhs.
     *
     * @return the list of entities
     */
    @Override
    public List<MauPhatHanhDTO> findAll() {
        log.debug("Request to get all MauPhatHanhs");
        return mauPhatHanhRepository.findAll().stream()
            .map(mauPhatHanhMapper::toDto)
            .collect(Collectors.toCollection(LinkedList::new));
    }


    /**
     * Get one mauPhatHanh by id.
     *
     * @param id the id of the entity
     * @return the entity
     */
    @Override
    public Optional<MauPhatHanhDTO> findOne(String id) {
        log.debug("Request to get MauPhatHanh : {}", id);
        return mauPhatHanhRepository.findById(id)
            .map(mauPhatHanhMapper::toDto);
    }

    /**
     * Get one mauPhatHanh by mauPhatHanhCode.
     *
     * @param mauPhatHanhCode the code of the entity
     * @return the entity
     */
    @Override
    public Optional<MauPhatHanhDTO> findOneByMauPhatHanhCode(String mauPhatHanhCode) {
        log.debug("Request to get MauPhatHanh : {}", mauPhatHanhCode);

        return mauPhatHanhRepository.findByMauPhatHanhCode(mauPhatHanhCode)
            .map(mauPhatHanhMapper::toDto);
    }

    /**
     * Delete the mauPhatHanh by mauPhatHanhCode.
     *
     * @param mauPhatHanhCode the id of the entity
     */
    @Override
    public void delete(String mauPhatHanhCode) {
        log.debug("Request to delete MauPhatHanh : {}", mauPhatHanhCode);
        mauPhatHanhRepository.deleteByMauPhatHanhCode(mauPhatHanhCode);
    }
}
