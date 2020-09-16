/*
 * (c) Copyright 2020 sothawo
 */
package com.sothawo.springdatamongodblocaldate;

import org.springframework.data.mongodb.repository.MongoRepository;

/**
 * @author P.J. Meisch (pj.meisch@sothawo.com)
 */
public interface PersonRepository extends MongoRepository<Person, String> {
}
