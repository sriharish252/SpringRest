package com.cognizant.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Service;

import com.cognizant.entity.Country;
import com.cognizant.exception.CountryNotFoundException;

@Service
public class CountryService {

	public Country getCountry(String code) throws CountryNotFoundException {
		ApplicationContext context = new ClassPathXmlApplicationContext("country.xml");
		List<Country> countries = context.getBean("countryList", ArrayList.class);
		
		for(Country country: countries) {
			if(code.equalsIgnoreCase(country.getCode()))
				return country;
		}
		throw new CountryNotFoundException();
	}
	
}
