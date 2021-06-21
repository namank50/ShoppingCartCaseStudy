package com.casestudy.Products.Controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.casestudy.Products.Models.Products;
import com.casestudy.Products.Models.ProductsForAdmin;
import com.casestudy.Products.Service.GenerateDeliveryId;
import com.casestudy.Products.Service.ProductService;

import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/product")
@CrossOrigin(origins = "http://localhost:4200")
public class ProductController {
	
	@Autowired
	ProductService productService;
	
	@GetMapping("/getall")
	@ApiOperation(value = "To get all the products",notes="Returns all the product")
	public List<Products> getallProduct() {            
		return productService.getProducts();
	}

	@GetMapping("/getone/{_Id}")
	@ApiOperation(value = "To get an product",notes="Returns one product")
	public Optional<Products> getOneProduct(@PathVariable("_Id")String pid) {             //to be called by cart and order micro service
		return productService.getOneProduct(pid);
	}
	
	@PostMapping("/add")
	@ApiOperation(value = "To add a new product",notes="Whenever a new product is added")
	public String addProduct(@RequestBody Products proAdd) {
		proAdd.set_id(GenerateDeliveryId.Total());
		return productService.addProduct(proAdd);
		
	}
	
	@PutMapping("/update")
	@ApiOperation(value = "To update an order",notes="Updates a product")
	public String updateProduct(@RequestBody Products proAdd) {
		return productService.addProduct(proAdd);
	}
	
	@DeleteMapping("/delete/{_Id}")
	@ApiOperation(value = "To delete a product",notes="Deletes a product")
	public String deleteProduct(@PathVariable("_Id")String pid) {
		return productService.deleteProduct(pid);
		
	}
	
	
	@GetMapping("/productName/{_Id}")
	@ApiOperation(value = "To get product name ",notes="called by admin and order microservice")
	public String forCustomerName(@PathVariable("_Id") String _Id) {
		return productService.getProductName(_Id);

	}
	
	@GetMapping("/foradmin")                                                 //to be called byadmin micro service
	@ApiOperation(value = "To be called by admin microservice",notes="Data Wrapped")
	public ProductsForAdmin forAdminProduct() {
		return productService.forAdmin();
		
	}
	
	
	@GetMapping("/getByDealerId/{DealerId}")
	@ApiOperation(value = "Get products by dealer ID",notes="Products by Id")
	public ProductsForAdmin getProductByDealerId(@PathVariable("DealerId")String DealerId) {             //if dealer want check his products
		return productService.getProductsByDealerId(DealerId);
	}
	
	@GetMapping("/getByCategory/{Category}")
	@ApiOperation(value = "Get products by category",notes="Products by category")
	public ProductsForAdmin getProductByCategory(@PathVariable("Category")String Category) {             //if somebody wants to get product by category
		return productService.findByCategory(Category);
	}
	
	@GetMapping("/getByName/{PName}")
	@ApiOperation(value = "Get product by name",notes="Product by name")
	public Products getByName(@PathVariable("PName")String PName) {             //if somebody wants to get product by name
		return productService.findByPName(PName);
	}
	
	
	
	
	
	
	
	

}
