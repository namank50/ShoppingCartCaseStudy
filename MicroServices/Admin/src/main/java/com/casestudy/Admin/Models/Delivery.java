package com.casestudy.Admin.Models;

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

	public String getDPassword() {
		return DPassword;
	}

	public void setDPassword(String dPassword) {
		DPassword = dPassword;
	}

	public String getDFirmName() {
		return DFirmName;
	}

	public void setDFirmName(String dFirmName) {
		DFirmName = dFirmName;
	}

	public String getDPanNo() {
		return DPanNo;
	}

	public void setDPanNo(String dPanNo) {
		DPanNo = dPanNo;
	}

	public String getDGSTNo() {
		return DGSTNo;
	}

	public void setDGSTNo(String dGSTNo) {
		DGSTNo = dGSTNo;
	}

	

	

}
