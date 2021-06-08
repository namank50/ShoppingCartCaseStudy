package com.casestudy.Admin.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.casestudy.Admin.DAO.AdminDAO;
import com.casestudy.Admin.Models.Admin;

@Service
public class TestService {
	
	@Autowired
	private AdminDAO repository;
	@Autowired
	private RestTemplate restTemplate;
	
	public List<Admin> getAllData() {
		System.out.println(repository.findAll());
		return repository.findAll();
	}
	
	public String getDealer() {
		String x=restTemplate.getForObject("http://localhost:8082/test", String.class);
		return x;
	}
	
	public String getDelivery() {
		String x=restTemplate.getForObject("http://localhost:8083/test", String.class);
		return x;
	}
	
	public String getCustomer() {
		String x=restTemplate.getForObject("http://localhost:8081/test", String.class);
		return x;
	}
	
	public String getCart() {
		String x=restTemplate.getForObject("http://localhost:8087/test", String.class);
		return x;
	}
	
	public String getOrder() {
		String x=restTemplate.getForObject("http://localhost:8086/test", String.class);
		return x;
	}
	
	public String getProduct() {
		String x=restTemplate.getForObject("http://localhost:8085/test", String.class);
		return x;
	}
	
	



}
