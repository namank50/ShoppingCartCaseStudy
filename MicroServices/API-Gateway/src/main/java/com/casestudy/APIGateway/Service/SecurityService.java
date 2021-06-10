package com.casestudy.APIGateway.Service;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.casestudy.APIGateway.DAO.SecurityDatabase;
import com.casestudy.APIGateway.Model.ForQueue;
import com.casestudy.APIGateway.Model.SecurityData;
import com.casestudy.APIGateway.config.MessagingConfig;

@Service
public class SecurityService {

	@Autowired
	SecurityDatabase repository;
	@Autowired
	SecurityData securityData;
	
	@RabbitListener(queues=MessagingConfig.Queue)
	public void saveData(ForQueue dealer) {
		System.out.println(dealer);
		securityData.set_Id(dealer.get_id());
		securityData.setRole(dealer.getRole());
		securityData.setPassword(dealer.getPassword());
		repository.save(securityData);
		//return "Success";
	}
	
	public String deleteData(String _id) {
		repository.deleteById(_id);
		return "Success";
	}
	
}
