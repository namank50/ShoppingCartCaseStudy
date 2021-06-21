package com.casestudy.APIGateway.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.casestudy.APIGateway.Service.SecurityService;

@RestController
@RequestMapping("/security")
@CrossOrigin(origins = "http://localhost:4200")
public class SecurityController {
	@Autowired
	SecurityService securityService;
	
	@GetMapping("/delete/{_id}")
	public String save(@PathVariable("_id")String _id) {
		return securityService.deleteData(_id);
	}

}
