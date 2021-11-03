package com.cts.placed_orders.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.cts.placed_orders.model.StockDetails;

@FeignClient(name="stock",url="${stock.url}")
public interface StockFeignClient {
	@PutMapping("/Product")
	public String updateStocks(@RequestBody StockDetails stockDeatils);
}
