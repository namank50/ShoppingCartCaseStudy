package com.casestudy.Admin.Service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.casestudy.Admin.Models.Customer;
import com.casestudy.Admin.Models.Dealer;
import com.casestudy.Admin.Models.Delivery;
import com.casestudy.Admin.Models.Orders;
import com.casestudy.Admin.Models.Products;

@Service
public interface AdminService {
	
	public List<Customer> getAllCustomerDetails();

	public List<Dealer> getAllDealerDetails();

	public List<Delivery> getAllDeliveryDetails();
	
	public List<Products> getAllProductsDetails();

	public List<Orders> getAllOrderDetails();

}
