package com.shopping.product.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class StockDetails {
	private long id;
	private int stock;
}
