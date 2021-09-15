package com.cts.placed_orders.service;

import java.util.List;

//import org.springframework.stereotype.Service;

import com.cts.placed_orders.model.OrderDetails;
import com.cts.placed_orders.model.ProductDetails;


public interface PlacedOrdersService {
	
	public boolean placeorder(Long productId, Integer productQuantity);
	public List<OrderDetails> getPlacedOrdersDetail();
	public OrderDetails getOrderDetailsById(Integer orderId);

}
