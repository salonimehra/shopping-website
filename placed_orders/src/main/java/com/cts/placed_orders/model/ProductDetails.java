package com.cts.placed_orders.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductDetails {
	
	private long id;

	
	private String name;

	
	private String description;


	private String brand;


	private int price;

	private boolean inStock;
	
}
