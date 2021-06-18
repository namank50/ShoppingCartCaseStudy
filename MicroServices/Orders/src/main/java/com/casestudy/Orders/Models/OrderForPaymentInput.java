package com.casestudy.Orders.Models;

import java.util.List;

import org.springframework.context.annotation.Configuration;

@Configuration
public class OrderForPaymentInput {

	List<String> orderIds;

	public OrderForPaymentInput() {
		super();
		// TODO Auto-generated constructor stub
	}

	public OrderForPaymentInput(List<String> orderIds) {
		super();
		this.orderIds = orderIds;
	}

	public List<String> getOrderIds() {
		return orderIds;
	}

	public void setOrderIds(List<String> orderIds) {
		this.orderIds = orderIds;
	}
	
	
}
