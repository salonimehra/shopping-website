package com.cts.placed_orders.service;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cts.placed_orders.feign.InventoryFeignClient;
import com.cts.placed_orders.model.OrderDetails;
import com.cts.placed_orders.model.ProductDetails;
import com.cts.placed_orders.repoistory.PlacedOrdersRepository;

@Service
public class PlacedOrdersServiceImpl implements PlacedOrdersService{
	
	@Autowired
	private PlacedOrdersRepository placedOrdersRepository;
	
	//feign client
	
	@Autowired
	private InventoryFeignClient inventoryFeignClient;
	
	//private List<ProductDetails> productDetails;
	
	//stud created. this data will be fetched from inventory after integration
//	public PlacedOrdersServiceImpl() {
//		
//		ProductDetails p1 = new ProductDetails(1, "Apple", "128gb memory 8gb ram", 100);
//		ProductDetails p2 = new ProductDetails(2, "Oneplus", "256gb memory 12gb ram", 120);
//		ProductDetails p3 = new ProductDetails(3, "Samsung", "256gb memory 8gb ram", 150);
//		ProductDetails p4 = new ProductDetails(4, "Moto", "128gb memory 6gb ram", 80);
//		ProductDetails p5 = new ProductDetails(5, "Lenovo", "84gb memory expandable upto 128gb 8gb ram", 200);
//		productDetails = new ArrayList<ProductDetails>(Arrays.asList(p1,p2,p3,p4,p5));
//	}

	@Override
	public boolean placeorder(Long productId, Integer productQuantity) {
		
		//for(ProductDetails product:products) {
		System.out.println("service layer");
			ProductDetails productInStock=inventoryFeignClient.getProductById(productId);
			System.out.println(productInStock+" "+productId);
			//for(ProductDetails productDetail:productInStock) {
				if(productInStock.isProductInStock()) {
					OrderDetails order = new OrderDetails();
					order.setProductId(productInStock.getProductId());
					order.setProductName(productInStock.getProductName());
					order.setProductDescription(productInStock.getProductDescription());
					order.setProductQuantity(productQuantity);
					placedOrdersRepository.save(order);
					return true;
				}
				
			//}
			//later out of stock exception to be added here
				else return false;
		//}
		
//		OrderDetails orderDetails = new OrderDetails();
//		orderDetails.setProductDetails(products);
//		placedOrdersRepository.save(orderDetails);
//		
		//List<OrderDetails> ordersDetails=new ArrayList<OrderDetails>();
		
		//for(ProductDetails product:products) {
		//	System.out.println(productDetails.get(product.getProductId()-1).getQuantity());
//			order.setProductDetails(product);
			
			//ordersDetails.add(order);
//			productDetails.get(orderedProduct.getProductId()-1).setQuantity(
//					productDetails.get(orderedProduct.getProductId()-1).getQuantity()-
//					orderedProduct.getQuantity());
			//product.setQuantity(product.getQuantity()-order.getQuantity());
			//System.out.println(productDetails.get(orderedProduct.getProductId()-1).getQuantity());
		//}
		
	}

	@Override
	public OrderDetails getOrderDetailsById(Integer id) {

		//later order not present exception to be added here
		OrderDetails orderDetails = placedOrdersRepository.findById(id).orElse(null);
		return orderDetails;
	}

	@Override
	public List<OrderDetails> getPlacedOrdersDetail() {

		List<OrderDetails> orderDetails = placedOrdersRepository.findAll();
		return orderDetails;
	}

}
