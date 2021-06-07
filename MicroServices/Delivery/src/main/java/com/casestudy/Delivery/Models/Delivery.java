package com.casestudy.Delivery.Models;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "Delivery")
public class Delivery {

	@Id
	private String _Id;
	private Name DName;
	private Long DMobileNo;
	private String DEmail;
	private Address DAddress;
	private String DPassword;
	private String DFirmName;
	private String DPanNo;
	private String DGSTNo;

	public Delivery() {
		super();
		// TODO Auto-generated constructor stub
	}

	

	public Delivery(String _Id, Name dName, Long dMobileNo, String dEmail, Address dAddress, String dPassword,
			String dFirmName, String dPanNo, String dGSTNo) {
		super();
		this._Id = _Id;
		DName = dName;
		DMobileNo = dMobileNo;
		DEmail = dEmail;
		DAddress = dAddress;
		DPassword = dPassword;
		DFirmName = dFirmName;
		DPanNo = dPanNo;
		DGSTNo = dGSTNo;
	}



	public String get_Id() {
		return _Id;
	}

	public void set_Id(String _Id) {
		this._Id = _Id;
	}

	public Name getDealerName() {
		return DName;
	}

	public void setDealerName(Name dealerName) {
		DName = dealerName;
	}

	public Long getDealerMobileNo() {
		return DMobileNo;
	}

	public void setDealerMobileNo(Long dealerMobileNo) {
		DMobileNo = dealerMobileNo;
	}

	public String getDealerEmail() {
		return DEmail;
	}

	public void setDealerEmail(String dealerEmail) {
		DEmail = dealerEmail;
	}

	public Address getDealerAddress() {
		return DAddress;
	}

	public void setDealerAddress(Address dealerAddress) {
		DAddress = dealerAddress;
	}

	public String getDealerPassword() {
		return DPassword;
	}

	public void setDealerPassword(String dealerPassword) {
		DPassword = dealerPassword;
	}

	public String getDealerFirmName() {
		return DFirmName;
	}

	public void setDealerFirmName(String dealerFirmName) {
		DFirmName = dealerFirmName;
	}

	public String getDealerPanNo() {
		return DPanNo;
	}

	public void setDealerPanNo(String dealerPanNo) {
		DPanNo = dealerPanNo;
	}

	public String getDealerGSTNo() {
		return DGSTNo;
	}

	public void setDealerGSTNo(String dealerGSTNo) {
		DGSTNo = dealerGSTNo;
	}

}
