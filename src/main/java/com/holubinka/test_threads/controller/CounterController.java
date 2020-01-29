package com.holubinka.test_threads.controller;

import com.holubinka.test_threads.service.CounterService;
import com.holubinka.test_threads.service.RequestService;
import com.holubinka.test_threads.service.ThreadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.net.URI;

@RestController
public class CounterController {

    @Autowired
    private ThreadService threadService;
    @Autowired
    private CounterService counterService;
    @Autowired
    private RequestService requestService;

    @PostMapping("/threads")
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity setThreadsValue(@RequestParam Integer producerThreads,
                                          @RequestParam Integer consumerThreads,
                                          HttpServletRequest request) {

        threadService.createThreads(producerThreads, consumerThreads);

        requestService.createRequest(request);
        return ResponseEntity.created(URI.create("/threads")).build();
    }

    @PutMapping("/counter")
    public void setCounterValue(@RequestParam Integer counterValue) {
        counterService.setCounterValue(counterValue);
    }
}
