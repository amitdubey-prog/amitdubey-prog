package com.amit.ms;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class ProductDiscoveryServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(ProductDiscoveryServiceApplication.class, args);
	}

}
