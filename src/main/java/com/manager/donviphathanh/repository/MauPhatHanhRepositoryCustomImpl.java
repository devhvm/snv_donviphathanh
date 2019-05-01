package com.manager.donviphathanh.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;

public class MauPhatHanhRepositoryCustomImpl implements MauPhatHanhRepositoryCustom {
    @Autowired
    MongoTemplate mongoTemplate;


}
