package com.example.greetingservice;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class KillSwitchController {

    private static final Logger logger = LoggerFactory.getLogger(KillSwitchController.class);

    @GetMapping("/kill")
    public void kill() {
        logger.error("Kill Switch Enabled. Exiting application...");
        System.exit(-1);
    }

}
