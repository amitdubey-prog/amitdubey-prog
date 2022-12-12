package com.amit.ms;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

import feign.Logger.Level;

@SpringBootApplication
@EnableEurekaClient
@EnableFeignClients
public class ProductRegistrationApplication {

	public static void main(String[] args) {
		SpringApplication.run(ProductRegistrationApplication.class, args);
	}

	
	@Bean
	@LoadBalanced
	public RestTemplate restTemplate() {
		return new RestTemplate();
	}
	
	@Bean
	 Level getLogger(){
		 return feign.Logger.Level.FULL;
	 }
}
