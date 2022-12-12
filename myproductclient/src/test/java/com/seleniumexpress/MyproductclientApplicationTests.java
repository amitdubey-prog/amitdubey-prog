package com.seleniumexpress;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;

import com.seleniumexpress.client.ProductClient;
import com.seleniumexpress.dto.ProductDTO;

@SpringBootTest
class MyproductclientApplicationTests {

	@Autowired
	private ProductClient productClinet;

	/*@Test
	void testGetByIDApi() {

		ProductDTO productDto = productClinet.getProductDataByID(1);
		assertNotNull(productDto);
		System.out.println(productDto);
	}*/

	@Test
	void testGetByIDApi() {

		ResponseEntity<ProductDTO> productDto = productClinet.getProductDataByID(13);
		//assertNotNull(productDto);
		System.out.println(productDto.getHeaders());
		System.out.println(productDto.getStatusCode());
		//System.out.println(productDto.getStatusCodeValue());
		System.out.println(productDto);
	}

	@Test
	void testGetProductsApi() {
		
		ResponseEntity<ProductDTO[]> productList = productClinet.getProductList();
		assertNotNull(productList);
		System.out.println(productList);
	}
	
	@Test
	public void testSaveProductApi() {
		
		ProductDTO productDTO = new ProductDTO();
		productDTO.setProductName("OnePlus");
		productDTO.setPrice(40000.0);
		productDTO.setDescription("nice phone");
		productDTO.setProductNumber("sel1299");
		ProductDTO saveProduct = productClinet.saveProduct(productDTO);
		assertNotNull(saveProduct);
		System.out.println(saveProduct);
		
		
	}
	
	@Test
	public void testSaveProductNewApi() {
		ProductDTO saveProduct = productClinet.CreateProduct(); 
		assertNotNull(saveProduct);
		System.out.println(saveProduct);
	}	
}
