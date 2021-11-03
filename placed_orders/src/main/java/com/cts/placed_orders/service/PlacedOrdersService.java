package com.cts.placed_orders.service;

import java.util.List;

import com.cts.placed_orders.model.OrderDetails;


public interface PlacedOrdersService {
	
	public boolean placeorder(Long productId, Integer productQuantity);
	public List<OrderDetails> getPlacedOrdersDetail();
	public OrderDetails getOrderDetailsById(Integer orderId);

}
