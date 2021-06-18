package com.casestudy.Admin.Models;

import java.util.List;

import org.springframework.stereotype.Component;

@Component
public class ProductsForAdmin {

	List<Products> products;

	public ProductsForAdmin() {
		super();
		// TODO Auto-generated constructor stub
	}

	public ProductsForAdmin(List<Products> products) {
		super();
		this.products = products;
	}

	public List<Products> getProducts() {
		return products;
	}

	public void setProducts(List<Products> products) {
		this.products = products;
	}

}
