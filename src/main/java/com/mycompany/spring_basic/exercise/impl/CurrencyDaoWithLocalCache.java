package com.mycompany.spring_basic.exercise.impl;

import com.mycompany.spring_basic.exercise.api.CurrencyDao;
import com.mycompany.spring_basic.exercise.entity.Currency;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;

public class CurrencyDaoWithLocalCache implements CurrencyDao {

    @Autowired
    CurrencyRepositoryInMemory currencyRepositoryInMemory;

    List<Currency> list = new ArrayList<>();

    @Override
    public List<Currency> getActive() {
        for (Currency currency : currencyRepositoryInMemory.getList()) {
            if (currency.isActive() == true) {
                list.add(currency);
            }
        }
        return list;
    }
}
