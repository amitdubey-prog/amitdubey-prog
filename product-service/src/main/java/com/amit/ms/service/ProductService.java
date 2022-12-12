package com.amit.ms.service;

import org.springframework.stereotype.Service;

import com.amit.ms.response.ProductResponseModel;

@Service
public class ProductService {
	
 public ProductResponseModel getServiceById(int id) {
	 ProductResponseModel productResponseModel = new ProductResponseModel();
	 productResponseModel.setProductId(id);
	 productResponseModel.setProductName("mackbook pro");
	 
	return productResponseModel;
	 
 }

}
