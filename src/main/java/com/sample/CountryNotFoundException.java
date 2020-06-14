package com.sample;

public class CountryNotFoundException extends RuntimeException {

    public CountryNotFoundException() {
        super("INVALID_COUNTRY_CODE");
    }

}
