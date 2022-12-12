package com.amit.ms.controller;

import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.amit.ms.response.ProductDTO;
import com.amit.ms.response.ProductRegesterationResponseModel;
import com.amit.ms.restClient.ProductServiceClient;

@RestController
public class ProductRegisterController {
	
//	@Autowired
//	private RestTemplate restTemplate;
//	
	@Autowired
	private ProductServiceClient productServiceClient;
	
	private static Logger LOGGER = org.slf4j.LoggerFactory.getLogger(ProductRegisterController.class);
	
	@GetMapping("/register")
	public String register(){
		
		String product=null;
		
		try {
			 product = productServiceClient.product();
			
		} catch (Exception e) {
			LOGGER.info("ERROR class is :{}",e.getClass());
			LOGGER.info("ERROR message is :{}",e.getMessage());
		}
		
		
		LOGGER.info("product object fetched from /products url is: {}",product);
		return "your product is registered" + product;
	}
	
	
	@GetMapping("/register/{productId}")
	ResponseEntity<ProductRegesterationResponseModel> registerProductByID(@PathVariable int productId ){
		
		//String url ="http://PRODUCT-SERVICE/products/{id}";
		ProductRegesterationResponseModel model = new ProductRegesterationResponseModel();
		model.setRegistrationId((int)(Math.random()*100+1));
		//RestTemplate call
		//ResponseEntity<ProductDTO> response = restTemplate.exchange(url, HttpMethod.GET, HttpEntity.EMPTY, ProductDTO.class, productId);
		
		//openFeign call
		ResponseEntity<ProductDTO> response = productServiceClient.getProductById(productId);
		LOGGER.info("response object is {}", response);
		ProductDTO productDTO = response.getBody();
		model.setProductDTO(productDTO);
		return ResponseEntity.status(HttpStatus.OK).body(model);
		
	}
}
