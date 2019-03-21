package com.mycompany.spring_basic.exercise.impl;

import com.mycompany.spring_basic.exercise.api.CurrencyDao;
import com.mycompany.spring_basic.exercise.entity.Currency;

import java.util.ArrayList;
import java.util.List;

public class CurrencyDaoWithLocalCache implements CurrencyDao {


    private List<Currency> listActive;

    public void setListActive(List<Currency> listActive) {
        this.listActive = new ArrayList<>(listActive);
    }

    @Override
    public List<Currency> getActive() {
        return listActive;
    }
}
