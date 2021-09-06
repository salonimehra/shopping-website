package com.cart.Model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import lombok.Data;

@Data
@Table(name="products")
@Entity
public class Products {
	
	@Column	
	private int product_id;
	@Column
	private int productQuantity;
}
