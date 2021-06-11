package com.casestudy.Dealer.Service;

import java.util.List;
import java.util.Optional;

import com.casestudy.Dealer.Models.Customer;
import com.casestudy.Dealer.Models.DealerForAdmin;
import com.casestudy.Dealer.Models.DealerForOrder;

public interface DealerService {
	public List<Customer> getAllDealers();
	public Optional<Customer> getOneDealer(String _Id);
	public String addNewDealer(Customer newDealer);
	public String updateDealer(Customer updateDealer);
	public String deleteDealer(String _Id);
	public String forProductMicroservice(String _Id);
	public DealerForOrder forOrderMicroservice(String _Id);
	public DealerForAdmin forAdminService();

}
