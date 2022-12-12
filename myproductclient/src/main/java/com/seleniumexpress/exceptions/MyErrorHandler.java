package com.seleniumexpress.exceptions;

import java.io.IOException;

import org.springframework.http.HttpStatus;
import org.springframework.http.client.ClientHttpResponse;
import org.springframework.stereotype.Component;
import org.springframework.web.client.ResponseErrorHandler;

@Component
public class MyErrorHandler implements ResponseErrorHandler {

	@Override
	public boolean hasError(ClientHttpResponse response) throws IOException {
		
		
		if (response.getStatusCode() != HttpStatus.OK) {
		System.out.println("***********************");
		System.out.println("in side haserror method");
		System.out.println(response.getStatusText());
		System.out.println(response.getStatusCode());
		System.out.println("***********************");
		return true;
		
		}
		System.out.println("in side haserror method");
		return false;
	}

	@Override
	public void handleError(ClientHttpResponse response) throws IOException {
			System.out.println("in side handleerror method");
		
	}

}
