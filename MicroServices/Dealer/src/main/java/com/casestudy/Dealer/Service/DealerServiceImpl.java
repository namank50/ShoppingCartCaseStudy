package com.casestudy.Dealer.Service;

import java.util.List;

import java.util.Optional;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.casestudy.Dealer.DAO.DealerDatabase;
import com.casestudy.Dealer.Models.Dealer;
import com.casestudy.Dealer.Models.DealerForAdmin;
import com.casestudy.Dealer.Models.DealerForOrder;
import com.casestudy.Dealer.Models.ForQueue;
import com.casestudy.Dealer.config.MessagingConfig;

@Service
public class DealerServiceImpl implements DealerService {

	@Autowired
	private DealerDatabase repository;
	@Autowired
	DealerForOrder dealerForOrder;
	@Autowired
	DealerForAdmin dealerForAdmin;
	@Autowired
	ForQueue ForQueue;
	@Autowired
	RabbitTemplate rabbitTemplate;
	@Autowired
	private RestTemplate restTemplate;

	public List<Dealer> getAllDealers() {
		return repository.findAll();
	}

	public Optional<Dealer> getOneDealer(String _Id) {
		return repository.findById(_Id);
	}

	public String addNewDealer(Dealer newDealer) { // add entry into security db also
		repository.save(newDealer);
		ForQueue.set_id(newDealer.get_Id());
		ForQueue.setPassword(newDealer.getDealerPassword());
		ForQueue.setRole("Dealer");
		rabbitTemplate.convertAndSend(MessagingConfig.Exchange,MessagingConfig.Routing,ForQueue);    //sending data to queue
		return "Successfully Added New Dealer With Id" + newDealer.get_Id();

	}

	public String updateDealer(Dealer updateDealer) {
		repository.save(updateDealer);
		ForQueue.set_id(updateDealer.get_Id());
		ForQueue.setPassword(updateDealer.getDealerPassword());
		ForQueue.setRole("Dealer");
		return "Dealer Updated Successfully";
	}
	

	public String deleteDealer(String _Id) { // remove entry from security db also
		repository.deleteById(_Id);
		String x=restTemplate.getForObject("http://localhost:8088/security/delete/"+_Id, String.class);
		return "Dealer with " + _Id + " deleted successfully" + x;
	}

	public String forProductMicroservice(String _Id) { // product micro-service will require the name of dealer
		Optional<Dealer> proDealer = getOneDealer(_Id);
		if(proDealer.isEmpty())
			return "No dealer present with specified Id";
		return proDealer.get().getDealerFirmName();
		
	}
	
	public DealerForOrder forOrderMicroservice(String _Id) { // order micro-service will require the object "DealerforOrder"
		Optional<Dealer> proDealer = getOneDealer(_Id);
			dealerForOrder.setDealerName(proDealer.get().getDealerName());
			dealerForOrder.setDealerFirmName(proDealer.get().getDealerFirmName());
			dealerForOrder.setDealerMobileNo(proDealer.get().getDealerMobileNo());
			dealerForOrder.setDealerAddress(proDealer.get().getDealerAddress());
			dealerForOrder.setDealerEmail(proDealer.get().getDealerEmail());;
			dealerForOrder.setDealerGSTNo(proDealer.get().getDealerGSTNo());
			return dealerForOrder;	
		
	}
	
	public DealerForAdmin forAdminService() {  // admin micro service will get this wrapped data 
		List<Dealer> dealerList=getAllDealers();
		dealerForAdmin.setDealerData(dealerList);
		return dealerForAdmin;
		
	}

}