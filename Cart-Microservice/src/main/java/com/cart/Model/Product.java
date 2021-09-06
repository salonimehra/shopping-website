package com.cart.Model;
import lombok.Data;

@Data
public class Product {

	private long id;

	private String name;

	private String description;

	private String brand;

	private int price;
	
	private boolean inStock;
	
	
	

}