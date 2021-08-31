package com.pnpStore.controller;

import java.util.ArrayList;
//import CartController used files
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.pnpStore.model.Cart;
import com.pnpStore.service.CartService;

//@RestController - indicates that it is a  Spring MVC controller using REST API
@RestController
public class CartController {

	// @Autowired - uses properties to get rid of setter methods
	@Autowired
	private CartService cartService;

	// RequestMapping - maps the specified URL eg '/SaveCart'
	// RequestMethod = request method type - POST it inserts specific resources
	@PostMapping("/SaveCart")
	// @RequestBody converts JSON format to java object
	public ResponseEntity<String> SaveCart(@RequestBody Cart Carts) {
		try {
		cartService.SaveCart(Carts);
		return new ResponseEntity<>("product added in cart successfully",HttpStatus.OK);
		}
		catch(Exception e){
			return new ResponseEntity<>(null,HttpStatus.INTERNAL_SERVER_ERROR);
		}

	}

	// RequestMapping - maps the specified URL eg '/DeleteCart/{cartID}'
	// RequestMethod = request method type - DELETE it removes specific resources
	// using a certain ID
	@DeleteMapping("/DeleteCart/{cartID}")
	// @PathVariable - identifies the path pattern used in URL for incoming data
	public ResponseEntity<String> DeleteCart(@PathVariable int cartID) {
		try {
		cartService.DeleteCart(cartID);
		return new ResponseEntity<>("Succefullly deleted the product from cart with ID:"+cartID,HttpStatus.OK);
		}
		catch (Exception e){
			return new ResponseEntity<>(null,HttpStatus.INTERNAL_SERVER_ERROR);
		}

	}

	// RequestMapping - maps the specified URL eg '/UpdateCart/{userID}'
	// RequestMethod = request method type - PUT it updates specific resources using
	// a certain ID
	@PutMapping("/UpdateCart/{userID}")
	// @RequestBody converts JSON format to java object
	// @PathVariable - identifies the path pattern used in URL for incoming data
	public ResponseEntity<Boolean> updateCart(@RequestBody Cart carts, @PathVariable int userID) {

		try {
		cartService.updateCart(userID, carts);
			return new ResponseEntity<>(true,HttpStatus.OK);
		}
		catch(Exception e){
			return new ResponseEntity<>(false, HttpStatus.INTERNAL_SERVER_ERROR);
		}

	}

	// RequestMapping - maps the specified URL eg '/GetCarts'
	@GetMapping("/GetCarts")
	// Generic array list
	public ResponseEntity<List<Cart>> getAllCarts() {
		try {
			List<Cart> cart = new ArrayList<Cart>();

			cart = cartService.getAllCarts();

			return new ResponseEntity<>(cart, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

}
