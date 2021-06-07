package com.casestudy.Customer.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;


import com.casestudy.Customer.Models.Customer;
import com.casestudy.Customer.SErvice.TestService;

@RestController
public class TestController {
	
	@Autowired
	TestService testService;

	@GetMapping("/test")
	public String test() {
		return "In Customer Service";
	}
	
	@GetMapping("/testdata")
	public List<Customer> testData() {
		return testService.getAllData();
	}
}