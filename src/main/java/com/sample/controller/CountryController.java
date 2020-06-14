package com.sample.controller;

import com.sample.CountryNotFoundException;
import com.sample.model.CountryResponse;
import com.sample.service.CountryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CountryController {

    @Autowired
    private CountryService countryService;

    @GetMapping("/{code}")
    CountryResponse findOneByCode(@PathVariable String code) {
        return countryService.findCountryByCode(code)
                .orElseThrow(CountryNotFoundException::new);
    }
}
