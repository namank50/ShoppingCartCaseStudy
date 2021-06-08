package com.casestudy.APIGateway.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.casestudy.APIGateway.DAO.SecurityDatabase;
import com.casestudy.APIGateway.Model.SecurityData;

@Service
public class TestService {
	
	@Autowired
	SecurityDatabase securityDatabase;
	
	public List<SecurityData> getAllData(){
		return securityDatabase.findAll();
		
	}

}
