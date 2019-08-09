package ru.ilka.developer;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DeveloperApplication {
    private static final Logger LOG = LogManager.getLogger(DeveloperApplication.class);

    public static void main(String[] args) {
        LOG.debug("Hi, it's developer!");
        SpringApplication.run(DeveloperApplication.class, args);
    }

}
