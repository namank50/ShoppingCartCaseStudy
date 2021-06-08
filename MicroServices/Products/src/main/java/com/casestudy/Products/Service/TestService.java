package com.casestudy.Products.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.casestudy.Products.DAO.ProductDatabase;
import com.casestudy.Products.Models.Products;

@Service
public class TestService {
	
	@Autowired
	ProductDatabase productDatabase;
	
	public List<Products> getAllData(){
		return productDatabase.findAll();
	}

}
