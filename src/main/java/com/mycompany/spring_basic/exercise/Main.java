package com.mycompany.spring_basic.exercise;

import com.mycompany.spring_basic.exercise.api.CurrencyDao;
import com.mycompany.spring_basic.exercise.api.CurrencyRepository;
import com.mycompany.spring_basic.exercise.entity.Currency;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

public class Main {


    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("context.xml");

        CurrencyRepository repository = context.getBean(CurrencyRepository.class);

        repository.create("USD", true);
        Currency eur = repository.create("EUR", true);
        repository.create("RUB", false);



        CurrencyDao dao = context.getBean(CurrencyDao.class);


        checkActiveCurrencyListFromDao(dao);


        eur.remove();

        checkActualActiveCurrencies(repository);


        checkDaoCachedList(dao);


    }


    private static void checkDaoCachedList(CurrencyDao dao) {
        List<Currency> activeCurrenciesAfterRemove = dao.getActive();
        if (activeCurrenciesAfterRemove.size() != 2) {
            throw new RuntimeException("Active currencies should be cached during CurrencyDao constructing");
        }
    }


    private static void checkActiveCurrencyListFromDao(CurrencyDao dao) {
        List<Currency> activeCurrencies = dao.getActive();
        if (activeCurrencies.size() != 2) {
            throw new RuntimeException("Expected two active currencies");
        }
    }


    private static void checkActualActiveCurrencies(CurrencyRepository repository) {
        List<Currency> currencies = repository.find(true);
        if (currencies.size() != 1) {
            throw new RuntimeException("After remove should exist only one USD currency");
        }
    }
}
