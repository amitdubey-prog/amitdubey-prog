package com.seleniumexpress.service;

import java.util.List;

import com.seleniumexpress.dto.ProductDTO;


public interface ProductService {
	
	ProductDTO createProduct(ProductDTO productDTO);
	List<ProductDTO> getProducts();
	ProductDTO getProductByID(int id);

}
