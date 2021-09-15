package com.cts.placed_orders;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;

import lombok.extern.slf4j.Slf4j;

@SpringBootApplication
@ComponentScan("com.cts.placed_orders.*")
@EnableFeignClients
@Slf4j
public class PlacedOrdersApplication {

	public static void main(String[] args) {
		log.info("inside application class of Placed order microservice");
		SpringApplication.run(PlacedOrdersApplication.class, args);
		log.info("end of application class of Placed order microservice");

	}

}
