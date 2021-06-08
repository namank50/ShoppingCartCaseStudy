package com.casestudy.Orders.DAO;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.casestudy.Orders.Models.Orders;

public interface OrdersDatabase extends MongoRepository<Orders, String> {

}
