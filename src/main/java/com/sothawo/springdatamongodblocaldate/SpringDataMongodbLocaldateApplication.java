package com.sothawo.springdatamongodblocaldate;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;
import org.testcontainers.containers.MongoDBContainer;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

@SpringBootApplication
@EnableMongoRepositories
public class SpringDataMongodbLocaldateApplication {

    static private final Logger LOG = LoggerFactory.getLogger(SpringDataMongodbLocaldateApplication.class);

    private MongoDBContainer mongoDBContainer;

    public static void main(String[] args) {
        SpringApplication.run(SpringDataMongodbLocaldateApplication.class, args);
    }

    @PostConstruct
    void startup() {
        LOG.info("startup method…");
        mongoDBContainer = new MongoDBContainer("mongo:4.2.9");
        mongoDBContainer.start();
    }

    @PreDestroy
    void shutdown() {
        LOG.info("shutting down…");
        mongoDBContainer.close();
    }

    @Bean
    public MongoClient mongoClient() {
        return MongoClients.create("mongodb://" + mongoDBContainer.getHost() + ':' + mongoDBContainer.getMappedPort(27017));
    }

}
