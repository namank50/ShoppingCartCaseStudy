package com.casestudy.Dealer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class DealerApplication {
	
	

	public static void main(String[] args) {
		SpringApplication.run(DealerApplication.class, args);
	}
	
	
	@Bean
	public RestTemplate getTemplate() {
		return new RestTemplate();
	}
	

}
