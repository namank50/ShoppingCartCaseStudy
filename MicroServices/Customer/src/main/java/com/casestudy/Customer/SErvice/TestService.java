package com.casestudy.Customer.SErvice;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.casestudy.Customer.DAO.CustomerDatabase;
import com.casestudy.Customer.Models.Customer;

@Service
public class TestService {
	
	@Autowired
	private CustomerDatabase repository;
	@Autowired
	private RestTemplate restTemplate;
	
	public List<Customer> getAllData() {
		System.out.println(repository.findAll());
		return repository.findAll();
	}
	
	public String getCart() {
		String x=restTemplate.getForObject("http://localhost:8087/test", String.class);
		return x;
	}

}
