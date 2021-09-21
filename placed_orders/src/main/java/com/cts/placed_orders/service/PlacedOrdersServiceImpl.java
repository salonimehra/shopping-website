package com.cts.placed_orders.service;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cts.placed_orders.feign.InventoryFeignClient;
import com.cts.placed_orders.feign.StockFeignClient;
import com.cts.placed_orders.model.OrderDetails;
import com.cts.placed_orders.model.ProductDetails;
import com.cts.placed_orders.model.StockDetails;
import com.cts.placed_orders.repoistory.PlacedOrdersRepository;

@Service
public class PlacedOrdersServiceImpl implements PlacedOrdersService{
	
	@Autowired
	private PlacedOrdersRepository placedOrdersRepository;
	
	//feign client
	@Autowired
	private InventoryFeignClient inventoryFeignClient;
	@Autowired
	private StockFeignClient stockFeignClient;
	
	@Override
	public boolean placeorder(Long productId, Integer productQuantity) {
		
		//for(ProductDetails product:products) {
	
			ProductDetails productInStock=inventoryFeignClient.getProductById(productId);
			StockDetails orderStockDetails= new StockDetails(productId, productQuantity);
			//for(ProductDetails productDetail:productInStock) {
				if(stockFeignClient.updateStocks(orderStockDetails).equalsIgnoreCase("Updated Succesfully")) {
					OrderDetails order = new OrderDetails(productInStock.getId(),productInStock.getName(),
							productInStock.getDescription(),productInStock.getBrand(),
							productInStock.getPrice(),productQuantity);
					placedOrdersRepository.save(order);
					return true;
				}
				
			//later product not found or out of stock exception to be added
				else return false;
		
	}
	

	@Override
	public OrderDetails getOrderDetailsById(Integer orderId) {

		//later order not present exception to be added here
		OrderDetails orderDetails = placedOrdersRepository.findById(orderId).orElse(null);
		return orderDetails;
	}

	@Override
	public List<OrderDetails> getPlacedOrdersDetail() {

		List<OrderDetails> orderDetails = placedOrdersRepository.findAll();
		return orderDetails;
	}

}
