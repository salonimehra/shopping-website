package com.cts.placed_orders;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan("com.cts.placed_orders.*")
@EnableFeignClients
public class PlacedOrdersApplication {

	public static void main(String[] args) {
		SpringApplication.run(PlacedOrdersApplication.class, args);
	}

}
