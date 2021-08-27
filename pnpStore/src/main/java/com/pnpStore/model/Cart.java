package com.pnpStore.model;

import javax.persistence.Column;
import javax.persistence.Entity;


import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;

@Entity
@Table(name = "cart")
@Data
@AllArgsConstructor
public class Cart {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int cart_id;
	@Column
	private int user_id;
	@Column
	private int order_no;
	@Column
	private int cart_quantity;
	@Column
	private String product_name;
	@Column
	private double cart_price;
	@Column
	private String product_img;
	@Column
	private int product_id;
	


}
