package com.casestudy.Products.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.casestudy.Products.DAO.ProductDatabase;
import com.casestudy.Products.Models.Products;

@Service
public class TestService {
	
	@Autowired
	ProductDatabase productDatabase;
	@Autowired
	private RestTemplate restTemplate;
	
	public List<Products> getAllData(){
		return productDatabase.findAll();
	}
	
	public String getDealer() {
		String x=restTemplate.getForObject("http://localhost:8082/test", String.class);
		return x;
	}
	

}
