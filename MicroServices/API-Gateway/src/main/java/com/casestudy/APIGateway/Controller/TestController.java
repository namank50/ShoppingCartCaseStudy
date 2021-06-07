package com.casestudy.APIGateway.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.casestudy.APIGateway.Model.SecurityData;
import com.casestudy.APIGateway.Service.TestService;

@RestController
public class TestController {
	@Autowired
	TestService testService;
	
	@GetMapping("/testdata")
	public List<SecurityData> getData(){
		return testService.getAllData();
	}

}
