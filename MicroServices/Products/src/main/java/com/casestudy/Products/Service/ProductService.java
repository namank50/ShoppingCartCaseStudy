package com.casestudy.Products.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.casestudy.Products.Models.Products;
import com.casestudy.Products.Models.ProductsForAdmin;

@Service
public interface ProductService {

	public List<Products> getProducts();

	public Optional<Products> getOneProduct(String pid);

	public String addProduct(Products proAdd);

	public String deleteProduct(String pid);

	public ProductsForAdmin forAdmin();

	public ProductsForAdmin getProductsByDealerId(String DealerId);

	public ProductsForAdmin findByCategory(String Category);

	public Products findByPName(String PName);
}
