package com.amit.ms.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.amit.ms.response.ProductResponseModel;
import com.amit.ms.service.ProductService;

@RestController
public class ProductServiceController {
	
	@Autowired
	private ProductService productService;
	@GetMapping("/products")
	public String product(){
		
		return "Iphone11 :100000/-";
	}
	
@GetMapping("/products/{id}")
  ResponseEntity<ProductResponseModel>getProductById(@PathVariable int id){
	ProductResponseModel product = productService.getServiceById(id);
	  
	return ResponseEntity.status(HttpStatus.OK).body(product);
	  
  }
}
