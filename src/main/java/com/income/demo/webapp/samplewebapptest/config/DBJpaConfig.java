package com.income.demo.webapp.samplewebapptest.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@Configuration
@EnableJpaRepositories(basePackages = "com.income.demo.webapp.samplewebapptest.repository")
public class DBJpaConfig {

}
