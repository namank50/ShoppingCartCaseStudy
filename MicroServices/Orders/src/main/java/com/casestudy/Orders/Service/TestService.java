package com.casestudy.Orders.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.casestudy.Orders.DAO.OrdersDatabase;
import com.casestudy.Orders.Models.Orders;

@Service
public class TestService {
	@Autowired
	private RestTemplate restTemplate;
	@Autowired
	OrdersDatabase orderDatabase;
	
	public List<Orders> getAllData(){
		return orderDatabase.findAll();
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
	
	
	public String getProduct() {
		String x=restTemplate.getForObject("http://localhost:8085/test", String.class);
		return x;
	}
	

}
