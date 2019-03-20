package com.mycompany.spring_basic.exercise.entity;


public class Currency {
    private final String id;
    private String code;
    private boolean active;


    public Currency(String id) {
        this.id = id;
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
