package com.casestudy.Delivery.SErvice;

import java.util.List;
import java.util.Optional;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.casestudy.Delivery.DAO.DeliveryDatabase;
import com.casestudy.Delivery.Models.Delivery;
import com.casestudy.Delivery.Models.DeliveryForAdmin;
import com.casestudy.Delivery.Models.DeliveryForOrder;
import com.casestudy.Delivery.Models.ForQueue;
import com.casestudy.Delivery.config.MessagingConfig;

@Service
public class DeliveryServiceImpl implements DeliveryService {

	@Autowired
	private DeliveryDatabase repository;
	@Autowired
	DeliveryForOrder deliveryForOrder;
	@Autowired
	DeliveryForAdmin deliveryForAdmin;
	@Autowired
	ForQueue ForQueue;
	@Autowired
	RabbitTemplate rabbitTemplate;
	@Autowired
	private RestTemplate restTemplate;

	public List<Delivery> getAllDeliveryServices() {
		return repository.findAll();
	}

	public Optional<Delivery> getOneDealiveryService(String _Id) {
		return repository.findById(_Id);
	}

	public String addNewDelivery(Delivery newDelivery) { // add entry into security db also
		repository.save(newDelivery);
		ForQueue.set_id(newDelivery.get_Id());
		ForQueue.setPassword(newDelivery.getDPassword());
		ForQueue.setRole("Delivery");
		rabbitTemplate.convertAndSend(com.casestudy.Delivery.config.MessagingConfig.Exchange,MessagingConfig.Routing,ForQueue);    //sending data to queue
		return "Successfully Added New Delivery With Id" + newDelivery.get_Id();

	}

	public String updateDelivery(Delivery updateDelivery) {
		repository.save(updateDelivery);
		ForQueue.set_id(updateDelivery.get_Id());
		ForQueue.setPassword(updateDelivery.getDPassword());
		ForQueue.setRole("Delivery");
		rabbitTemplate.convertAndSend(com.casestudy.Delivery.config.MessagingConfig.Exchange,MessagingConfig.Routing,ForQueue);    //sending data to queue
		return "Delivery Updated Successfully";
	}
	

	public String deleteDelivery(String _Id) { // remove entry from security db also
		repository.deleteById(_Id);
		String x=restTemplate.getForObject("http://localhost:8088/security/delete/"+_Id, String.class);
		return "Delivery Service with " + _Id + " deleted successfully"+x;
	}

	
	public DeliveryForOrder forOrderMicroservice(String _Id) { // order micro-service will require the object "DeliveryforOrder"
		Optional<Delivery> proDealer = getOneDealiveryService(_Id);
			deliveryForOrder.setDName(proDealer.get().getDName());
			deliveryForOrder.setDFirmName(proDealer.get().getDFirmName());
			deliveryForOrder.setDMobileNo(proDealer.get().getDMobileNo());
			deliveryForOrder.setDAddress(proDealer.get().getDAddress());
			deliveryForOrder.setDEmail(proDealer.get().getDEmail());;
			deliveryForOrder.setDGSTNo(proDealer.get().getDGSTNo());
			return deliveryForOrder;	
		
	}
	
	public DeliveryForAdmin forAdminService() {  // admin micro service will get this wrapped data 
		List<Delivery> deliveryList=getAllDeliveryServices();
		deliveryForAdmin.setDeliveryData(deliveryList);
		return deliveryForAdmin;
		
	}

	

}