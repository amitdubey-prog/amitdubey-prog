package com.seleniumexpress.ui.model;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import com.seleniumexpress.customevalidations.ProductNumberValidator;

public class ProductRequestModel {

	
	@NotNull(message = "product can not be null")
	@NotEmpty
	private String productName;

	@NotNull(message = "desc can not be null")
	@NotEmpty
	private String description;

	@NotNull
	@Min(value = 2, message = "min product price is 2 rupee")
	private Double price;

	@ProductNumberValidator
	@NotEmpty
	private String productNumber;

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public String getProductNumber() {
		return productNumber;
	}

	public void setProductNumber(String productNumber) {
		this.productNumber = productNumber;
	}

	@Override
	public String toString() {
		return "ProductRequestModel [productName=" + productName + ", description=" + description + ", price=" + price
				+ ", productNumber=" + productNumber + "]";
	}

}
