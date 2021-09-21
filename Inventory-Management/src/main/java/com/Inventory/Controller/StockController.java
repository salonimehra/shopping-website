package com.Inventory.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.Inventory.Model.StockDetails;
import com.Inventory.Service.InventoryService;

import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j
@RequestMapping("/api")
public class StockController {
	@Autowired
	InventoryService inventoryService;
	@PostMapping("/Product")//insertProductStocks
	public ResponseEntity<Boolean> addStocks(@RequestBody StockDetails stockDetails){
		try {
			inventoryService.addProductinStock(stockDetails);
			return new ResponseEntity<>(true,HttpStatus.OK);
		}
		catch(Exception e) {
			return new ResponseEntity<>(false,HttpStatus.BAD_REQUEST);
		}
		
	}
	@PutMapping("/Product")
	public ResponseEntity<?> updateStocks(@RequestBody StockDetails stockDetails){
		try {
			inventoryService.updateProductAfterOrder(stockDetails);
			return new ResponseEntity<>("Updated Succesfully",HttpStatus.ACCEPTED);
		}
		catch(Exception e) {
			return new ResponseEntity<>("Out Of Stock",HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
}
