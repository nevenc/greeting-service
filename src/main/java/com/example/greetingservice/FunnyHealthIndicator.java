package com.example.greetingservice;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.actuate.health.Health;
import org.springframework.boot.actuate.health.HealthIndicator;
import org.springframework.stereotype.Component;

import java.util.Random;

@Component
public class FunnyHealthIndicator implements HealthIndicator {

    private static final Logger logger = LoggerFactory.getLogger(FunnyHealthIndicator.class);
    private static final Random random = new Random(System.currentTimeMillis());

    @Override
    public Health health() {
        logger.debug("Calling FunnyHealthIndicator.health()");
        int percentage = random.nextInt(100);
        if ( percentage < 5) {
            logger.error("Health Indicator: DOWN [percent: %s]", percentage);
            return Health.down().withDetail("message", "failure").withDetail("percent", percentage).build();
        } else {
            return Health.up().withDetail("message", "success").withDetail("percent",percentage).build();
        }
    }

}
