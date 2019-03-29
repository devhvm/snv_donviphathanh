package com.manager.donviphathanh.repository;

import com.manager.donviphathanh.domain.MauPhatHanhTieuChi;
import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.Repository;


/**
 * Spring Data  repository for the MauPhatHanhTieuChi entity.
 */
@SuppressWarnings("unused")
@Repository
public interface MauPhatHanhTieuChiRepository extends JpaRepository<MauPhatHanhTieuChi, Long> {

}
