package com.mycompany.spring_basic.exercise.entity;


import java.util.concurrent.atomic.AtomicInteger;

public class Currency {
    private final String id;
    private String code;
    private boolean active;

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

        throw new RuntimeException("Not implemented yet");
    }


}
