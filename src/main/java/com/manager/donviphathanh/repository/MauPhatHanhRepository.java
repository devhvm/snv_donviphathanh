package com.manager.donviphathanh.repository;

import com.manager.donviphathanh.domain.MauPhatHanh;
import com.manager.donviphathanh.domain.enumeration.Status;
import org.springframework.data.mongodb.repository.DeleteQuery;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;


/**
 * Spring Data MongoDB repository for the MauPhatHanh entity.
 */
@SuppressWarnings("unused")
@Repository
public interface MauPhatHanhRepository extends MongoRepository<MauPhatHanh, String>, MauPhatHanhRepositoryCustom {

    Optional<MauPhatHanh> findByMauPhatHanhCode(String mauPhatHanhCode);

    @DeleteQuery
    void deleteByMauPhatHanhCode(String mauPhatHanhCode);
    @Query(fields="{mauPhatHanhCode : 1}")
    List<MauPhatHanh> findAllByStatus(Status status);

}
