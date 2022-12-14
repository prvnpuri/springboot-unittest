package com.income.demo.webapp.samplewebapptest.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.income.demo.webapp.samplewebapptest.entity.Customers;
import com.income.demo.webapp.samplewebapptest.repository.CustomerRepository;

@Service
public interface CustomerService {

	public boolean save(Customers customer);

	public boolean delete(long id);

	public Customers get(long id) ;
	
	public Page<Customers>  list(int page);
	
	public List<Customers> findByName(String name);
}
