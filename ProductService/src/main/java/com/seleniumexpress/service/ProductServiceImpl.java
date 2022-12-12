package com.seleniumexpress.service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.seleniumexpress.dto.ProductDTO;
import com.seleniumexpress.entity.Product;
import com.seleniumexpress.repo.ProductRepo;

@Service
public class ProductServiceImpl implements ProductService {

	@Autowired
	ProductRepo productRepo;
	@Override
	public ProductDTO createProduct(ProductDTO productDTO) {
		
		productDTO.setCreatedDate(LocalDateTime.now());
		//productDTO.setProductId(101);
		ModelMapper modelMapper = new ModelMapper();
		modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
		Product product = modelMapper.map(productDTO, Product.class);
		Product savedProduct = productRepo.save(product);
		ProductDTO productDTo = modelMapper.map(savedProduct, ProductDTO.class);
		
		return productDTo;
	}
	@Override
	public List<ProductDTO> getProducts() {
		ModelMapper modelMapper = new ModelMapper();
		modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
		List<Product> products = productRepo.findAll();
		List<ProductDTO> productdto = products.stream().map(product -> modelMapper.map(product, ProductDTO.class))
		.collect(Collectors.toList());
		return productdto;
	}
	@Override
	public ProductDTO getProductByID(int id) {
		ProductDTO productdto=null;
		Product product=null;
		ModelMapper modelMapper = new ModelMapper();
		modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
		Optional<Product> findById = productRepo.findById(id);
		if (findById.isPresent()) {
			product=findById.get();
			productdto = modelMapper.map(product, ProductDTO.class);
			
		}
		return productdto;
	}
	

}
