package com.casestudy.Products.DAO;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.casestudy.Products.Models.Products;

@Repository
public interface ProductDatabase extends MongoRepository<Products, String>{

	List<Products> findByDealerId(String DealerId);
	List<Products> findByCategory(String category);
	Products findByPName(String PName);

}
