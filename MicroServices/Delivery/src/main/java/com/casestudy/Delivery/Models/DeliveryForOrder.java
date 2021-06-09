package com.casestudy.Delivery.Models;

import org.springframework.stereotype.Component;

@Component
public class DeliveryForOrder {
	private Name DName;
	private Long DMobileNo;
	private String DEmail;
	private Address DAddress;
	private String DFirmName;
	private String DGSTNo;

	public DeliveryForOrder() {
		super();
		// TODO Auto-generated constructor stub
	}

	public DeliveryForOrder(Name dName, Long dMobileNo, String dEmail, Address dAddress, String dFirmName,
			String dGSTNo) {
		super();
		DName = dName;
		DMobileNo = dMobileNo;
		DEmail = dEmail;
		DAddress = dAddress;
		DFirmName = dFirmName;
		DGSTNo = dGSTNo;
	}

	public Name getDName() {
		return DName;
	}

	public void setDName(Name dName) {
		DName = dName;
	}

	public Long getDMobileNo() {
		return DMobileNo;
	}

	public void setDMobileNo(Long dMobileNo) {
		DMobileNo = dMobileNo;
	}

	public String getDEmail() {
		return DEmail;
	}

	public void setDEmail(String dEmail) {
		DEmail = dEmail;
	}

	public Address getDAddress() {
		return DAddress;
	}

	public void setDAddress(Address dAddress) {
		DAddress = dAddress;
	}

	public String getDFirmName() {
		return DFirmName;
	}

	public void setDFirmName(String dFirmName) {
		DFirmName = dFirmName;
	}

	public String getDGSTNo() {
		return DGSTNo;
	}

	public void setDGSTNo(String dGSTNo) {
		DGSTNo = dGSTNo;
	}

	
}
