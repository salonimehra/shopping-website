package com.cts.placed_orders.model;

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
	Integer orderId;
//	@ElementCollection
//	List<ProductDetails> productDetails = new ArrayList<ProductDetails>();
//	ProductDetails productDetails;
	private Long productId;
	private String productName;
	private String productDescription;
	private String productBrand;
	private Integer productPrice;
	private Integer productQuantity;
	public OrderDetails(Long productId, String productName, String productDescription, String productBrand,
			Integer productPrice, Integer productQuantity) {
		super();
		this.productId = productId;
		this.productName = productName;
		this.productDescription = productDescription;
		this.productBrand = productBrand;
		this.productPrice = productPrice;
		this.productQuantity = productQuantity;
	}
	
}
