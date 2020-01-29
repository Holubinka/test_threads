package com.holubinka.test_threads.service;

public interface CounterService {

    void setCounterValue(Integer counterValue);

    void increment();

    void decrement();

    boolean isModify();
}
