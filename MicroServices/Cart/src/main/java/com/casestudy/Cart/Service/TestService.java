package com.casestudy.Cart.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.casestudy.Cart.DAO.CartDatabase;
import com.casestudy.Cart.Models.Cart;

@Service
public class TestService {
	@Autowired
	CartDatabase cartDataBase;
	@Autowired
	private RestTemplate restTemplate;
	
	public List<Cart> getAllData(){
		return cartDataBase.findAll();
	}
	
	public String getProduct() {
		String x=restTemplate.getForObject("http://localhost:8085/test", String.class);
		return x;
	}


}
