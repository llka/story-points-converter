package ru.ilka.converter.controller.api;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

public interface Converter {
    @GetMapping(path = "convert/{hours}")
    Integer convertHoursToStoryPoints(@PathVariable("hours") int hours);
}
