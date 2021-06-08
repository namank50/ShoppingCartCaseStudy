package com.casestudy.Products.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.casestudy.Products.Models.Products;
import com.casestudy.Products.Service.TestService;

@RestController
public class TestController {
	
	@Autowired
	TestService testService;

	@GetMapping("/test")
	public String test() {
		return "In Products Service";
	}
	

	@GetMapping("/testdata")
	public List<Products> testdata() {
		return testService.getAllData();
	}
	
	@GetMapping("/testconnection")
	public String testConnection() {
		return testService.getDealer();
	}
}