package com.Inventory.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Inventory.Model.StockDetails;
import com.Inventory.Repository.StockRepository;

@Service
public class InventoryService {
	@Autowired
	StockRepository stockRepository;
	
	public boolean addProductinStock(StockDetails stockDetails) throws Exception {
		try {
			System.out.println(stockDetails.getId());
			stockRepository.save(stockDetails);
			return true;
			}
		catch(Exception e) {
			throw new Exception("Product Not Updated");
		}
	}
	
	public boolean updateProductAfterOrder(StockDetails stockDetails) throws Exception {
		//check if the order for the amount is in stock if it is then update accordingly and return true
		StockDetails product=stockRepository.findById(stockDetails.getId()).get();
		if(product.getStock()<stockDetails.getStock()) {//edit change in greater than symbol
			throw new Exception("Out Of Stocks");
		}
		else {
			stockDetails.setStock(product.getStock()-stockDetails.getStock());
			stockRepository.save(stockDetails);
			return true;
		}
	}
}
