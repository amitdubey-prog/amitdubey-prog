package com.seleniumexpress.client;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import com.seleniumexpress.dto.ProductDTO;
import com.seleniumexpress.exceptions.MyErrorHandler;

@Component
public class ProductClient {

	@Autowired
	RestTemplate restTemplate;
	String host = "http://localhost:8080";
	// "http://localhost:8080/products/2"

	/*public ProductDTO getProductDataByID(int id) {
		
		ProductDTO product = restTemplate.getForObject(host + "/products/" + id, ProductDTO.class);
		return product;

	}*/
	
public ResponseEntity<ProductDTO> getProductDataByID(int id) {
	/*
	 * Map<String, Integer> uriArgs = new HashMap<String, Integer>();
	 * uriArgs.put("id", id);
	 */
		 ResponseEntity<ProductDTO> product = restTemplate.getForEntity(host + "/products/" + id , ProductDTO.class);
		 
		return product;

	}

	public ResponseEntity<ProductDTO[]> getProductList() {
		ResponseEntity<ProductDTO[]> forEntity = restTemplate.getForEntity(host + "/products", ProductDTO[].class);
		return forEntity;
	}

	public ProductDTO saveProduct(ProductDTO productDTO) {
        restTemplate.setErrorHandler(new MyErrorHandler());
		ProductDTO product = restTemplate.postForObject(host + "/products?saveProduct", productDTO, ProductDTO.class);

		return product;

	}
	// call http://localhost:8080/products?productName=Realme&description=good
	// phone&price=24444&productNumber=sel45684&saveProductNew

	public ProductDTO CreateProduct() {
		HttpHeaders headers = new HttpHeaders();
		headers.set("Accept", "application/json");
		headers.set("Content-Type", "application/json");
		HttpEntity entity = new HttpEntity(headers);
		
		UriComponentsBuilder uri = UriComponentsBuilder.fromHttpUrl(host + "/products").queryParam("productName", "TV")
				.queryParam("description", "LCD").queryParam("price", 44444).queryParam("productNumber", "sel45683")
				.queryParam("saveProductNew");

		ProductDTO productDTO = restTemplate.postForObject(uri.toUriString(), entity, ProductDTO.class);

		return productDTO;

	}
}
