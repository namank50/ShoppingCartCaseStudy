package com.casestudy.Delivery.Models;

import java.util.List;

import org.springframework.stereotype.Component;

@Component
public class DeliveryForAdmin {
	
	List<Delivery> deliveryData;

	public DeliveryForAdmin() {
		super();
		// TODO Auto-generated constructor stub
	}

	public DeliveryForAdmin(List<Delivery> deliveryData) {
		super();
		this.deliveryData = deliveryData;
	}

	public List<Delivery> getDeliveryData() {
		return deliveryData;
	}

	public void setDeliveryData(List<Delivery> deliveryData) {
		this.deliveryData = deliveryData;
	}
	
	

}
