package com.casestudy.Customer.Models;

import org.springframework.stereotype.Component;

@Component
public class CustomerForOrder {
	
	private String _Id;
	private Name Name;
	private Long CustMobNo;
	private String CustEmail;
	private Address CustAddress;
	public CustomerForOrder() {
		super();
		// TODO Auto-generated constructor stub
	}
	public CustomerForOrder(String _Id, com.casestudy.Customer.Models.Name name, Long custMobNo, String custEmail,
			Address custAddress) {
		super();
		this._Id = _Id;
		Name = name;
		CustMobNo = custMobNo;
		CustEmail = custEmail;
		CustAddress = custAddress;
	}
	public String get_Id() {
		return _Id;
	}
	public void set_Id(String _Id) {
		this._Id = _Id;
	}
	public Name getName() {
		return Name;
	}
	public void setName(Name name) {
		Name = name;
	}
	public Long getCustMobNo() {
		return CustMobNo;
	}
	public void setCustMobNo(Long custMobNo) {
		CustMobNo = custMobNo;
	}
	public String getCustEmail() {
		return CustEmail;
	}
	public void setCustEmail(String custEmail) {
		CustEmail = custEmail;
	}
	public Address getCustAddress() {
		return CustAddress;
	}
	public void setCustAddress(Address custAddress) {
		CustAddress = custAddress;
	}
	
	

}
