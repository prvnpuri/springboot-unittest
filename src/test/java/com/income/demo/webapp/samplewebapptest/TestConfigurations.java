package com.income.demo.webapp.samplewebapptest;

import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.context.annotation.Bean;

import com.income.demo.webapp.samplewebapptest.service.CustomerService;
import com.income.demo.webapp.samplewebapptest.service.CustomerServiceImpl;

@TestConfiguration
public class TestConfigurations {

	@Bean
	public CustomerService customerService() {
		return new CustomerServiceImpl();
	}
	
	
}
