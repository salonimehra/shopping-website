package com.cart.Service;

import org.springframework.beans.factory.annotation.Autowired;

import com.cart.Model.Products;
import com.cart.Repository.ProductsRepository;

public class CartServiceImpl implements CartService{
	@Autowired
	ProductsRepository productsRepository;
	public boolean addProduct(Products product) {
		productsRepository.save(product);
		return true;
	}
}
