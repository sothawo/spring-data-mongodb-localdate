/*
 * (c) Copyright 2020 sothawo
 */
package com.sothawo.springdatamongodblocaldate;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.TimeZone;

/**
 * @author P.J. Meisch (pj.meisch@sothawo.com)
 */
@Component
public class Runner implements CommandLineRunner {

    static private final Logger LOG = LoggerFactory.getLogger(Runner.class);

    private final PersonRepository repository;

    public Runner(PersonRepository repository) {
        this.repository = repository;
    }

    @Override
    public void run(String... args) throws Exception {
        LOG.info("Now I should run some code…\n");

        Person margaret = new Person();
        margaret.setId("1");
        margaret.setName("Margaret Hamilton");
        margaret.setBirthday(LocalDate.of(1936, 8, 17));
        LOG.info("This is person 1: " + margaret + '\n');

        LOG.info("Storing person 1 on a machine in Berlin\n");
        TimeZone.setDefault(TimeZone.getTimeZone("Europe/Berlin"));
        repository.save(margaret);

        LOG.info("Retrieving person 1 on a machine in Los Angeles");
        TimeZone.setDefault(TimeZone.getTimeZone("America/Los_Angeles"));
        Person person1 = repository.findById("1").orElseThrow();
        LOG.info("This is person 1: " + person1);
    }
}
