package com.sample;

import static org.junit.Assert.assertEquals;


import com.sample.model.CountryResponse;
import org.junit.Before;
import org.junit.Test;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

public class CountryAPITest extends AbstractTest {

    @Override
    @Before
    public void setUp() {
        super.setUp();
    }

    @Test
    public void findCountryResponseByCode() throws Exception {
        String uri = "/BHR";
        MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.get(uri)
                .accept(MediaType.APPLICATION_JSON_VALUE)).andReturn();
        assertEquals(200, mvcResult.getResponse().getStatus());
        String content = mvcResult.getResponse().getContentAsString();
        CountryResponse countryResponse = super.mapFromJson(content);
        assertEquals("Bahrain", countryResponse.getName());
    }

    @Test
    public void findCountryResponseByInvalidCode() throws Exception {
        String uri = "/invalid";
        MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.get(uri)
                .accept(MediaType.APPLICATION_JSON_VALUE)).andReturn();
        assertEquals(500, mvcResult.getResponse().getStatus());
        String content = mvcResult.getResponse().getContentAsString();
        assertEquals("INVALID_COUNTRY_CODE", content);
    }
}
