package com.casestudy.Orders.DAO;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.casestudy.Orders.Models.Orders;

@Repository
public interface OrdersDatabase extends MongoRepository<Orders, String> {


}
