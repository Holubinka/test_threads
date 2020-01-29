package com.holubinka.test_threads.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.task.TaskExecutor;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

@Configuration
public class CommonConfiguration {

    @Bean("maxThreadPoolSize")
    public TaskExecutor threadPoolTaskExecutor() {
        ThreadPoolTaskExecutor taskExecutor = new ThreadPoolTaskExecutor();
        taskExecutor.setCorePoolSize(Integer.MAX_VALUE);
        taskExecutor.setMaxPoolSize(Integer.MAX_VALUE);
        return taskExecutor;
    }

}
