package com.sample.service;

import com.sample.model.Country;
import com.sample.model.CountryResponse;
import com.sample.repository.CountryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CountryServiceImpl implements CountryService {

    @Autowired
    private CountryRepository repository;

    @Override
    public Optional<CountryResponse> findCountryByCode(String code) {
        return repository.findOneWithOfficialLanguage(code).map(this::mapToCountryResponse);
    }


    public CountryResponse mapToCountryResponse(Country c) {
        return new CountryResponse(c.getName(), c.getContinent(), c.getPopulation(),
                c.getLifeExpectancy(), c.getCountryLanguages().iterator().next().getId().getLanguage());
    }
}
