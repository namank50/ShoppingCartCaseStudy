package com.casestudy.Orders.Models;

import java.util.List;

import org.springframework.context.annotation.Configuration;

@Configuration
public class OrderForPaymentOutput {
	
	List<String> orderId;
	int totalCost;
	
	
	public OrderForPaymentOutput() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	public OrderForPaymentOutput(List<String> orderId, int totalCost) {
		super();
		this.orderId = orderId;
		this.totalCost = totalCost;
	}


	public List<String> getOrderId() {
		return orderId;
	}
	public void setOrderId(List<String> orderId) {
		this.orderId = orderId;
	}
	public int getTotalCost() {
		return totalCost;
	}
	public void setTotalCost(int totalCost) {
		this.totalCost = totalCost;
	}

}
