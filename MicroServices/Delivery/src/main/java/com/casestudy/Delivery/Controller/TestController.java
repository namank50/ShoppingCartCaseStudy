package com.casestudy.Delivery.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.casestudy.Delivery.Models.Delivery;
import com.casestudy.Delivery.SErvice.GenerateDeliveryId;
import com.casestudy.Delivery.SErvice.TestService;

@RestController
public class TestController {
	@Autowired
	TestService testService;

	@GetMapping("/test")
	public String test() {
		return "In Delivery Service";
	}
	
	@GetMapping("/testdata")
	public List<Delivery> testData(){ 
		return testService.getAllData();
	}
	@GetMapping("/testId")
	public String testId(){ 
		return GenerateDeliveryId.Total();
	}
}