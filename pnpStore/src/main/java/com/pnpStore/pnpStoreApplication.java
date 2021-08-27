package com.pnpStore;

import org.springframework.boot.SpringApplication;



import org.springframework.boot.autoconfigure.SpringBootApplication;

//This annotation tags the class as the source for bean definitions
@SpringBootApplication
public class pnpStoreApplication {

	public static void main(String[] args) {
		SpringApplication.run(pnpStoreApplication.class, args);
	}
}
