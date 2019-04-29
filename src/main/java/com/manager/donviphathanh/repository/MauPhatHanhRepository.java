package com.manager.donviphathanh.repository;

import com.manager.donviphathanh.domain.MauPhatHanh;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;


/**
 * Spring Data MongoDB repository for the MauPhatHanh entity.
 */
@SuppressWarnings("unused")
@Repository
public interface MauPhatHanhRepository extends MongoRepository<MauPhatHanh, String> {

}
