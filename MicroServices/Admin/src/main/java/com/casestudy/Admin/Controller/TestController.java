package com.casestudy.Admin.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.casestudy.Admin.Models.Admin;
import com.casestudy.Admin.Service.TestService;

@RestController
public class TestController {
	
	@Autowired
	TestService testService;

	@GetMapping("/test")
	public String test() {
		return "In Admin Service";
	}
	
	@GetMapping("/testdata")
	public List<Admin> testData() {
		return testService.getAllData();
	}
	
	
}
