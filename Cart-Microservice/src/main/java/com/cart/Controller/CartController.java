package com.cart.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cart.Feign.AuthenticationFeignClient;
import com.cart.Feign.InventoryFeign;
import com.cart.Service.CartService;

@RestController
@RequestMapping("api/v1")
public class CartController {
	@Autowired
	CartService cartService;
	@Autowired
	AuthenticationFeignClient authenticationfeign;
	@Autowired
	InventoryFeign inventoryFeign;
	
	
}
