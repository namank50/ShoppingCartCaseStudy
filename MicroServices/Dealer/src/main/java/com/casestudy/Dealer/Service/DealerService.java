package com.casestudy.Dealer.Service;

import java.util.List;
import java.util.Optional;

import com.casestudy.Dealer.Models.Dealer;
import com.casestudy.Dealer.Models.DealerForAdmin;
import com.casestudy.Dealer.Models.DealerForOrder;

public interface DealerService {
	public List<Dealer> getAllDealers();
	public Optional<Dealer> getOneDealer(String _Id);
	public String addNewDealer(Dealer newDealer);
	public String updateDealer(Dealer updateDealer);
	public String deleteDealer(String _Id);
	public String forProductMicroservice(String _Id);
	public DealerForOrder forOrderMicroservice(String _Id);
	public DealerForAdmin forAdminService();

}
