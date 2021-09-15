package com.cts.placed_orders.feign;

import org.springframework.cloud.openfeign.FeignClient;
//import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.cts.placed_orders.model.ProductDetails;

@FeignClient(name="inventory",url="${inventory.url}")
public interface InventoryFeignClient {

	@GetMapping("/getProductById/{id}")
	public ProductDetails getProductById(@PathVariable("id") long id);
}
