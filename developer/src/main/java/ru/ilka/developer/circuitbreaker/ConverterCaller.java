package ru.ilka.developer.circuitbreaker;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.ilka.developer.client.ConverterClient;

@Service
public class ConverterCaller {
    private static final Logger LOG = LogManager.getLogger(ConverterCaller.class);
    private static final int DEFAULT_ESTIMATE = 42;

    @Autowired
    private ConverterClient converterClient;

    @HystrixCommand(fallbackMethod = "fallback")
    public Integer calculateStoryPoints(int hours) {
        return converterClient.convertHoursToStoryPoints(hours);
    }

    private Integer fallback(int hours) {
        LOG.warn("Converter app is unavailable! Default estimation is used.");
        return DEFAULT_ESTIMATE;
    }
}
