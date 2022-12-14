package com.income.demo.webapp.samplewebapptest.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.income.demo.webapp.samplewebapptest.entity.Customers;

public interface CustomerRepository extends JpaRepository<Customers, Long> {

	List<Customers> findByName(String name);

}
