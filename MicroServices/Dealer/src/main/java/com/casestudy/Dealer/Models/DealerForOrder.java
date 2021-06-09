package com.casestudy.Dealer.Models;

import org.springframework.stereotype.Component;

@Component
public class DealerForOrder {
	private Name DealerName;
	private Long DealerMobileNo;
	private String DealerEmail;
	private Address DealerAddress;
	private String DealerFirmName;
	private String DealerGSTNo;

	public DealerForOrder() {
		super();
		// TODO Auto-generated constructor stub
	}

	public DealerForOrder(Name dealerName, Long dealerMobileNo, String dealerEmail, Address dealerAddress,
			String dealerFirmName, String dealerGSTNo) {
		super();
		DealerName = dealerName;
		DealerMobileNo = dealerMobileNo;
		DealerEmail = dealerEmail;
		DealerAddress = dealerAddress;
		DealerFirmName = dealerFirmName;
		DealerGSTNo = dealerGSTNo;
	}

	public Name getDealerName() {
		return DealerName;
	}

	public void setDealerName(Name dealerName) {
		DealerName = dealerName;
	}

	public Long getDealerMobileNo() {
		return DealerMobileNo;
	}

	public void setDealerMobileNo(Long dealerMobileNo) {
		DealerMobileNo = dealerMobileNo;
	}

	public String getDealerEmail() {
		return DealerEmail;
	}

	public void setDealerEmail(String dealerEmail) {
		DealerEmail = dealerEmail;
	}

	public Address getDealerAddress() {
		return DealerAddress;
	}

	public void setDealerAddress(Address dealerAddress) {
		DealerAddress = dealerAddress;
	}

	public String getDealerFirmName() {
		return DealerFirmName;
	}

	public void setDealerFirmName(String dealerFirmName) {
		DealerFirmName = dealerFirmName;
	}

	public String getDealerGSTNo() {
		return DealerGSTNo;
	}

	public void setDealerGSTNo(String dealerGSTNo) {
		DealerGSTNo = dealerGSTNo;
	}
}
