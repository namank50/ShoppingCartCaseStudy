package com.casestudy.Cart.DAO;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.casestudy.Cart.Models.Cart;

@Repository
public interface CartDatabase extends MongoRepository<Cart,String> {

}
