package com.sample.service;

import com.sample.model.Country;
import com.sample.model.CountryResponse;

import java.util.Optional;

public interface CountryService {
    Optional<CountryResponse> findCountryByCode(String code);
}
