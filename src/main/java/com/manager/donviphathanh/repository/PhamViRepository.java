package com.manager.donviphathanh.repository;

import com.manager.donviphathanh.domain.PhamVi;
import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.Repository;


/**
 * Spring Data  repository for the PhamVi entity.
 */
@SuppressWarnings("unused")
@Repository
public interface PhamViRepository extends JpaRepository<PhamVi, Long> {

}
