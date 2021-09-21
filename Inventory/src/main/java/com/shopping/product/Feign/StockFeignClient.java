package com.shopping.product.Feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.shopping.product.model.StockDetails;

@FeignClient(name="stock",url="${stock.url}")
public interface StockFeignClient {
	@PostMapping("/Product")
	public String updateStocks(@RequestBody StockDetails stockDeatils);
}
