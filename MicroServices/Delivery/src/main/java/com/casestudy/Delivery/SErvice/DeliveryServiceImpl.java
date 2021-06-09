package com.casestudy.Delivery.SErvice;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.casestudy.Dealer.Models.Dealer;
import com.casestudy.Dealer.Models.DealerForOrder;
import com.casestudy.Delivery.DAO.DeliveryDatabase;
import com.casestudy.Delivery.Models.Delivery;
import com.casestudy.Delivery.Models.DeliveryForOrder;

@Service
public class DeliveryServiceImpl implements DeliveryService {

	@Autowired
	private DeliveryDatabase repository;
	@Autowired
	DeliveryForOrder deliveryForOrder;

	public List<Delivery> getAllDeliveryServices() {
		return repository.findAll();
	}

	public Optional<Delivery> getOneDealiveryService(String _Id) {
		return repository.findById(_Id);
	}

	public String addNewDelivery(Delivery newDelivery) { // add entry into security db also
		repository.save(newDelivery);
		return "Successfully Added New Delivery With Id" + newDelivery.get_Id();

	}

	public String updateDelivery(Delivery updateDelivery) {
		repository.save(updateDelivery);
		return "Delivery Updated Successfully";
	}
	

	public String deleteDelivery(String _Id) { // remove entry from security db also
		repository.deleteById(_Id);
		return "Delivery Service with " + _Id + " deleted successfully";
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

	

}