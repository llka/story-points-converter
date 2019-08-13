package ru.ilka.converter;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ConverterApplication {
    private static final Logger LOG = LoggerFactory.getLogger(ConverterApplication.class);

    public static void main(String[] args) {
        LOG.debug("Hi, it's converter application!");
        SpringApplication.run(ConverterApplication.class, args);
    }
}
