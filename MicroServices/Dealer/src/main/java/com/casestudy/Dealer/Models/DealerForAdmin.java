package com.casestudy.Dealer.Models;

import java.util.List;

import org.springframework.stereotype.Component;

@Component
public class DealerForAdmin {

	private List<Customer> dealerData;
	
	

	public DealerForAdmin() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	

	public DealerForAdmin(List<Customer> dealerData) {
		super();
		this.dealerData = dealerData;
	}



	public List<Customer> getDealerData() {
		return dealerData;
	}

	public void setDealerData(List<Customer> dealerData) {
		this.dealerData = dealerData;
	}



	@Override
	public String toString() {
		return "DealerForAdmin [dealerData=" + dealerData + "]";
	}
	
	
}
