package com.casestudy.Dealer.Models;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "Dealer")
public class Delivery {

	@Id
	private String _Id;
	private Name DealerName;
	private Long DealerMobileNo;
	private String DealerEmail;
	private Address DealerAddress;
	private String DealerPassword;
	private String DealerFirmName;
	private String DealerPanNo;
	private String DealerGSTNo;

	public Delivery() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Delivery(String _Id, Name dealerName, Long dealerMobileNo, String dealerEmail, Address dealerAddress,
			String dealerPassword, String dealerFirmName, String dealerPanNo, String dealerGSTNo) {
		super();
		this._Id = _Id;
		DealerName = dealerName;
		DealerMobileNo = dealerMobileNo;
		DealerEmail = dealerEmail;
		DealerAddress = dealerAddress;
		DealerPassword = dealerPassword;
		DealerFirmName = dealerFirmName;
		DealerPanNo = dealerPanNo;
		DealerGSTNo = dealerGSTNo;
	}

	public String get_Id() {
		return _Id;
	}

	public void set_Id(String _Id) {
		this._Id = _Id;
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

	public String getDealerPassword() {
		return DealerPassword;
	}

	public void setDealerPassword(String dealerPassword) {
		DealerPassword = dealerPassword;
	}

	public String getDealerFirmName() {
		return DealerFirmName;
	}

	public void setDealerFirmName(String dealerFirmName) {
		DealerFirmName = dealerFirmName;
	}

	public String getDealerPanNo() {
		return DealerPanNo;
	}

	public void setDealerPanNo(String dealerPanNo) {
		DealerPanNo = dealerPanNo;
	}

	public String getDealerGSTNo() {
		return DealerGSTNo;
	}

	public void setDealerGSTNo(String dealerGSTNo) {
		DealerGSTNo = dealerGSTNo;
	}

}
