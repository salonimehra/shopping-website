package com.shopping.inventory.model;
import javax.persistence.*;

import lombok.Data;

@Entity
@Table(name = "products")
@Data
public class Product {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;

	@Column(name = "name")
	private String name;

	@Column(name = "description")
	private String description;

	@Column(name = "brand")
	private String brand;

	@Column(name = "price")
	private int price;
	
	
	public Product() {

	}

	public Product(String name, String description, String brand,int price) {
		this.name = name;
		this.description = description;
		this.brand = brand;
		this.price=price;
	}
	

}