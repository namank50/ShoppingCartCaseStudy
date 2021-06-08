package com.casestudy.Cart.DAO;

import org.springframework.data.mongodb.repository.MongoRepository;


import com.casestudy.Cart.Models.Cart;

public interface CartDatabase extends MongoRepository<Cart,String> {

}
