package com.amit.ms.restClient;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.amit.ms.response.ProductDTO;

@FeignClient("PRODUCT-SERVICE")
public interface ProductServiceClient {

	//call to /products
	
	@GetMapping("/products")
	public String product();
	
	@GetMapping("/products/{id}")
	 public ResponseEntity<ProductDTO>getProductById(@PathVariable int id);
	
		
	
}
