package com.pnpStore.service;

//import CartService used files
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pnpStore.model.Cart;
import com.pnpStore.repository.CartRepository;

//@Services - creates a services bean , has all business logic and calls methods from CartRepository
@Service
public class CartService {
	
	//@Autowired - uses properties to get rid of setter methods 
	@Autowired
	public CartRepository CartRepository;
	
	
	//gets Cart using user id 	
	public ArrayList<Cart> getCart(int user_id)
	{
		return CartRepository.viewByUserId(user_id);
	}
	
	//Add Cart 
	public void SaveCart(Cart Carts) {
		
		
		CartRepository.save(Carts);
		
	}
	
	//Delete Cart using cart id 
	public void DeleteCart(int cartID) {
		
		
		CartRepository.deleteById(cartID);
		
	}
	
	//Update Cart using cart id 
	public void updateCart(int userID, Cart Carts) 
	{

		CartRepository.save(Carts);
	}

	//gets All Carts 
	public List<Cart> getAllCarts()
	{
		
		List<Cart> Carts = new ArrayList<>();
		CartRepository.findAll()
		.forEach(Carts::add);
		return Carts;
		
	}	
	
}
