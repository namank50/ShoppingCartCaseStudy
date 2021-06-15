package com.casestudy.Products.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.casestudy.Customer.Models.Customer;
import com.casestudy.Products.DAO.ProductDatabase;
import com.casestudy.Products.Models.Products;
import com.casestudy.Products.Models.ProductsForAdmin;

@Service
public class ProductServiceImpl implements ProductService {

	@Autowired
	ProductDatabase productDatabase;
	@Autowired
	ProductsForAdmin productForAdmin;
	@Override
	public List<Products> getProducts() {
		return productDatabase.findAll();
	}
	@Override
	public Optional<Products> getOneProduct(String _Id) {
		return productDatabase.findById(_Id);	
		}
	@Override
	public String addProduct(Products proAdd) {
		productDatabase.save(proAdd);
		return "Success";
	}
	
	@Override
	public String deleteProduct(String pid) {
		productDatabase.deleteById(pid);
		return "success";
	}
	@Override
	public ProductsForAdmin forAdmin() {
		List<Products> proAdmin=getProducts();
		productForAdmin.setProducts(proAdmin);
		return productForAdmin;
	}
	
	@Override
	public ProductsForAdmin getProductsByDealerId(String DealerId) {
		List<Products> pro=getProducts();
		List<Products> prod=new ArrayList<Products>();
		for(Products p: pro) {
			if(p.getDealerId().matches(DealerId)) {
				prod.add(p);
		}
		}
		productForAdmin.setProducts(prod);
		return productForAdmin;
	}
	@Override
	public ProductsForAdmin findByCategory(String Category) {
	List<Products> pro=getProducts();
	List<Products> prod=new ArrayList<Products>();
	for(Products p: pro) {
		if(p.getCategory().matches(Category)) {
			prod.add(p);
	}
	}
	productForAdmin.setProducts(prod);
	return productForAdmin;
	}
	@Override
	public Products findByPName(String PName) {
		// TODO Auto-generated method stub
		return productDatabase.findByPName(PName);
	}
	
	@Override
	public String getProductName(String _Id) {
		// TODO Auto-generated method stub
		Products d =productDatabase.findById(_Id).orElse(null);
		return d.getPName();
	}


}
