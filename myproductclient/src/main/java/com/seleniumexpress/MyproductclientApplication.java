package com.seleniumexpress;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.http.client.SimpleClientHttpRequestFactory;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class MyproductclientApplication {

	public static void main(String[] args) {
		SpringApplication.run(MyproductclientApplication.class, args);
	}

	@Bean
	public RestTemplate restTemplate() 
	{
	SimpleClientHttpRequestFactory simpleClientHttpRequestFactory =new SimpleClientHttpRequestFactory();
	simpleClientHttpRequestFactory.setConnectTimeout(11000);
	simpleClientHttpRequestFactory.setReadTimeout(11000);
		return new RestTemplate(simpleClientHttpRequestFactory);
	}
}
