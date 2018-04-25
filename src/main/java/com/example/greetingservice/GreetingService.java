package com.example.greetingservice;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.actuate.metrics.CounterService;
import org.springframework.boot.actuate.metrics.buffer.BufferCounterService;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.stereotype.Service;

@Service
@RefreshScope
public class GreetingService {

    private static final Logger logger = LoggerFactory.getLogger(GreetingService.class);

    @Value("${service.greeting:Hello World!}")
    private String greeting;

    private CounterService counter;

    public GreetingService(BufferCounterService counter) {
        logger.debug("Initializing GreetingService with counter instance.");
        this.counter = counter;
    }

    public String getGreeting() {
        logger.debug("Processing GreetingService.getGreeting().");
        counter.increment("counter.services.greetingservice.greeting");
        return this.greeting;
    }

}
