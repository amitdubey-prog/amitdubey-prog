package com.seleniumexpress.controller;

import java.util.List;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.seleniumexpress.dto.ProductDTO;
import com.seleniumexpress.exception.UserServiceException;
import com.seleniumexpress.exception.UserServiceExceptionNoContent;
import com.seleniumexpress.service.ProductService;
import com.seleniumexpress.ui.model.ProductRequestModel;
import com.seleniumexpress.ui.model.ProductResponseModel;

@RestController
public class ProductController {

	@Autowired
	private ProductService productService;

	@PostMapping(value = "/products", consumes = { MediaType.APPLICATION_JSON_VALUE,
			MediaType.APPLICATION_XML_VALUE }, produces = MediaType.APPLICATION_JSON_VALUE,params = "saveProduct")
	public ResponseEntity<ProductResponseModel> saveProduct(@Valid @RequestBody ProductRequestModel requestModel) {

		ModelMapper modelMapper = new ModelMapper();
		modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
		ProductDTO productDTO = modelMapper.map(requestModel, ProductDTO.class);
		ProductDTO productDto = productService.createProduct(productDTO);

		ProductResponseModel response = modelMapper.map(productDto, ProductResponseModel.class);
		return ResponseEntity.status(HttpStatus.CREATED).body(response);

	}

	@GetMapping(value = "/products", produces = { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE })
	public ResponseEntity<List<ProductResponseModel>> getAllProducts() {
		ModelMapper modelMapper = new ModelMapper();
		modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
		List<ProductDTO> products = productService.getProducts();
		List<ProductResponseModel> response = products.stream()
				.map(product -> modelMapper.map(product, ProductResponseModel.class)).collect(Collectors.toList());
		return ResponseEntity.status(HttpStatus.OK).body(response);

	}

	@GetMapping(value = "/products/{id}", produces = { MediaType.APPLICATION_JSON_VALUE,
			MediaType.APPLICATION_XML_VALUE })
	public ResponseEntity<ProductResponseModel> ProductByID(@PathVariable int id) {
		ModelMapper modelMapper = new ModelMapper();
		modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
		ProductDTO productByID = productService.getProductByID(id);
		if(productByID == null) {
			throw new UserServiceExceptionNoContent("product is not available. please try later.");
		}
			
		ProductResponseModel response = modelMapper.map(productByID, ProductResponseModel.class);
		
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return ResponseEntity.status(HttpStatus.OK).body(response);

	}
	
	@PostMapping(value = "/products", consumes = { MediaType.APPLICATION_JSON_VALUE,
			MediaType.APPLICATION_XML_VALUE }, produces = MediaType.APPLICATION_JSON_VALUE,params = "saveProductNew")
	public ResponseEntity<ProductResponseModel> saveProductNew(@RequestParam String productName,@RequestParam String description,
			                                                   @RequestParam double price,@RequestParam String productNumber) {

		ModelMapper modelMapper = new ModelMapper();
		modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
		ProductRequestModel requestModel = new ProductRequestModel();
		requestModel.setProductName(productName);
		requestModel.setDescription(description);
		requestModel.setPrice(price);
		requestModel.setProductNumber(productNumber);
		ProductDTO productDTO = modelMapper.map(requestModel, ProductDTO.class);
		ProductDTO productDto = productService.createProduct(productDTO);

		ProductResponseModel response = modelMapper.map(productDto, ProductResponseModel.class);
		return ResponseEntity.status(HttpStatus.CREATED).body(response);

	}

}
