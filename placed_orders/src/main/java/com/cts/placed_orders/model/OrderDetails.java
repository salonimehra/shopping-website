package com.cts.placed_orders.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table
public class OrderDetails {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	Integer orderid;
//	@ElementCollection
//	List<ProductDetails> productDetails = new ArrayList<ProductDetails>();
//	ProductDetails productDetails;
	Integer productid;
	String name;
	String descrption;
	Integer quantity;
}
