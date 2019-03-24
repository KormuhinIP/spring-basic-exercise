package com.mycompany.spring_basic.exercise.impl;

import com.mycompany.spring_basic.exercise.api.CurrencyDao;
import com.mycompany.spring_basic.exercise.entity.Currency;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.context.annotation.Bean;

import java.util.ArrayList;
import java.util.List;
@Cacheable(cacheNames = "entities")
public class CurrencyDaoWithLocalCache implements CurrencyDao {


    private List<Currency> listActive;

    public void setListActive(List<Currency> listActive) {
        this.listActive = new ArrayList<>(listActive);
    }



    @Override
    public List<Currency> getActive() {
        return  listActive;
    }
}
