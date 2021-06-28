package com.cognizant;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.cognizant.entity.Country;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@SpringBootApplication
public class SpringRest1Application {

	private static final Logger LOGGER = LoggerFactory.getLogger(SpringRest1Application.class);

	public static void displayDate() {
		LOGGER.info("START");
		ApplicationContext context = new ClassPathXmlApplicationContext("date-format.xml");
		SimpleDateFormat format = context.getBean("dateFormat", SimpleDateFormat.class);
		try {
			Date date = format.parse("31/12/2018");
			LOGGER.debug(format.format(date));
		} catch (ParseException e) {
			e.printStackTrace();
		}
		LOGGER.info("END");
	}

	private static void displayCountry() {
		LOGGER.info("START");
		ApplicationContext context = new ClassPathXmlApplicationContext("country.xml");
		Country country = context.getBean("in", Country.class);
		LOGGER.debug("Country : {}", country);
		LOGGER.info("END");
	}

	public static void displayCountries() {
		LOGGER.info("START");
		ApplicationContext context = new ClassPathXmlApplicationContext("country.xml");
		List<Country> countryList = context.getBean("countryList", ArrayList.class);
		LOGGER.debug("CountryList : {}", countryList);
		LOGGER.info("END");
	}

	public static void main(String[] args) {
		LOGGER.info("Inside main");
		SpringApplication.run(SpringRest1Application.class, args);
		displayDate();
		displayCountry();
		displayCountries();
	}

}
