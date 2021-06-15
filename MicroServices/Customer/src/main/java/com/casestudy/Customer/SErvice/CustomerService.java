package com.casestudy.Customer.SErvice;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.casestudy.Customer.Models.Customer;
import com.casestudy.Customer.Models.CustomerForAdmin;
import com.casestudy.Customer.Models.CustomerForOrder;

@Service
public interface CustomerService {
	public List<Customer> getAllCustomers();
	public Optional<Customer> getOneCustomer(String _Id);
	public String addNewCustomer(Customer newDealer);
	public String updateCustomer(Customer updateDealer);
	public String deleteCustomer(String _Id);
	public CustomerForOrder forOrderMicroservice(String _Id);
	public CustomerForAdmin forAdminService();
	public String getCustomerName(String _Id);

}
