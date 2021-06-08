package com.casestudy.Delivery.SErvice;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.casestudy.Delivery.DAO.DeliveryDatabase;
import com.casestudy.Delivery.Models.Delivery;

@Service
public class TestService {
	
	@Autowired
	private DeliveryDatabase repository;
	
	public List<Delivery> getAllData() {
		System.out.println(repository.findAll());
		return repository.findAll();
	}

}
