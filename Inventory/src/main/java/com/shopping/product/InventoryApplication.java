/*package com.shopping.product;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableAutoConfiguration
@EnableFeignClients
public class InventoryApplication {

	public static void main(String[] args) {
		SpringApplication.run(InventoryApplication.class, args);
	}
	

}
*/
package com.shopping.product;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

import com.shopping.product.Feign.StockFeignClient;
import com.shopping.product.model.Product;
import com.shopping.product.model.StockDetails;
import com.shopping.product.repository.ProductRepository;

@SpringBootApplication
@EnableAutoConfiguration
@EnableFeignClients
public class InventoryApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(InventoryApplication.class, args);
	}
	
	@Autowired
	ProductRepository productRepository;
	@Autowired
	StockFeignClient stockFeign;
	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		//this.productRepository.save(new Product("iPhone13","your new super power","apple",89900,"https://www.apple.com/v/iphone-13/a/images/overview/hero/hero_1_static__d195o2nfxt26_large.jpg"));
		//this.productRepository.save(new Product("iPhone13 pro","Oh. so. pro.","apple",129000,"https://www.apple.com/newsroom/images/product/iphone/geo/Apple_iPhone-13-Pro_iPhone-13-Pro-Max_GEO_09142021_inline.jpg.large.jpg"));
		try   
		{  
			String line = "";  
			String splitBy = ",";  
			//parsing a CSV file into BufferedReader class constructor  
			BufferedReader br = new BufferedReader(new FileReader("src/main/resources/ProductItems.csv"));  
			while ((line = br.readLine()) != null)   //returns a Boolean value  
			{  
			String[] data = line.split(splitBy);    // use comma as separator  
			Product product= this.productRepository.save(new Product(data[0],data[1], data[2] , Integer.parseInt(data[3]) ,data[4]));  
			stockFeign.updateStocks(new StockDetails(product.getId(),1000));
			}  
			br.close();
		}   
		catch (IOException e)   
		{  
			e.printStackTrace();  
		}  
	}

}
