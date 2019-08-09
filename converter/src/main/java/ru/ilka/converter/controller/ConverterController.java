package ru.ilka.converter.controller;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/convert", produces = MediaType.APPLICATION_JSON_VALUE)
public class ConverterController {
    @GetMapping(path = "/{hours}")
    public Integer convertHoursToStoryPoints(@PathVariable("hours") int hours) {
        return hours * 2;
    }
}
