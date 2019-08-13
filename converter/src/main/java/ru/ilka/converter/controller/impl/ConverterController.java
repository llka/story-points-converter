package ru.ilka.converter.controller.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.ilka.converter.controller.api.Converter;

@RestController
@RequestMapping(produces = MediaType.APPLICATION_JSON_VALUE)
public class ConverterController implements Converter {
    private static final Logger LOG = LoggerFactory.getLogger(ConverterController.class);

    @GetMapping(path = "/convert/{hours}")
    public Integer convertHoursToStoryPoints(@PathVariable("hours") int hours) {
        LOG.debug("Converting hours: {}", hours);
        return convertFunction(hours);
    }

    private int convertFunction(int hours) {
        return hours * 2;
    }

}
