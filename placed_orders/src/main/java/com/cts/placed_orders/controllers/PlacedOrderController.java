package com.cts.placed_orders.controllers;

import java.util.List;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cts.placed_orders.feign.AuthenticationFeignClient;
import com.cts.placed_orders.model.OrderDetails;
import com.cts.placed_orders.model.ProductDetails;
import com.cts.placed_orders.service.PlacedOrdersService;

@RestController
@RequestMapping(value="/api/v1")
public class PlacedOrderController {

	@Autowired
	PlacedOrdersService placedOrdersService;
	
	@Autowired
	AuthenticationFeignClient authenticationfeign;
	
	@PostMapping("/placeorder")
	public ResponseEntity<?> placeorder(@RequestBody List<ProductDetails> products,
			@RequestHeader(value = "Authorization",required =  true) String requestTokenHeader){
		if (authenticationfeign.authorizeTheRequest(requestTokenHeader))
		{
		boolean status=placedOrdersService.placeorder(products);
		//later appropriate exception to be added
		if(status == true)
		return new ResponseEntity<>(status,HttpStatus.OK);
		else {
			return new ResponseEntity<>("Out of stock",HttpStatus.PRECONDITION_FAILED);

		}
		}
		else {
			//later add proper exception
			return new ResponseEntity<>("Out of stock",HttpStatus.PRECONDITION_FAILED);

		}
	}
	
	@PostMapping("/getordersbyid")
	public ResponseEntity<?> getOrdersByid(@RequestBody Integer id,
			@RequestHeader(value = "Authorization",required =  true) String requestTokenHeader){
		if (authenticationfeign.authorizeTheRequest(requestTokenHeader))
		{
		OrderDetails orderDetails=placedOrdersService.getOrderDetailsById(id);
		if(Objects.isNull(orderDetails)) return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		else return new ResponseEntity<>(orderDetails,HttpStatus.OK);
		}
		else {
			//later add proper exception
			return new ResponseEntity<>("Out of stock",HttpStatus.PRECONDITION_FAILED);

		}
	}
	
	@GetMapping("/getorders")
	public ResponseEntity<?> getOrders(@RequestHeader(value = "Authorization",required =  true) String requestTokenHeader){
		if (authenticationfeign.authorizeTheRequest(requestTokenHeader))
		{
		List<OrderDetails> orderDetails=placedOrdersService.getPlacedOrdersDetail();
		if(Objects.isNull(orderDetails.get(0))) return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		else return new ResponseEntity<>(orderDetails,HttpStatus.OK);
		}
		else {
			//later add proper exception
			return new ResponseEntity<>("Out of stock",HttpStatus.PRECONDITION_FAILED);

		}
	}
}
