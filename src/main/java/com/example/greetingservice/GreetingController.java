package com.example.greetingservice;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class GreetingController {

    private static final Logger logger = LoggerFactory.getLogger(GreetingController.class);

    private GreetingService service;

    public GreetingController(GreetingService service) {
        logger.debug("Initializing GreetingController.");
        this.service = service;
    }

    @GetMapping("/")
    public String hello(Model model) {
        String greeting = service.getGreeting();
        model.addAttribute("greeting", greeting);
        logger.debug("Processing GET / request in GreetingController.hello(): " + greeting);
        return "hello";
    }

}
