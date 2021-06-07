package com.casestudy.APIGateway.DAO;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.casestudy.APIGateway.Model.SecurityData;

public interface SecurityDatabase extends MongoRepository<SecurityData,String> {

}
