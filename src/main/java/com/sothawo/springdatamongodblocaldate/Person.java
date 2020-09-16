/*
 * (c) Copyright 2020 sothawo
 */
package com.sothawo.springdatamongodblocaldate;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDate;

/**
 * @author P.J. Meisch (pj.meisch@sothawo.com)
 */
@Document("persons")
public class Person {
    @Id String id;
    private String name;
    private LocalDate birthday;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDate getBirthday() {
        return birthday;
    }

    public void setBirthday(LocalDate birthday) {
        this.birthday = birthday;
    }

    @Override
    public String toString() {
        return "Person{" +
            "id='" + id + '\'' +
            ", name='" + name + '\'' +
            ", birthday=" + birthday +
            '}';
    }
}
