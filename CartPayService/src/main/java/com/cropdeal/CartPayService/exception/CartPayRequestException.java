package com.cropdeal.CartPayService.exception;


public class CartPayRequestException extends RuntimeException{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public CartPayRequestException(String message, Throwable cause) {
		super(message, cause);
	}

	public CartPayRequestException(String message) {
		super(message);
	}

}
