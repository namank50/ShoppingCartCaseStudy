package com.casestudy.Dealer.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.casestudy.Dealer.Models.Dealer;
import com.casestudy.Dealer.Service.GenerateDealerId;
import com.casestudy.Dealer.Service.TestService;

@RestController
public class TestController {
	
	@Autowired
	TestService testService;

	@GetMapping("/test")
	public String test() {
		return "In dealer Application";
		
		}
	
	@GetMapping("/testdata")
	public List<Dealer> testData(){ 
		return testService.getAllData();
	}
	
	@GetMapping("/testId")
	public String testId() {
		return GenerateDealerId.Total();
		
		}
	
}