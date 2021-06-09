package com.casestudy.Dealer.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.casestudy.Dealer.DAO.DealerDatabase;
import com.casestudy.Dealer.Models.Delivery;
import com.casestudy.Dealer.Models.DealerForOrder;

@Service
public class DealerServiceImpl implements DealerService {

	@Autowired
	private DealerDatabase repository;
	@Autowired
	DealerForOrder dealerForOrder;

	public List<Delivery> getAllDealers() {
		return repository.findAll();
	}

	public Optional<Delivery> getOneDealer(String _Id) {
		return repository.findById(_Id);
	}

	public String addNewDealer(Delivery newDealer) { // add entry into security db also
		repository.save(newDealer);
		return "Successfully Added New Dealer With Id" + newDealer.get_Id();

	}

	public String updateDealer(Delivery updateDealer) {
		repository.save(updateDealer);
		return "Dealer Updated Successfully";
	}
	

	public String deleteDealer(String _Id) { // remove entry from security db also
		repository.deleteById(_Id);
		return "Dealer with " + _Id + " deleted successfully";
	}

	public String forProductMicroservice(String _Id) { // product micro-service will require the name of dealer
		Optional<Delivery> proDealer = getOneDealer(_Id);
		if(proDealer.isEmpty())
			return "No dealer present with specified Id";
		return proDealer.get().getDealerFirmName();
		
	}
	
	public DealerForOrder forOrderMicroservice(String _Id) { // order micro-service will require the object "DealerforOrder"
		Optional<Delivery> proDealer = getOneDealer(_Id);
			dealerForOrder.setDealerName(proDealer.get().getDealerName());
			dealerForOrder.setDealerFirmName(proDealer.get().getDealerFirmName());
			dealerForOrder.setDealerMobileNo(proDealer.get().getDealerMobileNo());
			dealerForOrder.setDealerAddress(proDealer.get().getDealerAddress());
			dealerForOrder.setDealerEmail(proDealer.get().getDealerEmail());;
			dealerForOrder.setDealerGSTNo(proDealer.get().getDealerGSTNo());
			return dealerForOrder;	
		
	}

}