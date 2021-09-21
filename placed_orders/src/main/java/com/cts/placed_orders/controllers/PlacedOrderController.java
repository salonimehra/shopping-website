package com.cts.placed_orders.controllers;

import java.util.List;

import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cts.placed_orders.feign.AuthenticationFeignClient;
import com.cts.placed_orders.model.OrderDetails;
//import com.cts.placed_orders.model.ProductDetails;
import com.cts.placed_orders.service.PlacedOrdersService;

import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping(value="/api/v1")
@Slf4j
public class PlacedOrderController {

	@Autowired
	PlacedOrdersService placedOrdersService;
	
	@Autowired
	AuthenticationFeignClient authenticationfeign;
	
	/*
	 *  Method Name --> placeorder
	 *  @param      --> productId and Product Quantity
	 *  @return     --> String
	 *  This method takes product id and product quantity and checks whether enough stock is
	 *  there or not. If stock is there it will place the order else it will throw out of stock
	 *  exception 
	 */
	@PostMapping("/placeorder/{productId}/{productQuantity}")
	public ResponseEntity<?> placeorder(@PathVariable Integer productId, @PathVariable Integer  productQuantity,
			@RequestHeader(value = "Authorization",required =  true) String requestTokenHeader){
		
		log.info("place order entry point started of placed-order microservice");
		if (authenticationfeign.authorizeTheRequest(requestTokenHeader))
		{
		
			Long orderedProductId=new Long(productId);		
			boolean status=placedOrdersService.placeorder(orderedProductId,productQuantity);
			//later appropriate exception to be added
			if(status == true) {
				log.info("Returning placed order true status from place order entry point");
				return new ResponseEntity<>(status,HttpStatus.OK);
			}
			else {
				log.info("Returning out of stock exception from place order entry point");
				return new ResponseEntity<>("Out of stock",HttpStatus.NOT_FOUND);
			}
		}
		else {
			//later add proper exception
			log.info("Authentication failed for placed order entry point");
			return new ResponseEntity<>("Out of stock",HttpStatus.PRECONDITION_FAILED);

		}
	}
	
	/*
	 *  Method Name --> getOrdersByid
	 *  @param      --> orderId
	 *  @return     --> Order details
	 *  This method takes order id as parameter and search for the order. If that order is present
	 *  it returns the order details else return order not found exception
	 */
	@GetMapping("/orders/{orderId}")
	public ResponseEntity<?> getOrdersByid(@PathVariable Integer orderId,
			@RequestHeader(value = "Authorization",required =  true) String requestTokenHeader){
		log.info("get order by id entry point started of placed-order microservice");
		if (authenticationfeign.authorizeTheRequest(requestTokenHeader))
		{
		OrderDetails orderDetails=placedOrdersService.getOrderDetailsById(orderId);
		if(Objects.isNull(orderDetails)) {
			log.info("Returning resultant data not found from get order by id entry point");
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();}
		else {
			log.info("Returning resultant data from get order by id entry point");
			return new ResponseEntity<>(orderDetails,HttpStatus.OK);}
		}
		else {
			log.info("Authentication failed for get order by id entry point");
			//later add proper exception
			return new ResponseEntity<>("Authentication failed",HttpStatus.PRECONDITION_FAILED);

		}
	}
	
	/*
	 *  Method Name --> getOrders
	 *  @return     --> Order details
	 *  This method returns the details of all the orders placed.
	 */
	@GetMapping("/orders")
	public ResponseEntity<?> getAllOrders(@RequestHeader(value = "Authorization",required =  true) String requestTokenHeader){
		log.info("get all orders entry point started of placed-order microservice");
		if (authenticationfeign.authorizeTheRequest(requestTokenHeader))
		{
		List<OrderDetails> orderDetails=placedOrdersService.getPlacedOrdersDetail();
		if(Objects.isNull(orderDetails.get(0))) {
			log.info("Returning resultant data not found from get all orders entry point");
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}
		else {
			log.info("Returning resultant data from get all orders entry point");
			return new ResponseEntity<>(orderDetails,HttpStatus.OK);}
		}
		else {
			//later add proper exception
			log.info("Authentication failed for get all orders entry point");
			return new ResponseEntity<>("Authentication failed",HttpStatus.PRECONDITION_FAILED);

		}
	}
}
