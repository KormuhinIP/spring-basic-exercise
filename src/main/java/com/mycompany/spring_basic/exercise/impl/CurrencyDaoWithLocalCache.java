package com.mycompany.spring_basic.exercise.impl;

import com.mycompany.spring_basic.exercise.api.CurrencyDao;
import com.mycompany.spring_basic.exercise.entity.Currency;

import java.util.ArrayList;
import java.util.List;

public class CurrencyDaoWithLocalCache implements CurrencyDao {

    List<Currency> list = new ArrayList<>();

    private List<Currency> listActive;


    public void setListActive(List<Currency> listActive) {
        this.listActive = listActive;
        list.addAll(listActive);

    }



    @Override
    public List<Currency> getActive() {

        return list;
    }
}
