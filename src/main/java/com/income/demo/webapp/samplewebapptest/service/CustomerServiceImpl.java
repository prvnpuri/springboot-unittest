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
public class CustomerServiceImpl implements CustomerService {

	@Autowired
	CustomerRepository customerRepository;
	
	public boolean save(Customers customer) {
		customerRepository.save(customer);
		return true;
	}

	public boolean delete(long id) {
		Customers customer= get(id);
		customerRepository.delete(customer);
		return true;
	}

	public Customers get(long id) {
		return customerRepository.findById(id).get();
	}
	
	public Page<Customers>  list(int page) {
		return customerRepository.findAll(PageRequest.of(page, 20) );
	}

	@Override
	public List<Customers> findByName(String name) {
		// TODO Auto-generated method stub
		return customerRepository.findByName(name);
	}
	
}
