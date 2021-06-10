package com.casestudy.Dealer.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.casestudy.Customer.DAO.CustomerDatabase;
import com.casestudy.Customer.Models.Customer;
import com.casestudy.Dealer.DAO.DealerDatabase;
import com.casestudy.Dealer.Models.Customer;

@Service
public class TestService {
	
	@Autowired
	private DealerDatabase repository;
	
	public List<Customer> getAllData() {
		System.out.println(repository.findAll());
		return repository.findAll();
	}

}
