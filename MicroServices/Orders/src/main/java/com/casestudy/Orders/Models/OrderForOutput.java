package com.casestudy.Orders.Models;

import java.util.List;

import org.springframework.context.annotation.Configuration;

@Configuration
public class OrderForOutput {
	
	private String _id;
	private List<String> PName;
	private String CustName;
	private String DealerName;
	private String DealiiveryName;
	private String Status;
	private int Total;
	private boolean PaymentStatus;
	private String Date;
	
	
	
	public OrderForOutput() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	public OrderForOutput(String _id, List<String> pName, String custName, String dealerName, String dealiiveryName,
			String status, int total, boolean paymentStatus, String date) {
		super();
		this._id = _id;
		PName = pName;
		CustName = custName;
		DealerName = dealerName;
		DealiiveryName = dealiiveryName;
		Status = status;
		Total = total;
		PaymentStatus = paymentStatus;
		Date = date;
	}


	public String get_id() {
		return _id;
	}
	public void set_id(String _id) {
		this._id = _id;
	}
	public List<String> getPName() {
		return PName;
	}
	public void setPName(List<String> pName) {
		PName = pName;
	}
	public String getCustName() {
		return CustName;
	}
	public void setCustName(String custName) {
		CustName = custName;
	}
	public String getDealerName() {
		return DealerName;
	}
	public void setDealerName(String dealerName) {
		DealerName = dealerName;
	}
	public String getDealiiveryName() {
		return DealiiveryName;
	}
	public void setDealiiveryName(String dealiiveryName) {
		DealiiveryName = dealiiveryName;
	}
	public String getStatus() {
		return Status;
	}
	public void setStatus(String status) {
		Status = status;
	}
	public int getTotal() {
		return Total;
	}
	public void setTotal(int total) {
		Total = total;
	}
	public boolean isPaymentStatus() {
		return PaymentStatus;
	}
	public void setPaymentStatus(boolean paymentStatus) {
		PaymentStatus = paymentStatus;
	}
	public String getDate() {
		return Date;
	}
	public void setDate(String date) {
		Date = date;
	}
	
	


}
