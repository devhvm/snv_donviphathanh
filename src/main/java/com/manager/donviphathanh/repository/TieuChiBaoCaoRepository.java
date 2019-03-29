package com.manager.donviphathanh.repository;

import com.manager.donviphathanh.domain.TieuChiBaoCao;
import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.Repository;


/**
 * Spring Data  repository for the TieuChiBaoCao entity.
 */
@SuppressWarnings("unused")
@Repository
public interface TieuChiBaoCaoRepository extends JpaRepository<TieuChiBaoCao, Long> {

}
