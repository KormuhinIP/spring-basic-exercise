package com.mycompany.spring_basic.exercise.entity;


import com.mycompany.spring_basic.exercise.impl.CurrencyRepositoryInMemory;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.concurrent.atomic.AtomicInteger;

public class Currency {
    private final String id;
    private String code;
    private boolean active;

    @Autowired
    CurrencyRepositoryInMemory repository;

    private static final AtomicInteger AUTO_ID = new AtomicInteger(1);
    public Currency(String id) {

        this.id = String.valueOf(AUTO_ID.getAndIncrement());
    }


    public String getId() {
        return id;
    }


    public String getCode() {
        return code;
    }


    public void setCode(String code) {
        this.code = code;
    }


    public boolean isActive() {
        return active;
    }


    public void setActive(boolean active) {
        this.active = active;
    }


    public void remove() {

        repository.remove(this.getId());
        /* throw new RuntimeException("Not implemented yet");*/
    }

}
