package com.mycompany.spring_basic.exercise.impl;

import com.mycompany.spring_basic.exercise.api.CurrencyRepository;
import com.mycompany.spring_basic.exercise.entity.Currency;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;

import java.util.ArrayList;
import java.util.List;


public class CurrencyRepositoryInMemory implements CurrencyRepository {

    @Autowired
    ApplicationContext context;
    private List<Currency> list = new ArrayList<>();

    public List<Currency> getList() {
        return list;
    }

    @Override
    public Currency create(String symbol, boolean active) {

        Currency currency = context.getBean(Currency.class);
        currency.setActive(active);
        currency.setCode(symbol);
        list.add(currency);
        return currency;
    }


    @Override
    public List<Currency> find(boolean active) {
        for (Currency currency : list) {
            System.out.println(currency.getId());
        }
        return list;
    }

    @Override
    public void remove(String currencyId) {

    }
}
