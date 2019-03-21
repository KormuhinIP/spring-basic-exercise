package com.mycompany.spring_basic.exercise.impl;

import com.mycompany.spring_basic.exercise.api.CurrencyRepository;
import com.mycompany.spring_basic.exercise.entity.Currency;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;

import java.util.Iterator;
import java.util.List;


public class CurrencyRepositoryInMemory implements CurrencyRepository {

    @Autowired
    ApplicationContext context;

    private List<Currency> listCurrency;
    private List<Currency> listActive;

    public void setListCurrency(List<Currency> listCurrency) {
        this.listCurrency = listCurrency;
    }

    public void setListActive(List<Currency> listActive) {
        this.listActive = listActive;
    }


    @Override
    public Currency create(String symbol, boolean active) {
        Currency currency = context.getBean(Currency.class);
        currency.setActive(active);
        currency.setCode(symbol);
        listCurrency.add(currency);
        return currency;
    }

    @Override
    public List<Currency> find(boolean active) {
        listActive.clear();
        for (Currency currency : listCurrency) {
            if (currency.isActive() == active)
                listActive.add(currency);
        }

        return listActive;
    }

    @Override
    public void remove(String currencyId) {
        Iterator<Currency> currencyIterator = listCurrency.iterator();
        while (currencyIterator.hasNext()) {
            if (currencyIterator.next().getId().equals(currencyId))
                currencyIterator.remove();
        }
    }
    }

