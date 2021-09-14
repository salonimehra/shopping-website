package com.cart.Feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.cart.Model.Product;

@FeignClient(name="Inventory-Microservice",url="http://localhost:8080/api/")
public interface InventoryFeign {

	@GetMapping("/products/{id}")
	public Product getProductByID(@PathVariable("id") long id);
}
