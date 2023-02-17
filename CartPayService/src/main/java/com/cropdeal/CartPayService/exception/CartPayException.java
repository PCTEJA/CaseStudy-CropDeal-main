package com.cropdeal.CartPayService.exception;

import org.springframework.http.HttpStatus;

public class CartPayException {

	private String errorMsg;

	private HttpStatus httpStatus;

	public String getErrorMsg() {
		return errorMsg;
	}

	public void setErrorMsg(String errorMsg) {
		this.errorMsg = errorMsg;
	}

	public HttpStatus getHttpStatus() {
		return httpStatus;
	}

	public void setHttpStatus(HttpStatus httpStatus) {
		this.httpStatus = httpStatus;
	}

	public CartPayException(String errorMsg) {
		super();
		this.errorMsg = errorMsg;
		// this.httpStatus = httpStatus;
	}
}
