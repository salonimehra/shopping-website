package com.Inventory.Model;

import javax.persistence.Column;
import javax.persistence.Table;

import lombok.Data;

@Data
@Table(name="StockDetails")
public class StockDetails {
	
	@Column(name="productId")
	private long id;
	
	@Column(name="Stock")
	private int stock;
}
