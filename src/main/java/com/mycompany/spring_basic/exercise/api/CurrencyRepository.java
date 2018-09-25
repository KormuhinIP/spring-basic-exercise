package com.mycompany.spring_basic.exercise.api;

import com.mycompany.spring_basic.exercise.entity.Currency;

import java.util.List;

public interface CurrencyRepository {

    Currency create(String symbol, boolean active);

    List<Currency> find(boolean active);

    void remove(String currencyId);
    
}
