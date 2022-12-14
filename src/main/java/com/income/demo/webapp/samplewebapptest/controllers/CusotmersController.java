package com.income.demo.webapp.samplewebapptest.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.income.demo.webapp.samplewebapptest.entity.Customers;
import com.income.demo.webapp.samplewebapptest.service.CustomerService;

@RestController
@RequestMapping("/customers"  )
public class CusotmersController {

	@Autowired
	CustomerService customerService;
	
	@GetMapping("/{id}")
	public Customers getCustomer(@PathVariable("id") long id) {
		return customerService.get(id);
	}
	
	@PostMapping("/save")
	public Customers getCustomer(@RequestBody  Customers customer ) {
		customerService.save(customer);
		return customer;
	}
	
	@DeleteMapping("/{id}/delete")
	public boolean deleteCustomer(@PathVariable("id") long id) {
		customerService.delete(id);
		return true;
	}
	
	@GetMapping( path = { "/",""})
	public Page<Customers> list(@RequestParam( name = "page",defaultValue = "0" ) int pageNo) {
		return customerService.list(pageNo);
	}
	
	
}
