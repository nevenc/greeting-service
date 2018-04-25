package com.example.greetingservice;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
public class GreetingServiceApplication {

	private static final Logger logger = LoggerFactory.getLogger(GreetingServiceApplication.class);

	public static void main(String[] args) {
		logger.debug("Initializing GreetingServiceApplication.main()");
		SpringApplication.run(GreetingServiceApplication.class, args);
	}
}
