package ru.ilka.developer.circuitbreaker;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class ConverterCaller {
    private static final Logger LOG = LogManager.getLogger(ConverterCaller.class);
    private static final int DEFAULT_ESTIMATE = 42;

    @Autowired
    private RestTemplate restTemplate;

    @HystrixCommand(fallbackMethod = "fallback")
    public Integer calculateStoryPoints(int hours) {
        return restTemplate.getForObject("http://converter/convert/" + hours, Integer.class);
    }

    private Integer fallback(int hours) {
        LOG.warn("Converter app is unavailable! Default estimation is used.");
        return DEFAULT_ESTIMATE;
    }
}
