package com.casestudy.Dealer.DAO;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.casestudy.Dealer.Models.Dealer;

public interface DealerDatabase extends MongoRepository<Dealer, String>{

}
