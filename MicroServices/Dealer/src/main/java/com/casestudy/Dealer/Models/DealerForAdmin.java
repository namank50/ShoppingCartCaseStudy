package com.casestudy.Dealer.Models;

import java.util.List;

import org.springframework.stereotype.Component;

@Component
public class DealerForAdmin {

	private List<Dealer> dealerData;
	
	

	public DealerForAdmin() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	

	public DealerForAdmin(List<Dealer> dealerData) {
		super();
		this.dealerData = dealerData;
	}



	public List<Dealer> getDealerData() {
		return dealerData;
	}

	public void setDealerData(List<Dealer> dealerData) {
		this.dealerData = dealerData;
	}



	@Override
	public String toString() {
		return "DealerForAdmin [dealerData=" + dealerData + "]";
	}
	
	
}
