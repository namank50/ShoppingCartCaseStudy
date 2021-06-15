package com.casestudy.Orders.Models;

import java.util.List;

import org.springframework.context.annotation.Configuration;

@Configuration
public class OrderForInput {

	List<String> PID;
	String CUSTID;

	public OrderForInput() {
		super();
		// TODO Auto-generated constructor stub
	}

	public OrderForInput(List<String> pID, String cUSTID) {
		super();
		PID = pID;
		CUSTID = cUSTID;
	}

	public List<String> getPID() {
		return PID;
	}

	public void setPID(List<String> pID) {
		PID = pID;
	}

	public String getCUSTID() {
		return CUSTID;
	}

	public void setCUSTID(String cUSTID) {
		CUSTID = cUSTID;
	}

}
