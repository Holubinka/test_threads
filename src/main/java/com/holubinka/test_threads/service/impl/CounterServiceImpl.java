package com.holubinka.test_threads.service.impl;

import com.holubinka.test_threads.dao.CounterInformationDao;
import com.holubinka.test_threads.model.CounterInformation;
import com.holubinka.test_threads.service.CounterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;

@Service
public class CounterServiceImpl implements CounterService {

    @Autowired
    private CounterInformationDao counterInformationDao;

    private final AtomicReference<Integer> counter = new AtomicReference<>(50);
    private final AtomicBoolean limitReached = new AtomicBoolean(false);

    @Override
    public synchronized void increment() {
        if (limitReached.get()) {
            return;
        }
        counter.getAndSet(counter.get() + 1);
        printCurrentCounter(counter.get(), "increment");

        if (counter.get() >= 100) {
            limitReached.set(true);
            counterInformationDao.saveAndFlush(new CounterInformation());
        }
    }

    @Override
    public synchronized void decrement() {
        if (limitReached.get()) {
            return;
        }
        counter.getAndSet(counter.get() - 1);
        printCurrentCounter(counter.get(), "decrement");

        if (counter.get() <= 0) {
            limitReached.set(true);
            counterInformationDao.saveAndFlush(new CounterInformation());
        }
    }

    private synchronized void printCurrentCounter(int counterValue, String operation) {
        System.out.printf("Counter value: %d. Counter was %s by: %s%n", counterValue, operation, Thread.currentThread().getName());
    }

    @Override
    public synchronized boolean isModify() {
        return counter.get() != 0 && counter.get() != 100;
    }

    @Override
    public void setCounterValue(Integer counterValue) {
        counter.set(counterValue);
        limitReached.set(false);

        if (!isModify()) {
            counterInformationDao.saveAndFlush(new CounterInformation());
        }
    }
}
