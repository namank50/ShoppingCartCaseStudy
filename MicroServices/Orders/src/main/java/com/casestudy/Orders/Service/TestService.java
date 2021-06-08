package com.casestudy.Orders.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.casestudy.Orders.DAO.OrdersDatabase;
import com.casestudy.Orders.Models.Orders;

@Service
public class TestService {
	@Autowired
	OrdersDatabase orderDatabase;
	
	public List<Orders> getAllData(){
		return orderDatabase.findAll();
	}

}
