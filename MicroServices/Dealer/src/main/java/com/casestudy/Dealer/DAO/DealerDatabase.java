package com.casestudy.Dealer.DAO;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.casestudy.Dealer.Models.Delivery;

public interface DealerDatabase extends MongoRepository<Delivery, String>{

}
