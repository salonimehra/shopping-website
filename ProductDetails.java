package com.cts.placed_orders.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductDetails {
	
	private long productId;
	private String productName;
	private String productDescription;
	private String productBrand;
	private int productPrice;
	private boolean productInStock;
}
