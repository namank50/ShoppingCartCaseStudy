package com.casestudy.Customer.SErvice;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.casestudy.Customer.DAO.CustomerDatabase;
import com.casestudy.Customer.Models.Customer;

@Service
public class TestService {
	
	@Autowired
	private CustomerDatabase repository;
	
	public List<Customer> getAllData() {
		System.out.println(repository.findAll());
		return repository.findAll();
	}

}
