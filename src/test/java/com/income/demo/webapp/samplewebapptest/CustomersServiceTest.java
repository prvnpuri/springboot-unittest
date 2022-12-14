package com.income.demo.webapp.samplewebapptest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import java.util.List;
import java.util.Objects;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.income.demo.webapp.samplewebapptest.entity.Customers;
import com.income.demo.webapp.samplewebapptest.service.CustomerService;

@SpringBootTest()
public class CustomersServiceTest {

	@Autowired
	CustomerService customerService;

	@Test
	void addCustomer() {
		Customers customer=new Customers();
		customer.setName("ALEX");
		customer.setEmail("alex@xyz");
		customer.setPhone("9900");
		customerService.save(customer);
		System.out.println("Saved id : "+ customer.getId()+ ", name:"+customer.getName() );
		long id=customer.getId();
		Customers validateCustomer=customerService.get(customer.getId());
		System.out.println("Found id : "+ validateCustomer.getId()+ ", name:"+validateCustomer.getName() );
		boolean valid= !Objects.isNull(id) && customerService.get(customer.getId())!=null;
		assertEquals(Boolean.TRUE,  valid);
	}
	
	@Test
	void addCustomerMissingPhone() {
		try {
			Customers customer=new Customers();
			customer.setName("Abc");
			customer.setEmail("xyz.ssasa@gmail");
			customer.setAddress("flat - Abc");
			customerService.save(customer);
			assertEquals(Boolean.TRUE, false);
		}catch(Exception e) {
			System.out.println("Error: "+e.getMessage());
			assertEquals(Boolean.TRUE, true);
		}
	}
	
	
	@Test
	void findCustomerNameXYZ() {
		List<Customers> xyzCustomer= customerService.findByName("XYZ");
		assertEquals(Boolean.TRUE, xyzCustomer.size()>0);
	}

	
}
