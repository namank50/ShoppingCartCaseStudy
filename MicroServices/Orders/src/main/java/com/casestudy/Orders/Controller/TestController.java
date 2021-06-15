package com.casestudy.Orders.Controller;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.casestudy.Orders.Models.Orders;
import com.casestudy.Orders.Service.GenerateDID;
import com.casestudy.Orders.Service.GenerateDeliveryId;
import com.casestudy.Orders.Service.TestService;

@RestController
public class TestController {
	
	@Autowired
	TestService testService;
	@Autowired
	GenerateDID generateDID;

	@GetMapping("/test")
	public String test() {
		return generateDID.generateDID();
	}
	
	@GetMapping("/testdata")
	public List<Orders> testData() {
		return testService.getAllData();
	}
	
	@GetMapping("/testdate")
	public String testDate() {
		LocalDate myObj = LocalDate.now();
		String s=String.valueOf(myObj);
		return s;
	}
	
	@GetMapping("/testId")
	public String testId() {
		return GenerateDeliveryId.Total();
		
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