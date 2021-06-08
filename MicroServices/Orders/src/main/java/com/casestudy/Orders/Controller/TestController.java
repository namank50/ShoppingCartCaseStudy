package com.casestudy.Orders.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.casestudy.Orders.Models.Orders;
import com.casestudy.Orders.Service.TestService;

@RestController
public class TestController {
	
	@Autowired
	TestService testService;

	@GetMapping("/test")
	public String test() {
		return "In Order Service";
	}
	
	@GetMapping("/testdata")
	public List<Orders> testData() {
		return testService.getAllData();
	}
	@GetMapping("/testconnection")
	public String allData() {
		String y = testService.getDelivery();
		String z = testService.getProduct();
		String b = testService.getCart();
		String c = testService.getCustomer();
		return y+" "+z+" "+" "+b+" "+c;
		
	}
	
	
}