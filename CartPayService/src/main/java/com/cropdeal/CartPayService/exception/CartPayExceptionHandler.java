package com.cropdeal.CartPayService.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice

public class CartPayExceptionHandler {

	@ExceptionHandler(value= {CartPayRequestException.class})
	public ResponseEntity<Object> handleCartPayRequestException(CartPayRequestException e){
		
		HttpStatus badRequest=HttpStatus.BAD_REQUEST;
		CartPayException apiException=new CartPayException(e.getMessage());
		return new ResponseEntity<Object>(apiException,badRequest);
	}

}
