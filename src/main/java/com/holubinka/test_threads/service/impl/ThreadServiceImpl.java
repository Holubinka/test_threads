package com.holubinka.test_threads.service.impl;

import com.holubinka.test_threads.service.CounterService;
import com.holubinka.test_threads.service.ThreadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.core.task.TaskExecutor;
import org.springframework.stereotype.Service;

import java.util.Random;


@Service
public class ThreadServiceImpl implements ThreadService {

    private static final Random random = new Random();

    @Autowired
    @Qualifier("maxThreadPoolSize")
    protected TaskExecutor taskExecutor;

    @Autowired
    protected CounterService counterService;

    void delay() {
        try {
            Thread.sleep(random.nextInt(1000) + 1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void createThreads(Integer producerThreads, Integer consumerThreads) {
        for (int i = 0; i < consumerThreads; i++) {
            String name = "consumer_" + i;
            taskExecutor.execute(() -> {
                Thread.currentThread().setName(name);
                while (true) {
                    delay();
                    counterService.decrement();
                }
            });
        }

        for (int i = 0; i < producerThreads; i++) {
            String name = "producer_" + i;
            taskExecutor.execute(() -> {
                Thread.currentThread().setName(name);
                while (true) {
                    delay();
                    counterService.increment();
                }
            });
        }
    }
}
