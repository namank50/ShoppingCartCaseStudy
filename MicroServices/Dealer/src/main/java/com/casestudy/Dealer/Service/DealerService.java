package com.casestudy.Dealer.Service;

import java.util.List;
import java.util.Optional;

import com.casestudy.Dealer.Models.Delivery;
import com.casestudy.Dealer.Models.DealerForOrder;

public interface DealerService {
	public List<Delivery> getAllDealers();
	public Optional<Delivery> getOneDealer(String _Id);
	public String addNewDealer(Delivery newDealer);
	public String updateDealer(Delivery updateDealer);
	public String deleteDealer(String _Id);
	public String forProductMicroservice(String _Id);
	public DealerForOrder forOrderMicroservice(String _Id);

}
