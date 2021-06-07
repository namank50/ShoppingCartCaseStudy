package com.casestudy.Delivery.DAO;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.casestudy.Dealer.Models.Dealer;
import com.casestudy.Delivery.Models.Delivery;

public interface DeliveryDatabase extends MongoRepository<Delivery, String>{

}
