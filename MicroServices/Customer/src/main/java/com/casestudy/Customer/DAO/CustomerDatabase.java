package com.casestudy.Customer.DAO;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.casestudy.Customer.Models.Customer;

@Repository
public interface CustomerDatabase extends MongoRepository<Customer, String>{

}
