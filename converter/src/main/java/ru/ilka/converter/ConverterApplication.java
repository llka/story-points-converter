package ru.ilka.converter;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
@EnableEurekaClient
public class ConverterApplication {
    private static final Logger LOG = LoggerFactory.getLogger(ConverterApplication.class);

    public static void main(String[] args) {
        LOG.debug("Hi, it's converter application!");
        SpringApplication.run(ConverterApplication.class, args);
    }

    @GetMapping(path = "convert/{hours}")
    public Integer convertHoursToStoryPoints(@PathVariable("hours") int hours) {
        return hours * 2;
    }

}
