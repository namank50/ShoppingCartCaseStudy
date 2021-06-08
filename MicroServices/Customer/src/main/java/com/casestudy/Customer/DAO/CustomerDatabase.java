package com.casestudy.Customer.DAO;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.casestudy.Customer.Models.Customer;

public interface CustomerDatabase extends MongoRepository<Customer, String>{

}
