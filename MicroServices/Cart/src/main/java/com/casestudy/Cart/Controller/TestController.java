package com.casestudy.Cart.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.casestudy.Cart.Models.Cart;
import com.casestudy.Cart.Service.TestService;

@RestController
public class TestController {

	@Autowired
	TestService testService;
	@GetMapping("/test")
	public String test() {
		return "In Cart Service";
	}
	
	@GetMapping("/testdata")
	public List<Cart> testData() {
		return testService.getAllData();
	}
	
	@GetMapping("/testconnection")
	public String testConnection() {
		return testService.getProduct();
	}
}