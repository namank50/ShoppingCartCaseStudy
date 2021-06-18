package com.casestudy.Admin.Models;

import java.util.List;

import org.springframework.stereotype.Component;

@Component
public class CustomerForAdmin {

	List<Customer> customerData;

	public CustomerForAdmin() {
		super();
		// TODO Auto-generated constructor stub
	}

	public CustomerForAdmin(List<Customer> customerData) {
		super();
		this.customerData = customerData;
		
	}

	public List<Customer> getCustomerData() {
		return customerData;
	}

	public void setCustomerData(List<Customer> customerData) {
		this.customerData = customerData;
	}
	
}
