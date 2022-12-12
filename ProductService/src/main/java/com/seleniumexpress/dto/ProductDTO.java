package com.seleniumexpress.dto;



import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProductDTO {

	private int productId;
	private String productName;
	private String description;
	private LocalDateTime createdDate;
	private double price;
	private String productNumber;
}
