package com.casestudy.Orders.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;


@Service
public class GenerateDID {
	@Autowired 
	private  RestTemplate restTemplate;
	
	
	public  String generateDID() {	
		Integer i = restTemplate.getForObject("http://localhost:8083/delivery/number", Integer.class);
		Integer n=GenerateDeliveryId.getCount()-1;
		int x=n%i;
		if(x==0) {
			return "DY00001";
		}
		return "DY"+String.format("%05d",x+1);
	}

}
