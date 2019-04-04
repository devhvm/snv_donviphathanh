package com.manager.donviphathanh.repository;

import com.manager.donviphathanh.domain.TieuChi;
import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.Repository;


/**
 * Spring Data  repository for the TieuChi entity.
 */
@SuppressWarnings("unused")
@Repository
public interface TieuChiRepository extends JpaRepository<TieuChi, Long> {

}
