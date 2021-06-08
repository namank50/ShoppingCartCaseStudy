package com.casestudy.Orders.Models;

import org.bson.BsonDateTime;

public class Date {
	
	private BsonDateTime $date;

	public Date() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Date(BsonDateTime $date) {
		super();
		this.$date = $date;
	}

	public BsonDateTime get$date() {
		return $date;
	}

	public void set$date(BsonDateTime $date) {
		this.$date = $date;
	}
	
	

}
