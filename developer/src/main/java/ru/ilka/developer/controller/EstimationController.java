package ru.ilka.developer.controller;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.ilka.developer.circuitbreaker.ConverterCaller;

import java.util.Random;

@RestController
@RequestMapping(path = "/estimation", produces = MediaType.APPLICATION_JSON_VALUE)
public class EstimationController {
    private static final Logger LOG = LogManager.getLogger(EstimationController.class);

    private final int[] INTERVALS = {1, 2, 4, 8, 16, 80};

    @Autowired
    private ConverterCaller converterCaller;

    @GetMapping
    public String getEstimation() {
        int hours = generateTime();
        LOG.debug("I think it would take {} hours.", hours);

        Integer receivedValue = converterCaller.calculateStoryPoints(hours);

        String result = "Let it be " + receivedValue + " story points.";
        LOG.debug(result);

        return result;
    }

    private int generateTime() {
        return INTERVALS[new Random().nextInt(INTERVALS.length)];
    }
}
