package com.casestudy.Dealer.DAO;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.casestudy.Dealer.Models.Customer;

public interface DealerDatabase extends MongoRepository<Customer, String>{

}
