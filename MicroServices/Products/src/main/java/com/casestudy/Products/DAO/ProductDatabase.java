package com.casestudy.Products.DAO;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.casestudy.Products.Models.Products;

public interface ProductDatabase extends MongoRepository<Products, String>{

}
