package com.casestudy.Cart.DAO;

import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.casestudy.Cart.Models.Cart;

@Repository
public interface CartDatabase extends MongoRepository<Cart,String> {

	void save(Optional<Cart> cart1);

}
