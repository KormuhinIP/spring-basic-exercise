package com.mycompany.spring_basic.exercise.api;

import com.mycompany.spring_basic.exercise.entity.Currency;

import java.util.List;

public interface CurrencyDao {
    List<Currency> getActive();
}
