package com.casestudy.Orders.Models;

import java.util.List;

import org.springframework.context.annotation.Configuration;

@Configuration
public class OrderForAdmin {
	
	private List<Orders> orderList;

	public OrderForAdmin() {
		super();
		// TODO Auto-generated constructor stub
	}

	public OrderForAdmin(List<Orders> orderList) {
		super();
		this.orderList = orderList;
	}

	public List<Orders> getOrderList() {
		return orderList;
	}

	public void setOrderList(List<Orders> orderList) {
		this.orderList = orderList;
	}

	
}
