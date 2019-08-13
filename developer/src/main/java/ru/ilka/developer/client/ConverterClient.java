package ru.ilka.developer.client;

import org.springframework.cloud.openfeign.FeignClient;
import ru.ilka.converter.controller.api.Converter;

@FeignClient("converter")
public interface ConverterClient extends Converter {
}
