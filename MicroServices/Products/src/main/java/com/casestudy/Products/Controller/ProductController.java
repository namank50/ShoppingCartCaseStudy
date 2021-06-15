package com.casestudy.Products.Controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
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

@RestController
@RequestMapping("/product")
public class ProductController {
	
	@Autowired
	ProductService productService;
	
	@GetMapping("/getall")
	public List<Products> getallProduct() {            
		return productService.getProducts();
	}

	@GetMapping("/getone/{_Id}")
	public Optional<Products> getOneProduct(@PathVariable("_Id")String pid) {             //to be called by cart and order micro service
		return productService.getOneProduct(pid);
	}
	
	@PostMapping("/add")
	public String addProduct(@RequestBody Products proAdd) {
		proAdd.set_id(GenerateDeliveryId.Total());
		return productService.addProduct(proAdd);
		
	}
	
	@PutMapping("/update")
	public String updateProduct(@RequestBody Products proAdd) {
		return productService.addProduct(proAdd);
	}
	
	@DeleteMapping("/delete/{_Id}")
	public String deleteProduct(@PathVariable("_Id")String pid) {
		return productService.deleteProduct(pid);
		
	}
	
	@GetMapping("/productName/{_Id}")
	public String forCustomerName(@PathVariable("_Id") String _Id) {
		return productService.getProductName(_Id);

	}
	
	@GetMapping("/foradmin")                                                 //to be called by admin micro service
	public ProductsForAdmin forAdminProduct() {
		return productService.forAdmin();
		
	}
	
	@GetMapping("/getByDealerId/{DealerId}")
	public ProductsForAdmin getProductByDealerId(@PathVariable("DealerId")String DealerId) {             //if dealer want check his products
		return productService.getProductsByDealerId(DealerId);
	}
	
	@GetMapping("/getByCategory/{Category}")
	public ProductsForAdmin getProductByCategory(@PathVariable("Category")String Category) {             //if somebody wants to get product by category
		return productService.findByCategory(Category);
	}
	
	@GetMapping("/getByName/{PName}")
	public Products getByName(@PathVariable("PName")String PName) {             //if somebody wants to get product by name
		return productService.findByPName(PName);
	}
	
	
	
	
	
	
	
	

}
