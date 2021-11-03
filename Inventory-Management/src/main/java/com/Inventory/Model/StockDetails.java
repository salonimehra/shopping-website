package com.Inventory.Model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Table(name="StockDetails")
@Entity
public class StockDetails {
	
	@Id
	@Column(name="productId")
	private long id;
	
	@Column(name="Stock")
	private int stock;
}
