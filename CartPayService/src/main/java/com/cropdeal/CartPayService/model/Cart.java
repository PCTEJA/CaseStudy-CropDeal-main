package com.cropdeal.CartPayService.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Document(collection = "CartDetails")  //to map into a collection inside mongodb
public class Cart {

	@Id //used for identity purpose
	private String cartId;
	private String userId;
	private int quantity;
	private double price;
	
	public String getCartId() {
		return cartId;
	}
	public void setCartId(String cartId) {
		this.cartId = cartId;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	
	@Override
	public String toString() {
		return "Cart [cartId=" + cartId + ", userId=" + userId + ", quantity=" + quantity + ", price=" + price + "]";
	}
	
	public Cart(String cartId, String userId, int quantity, double price) {
		super();
		this.cartId = cartId;
		this.userId = userId;
		this.quantity = quantity;
		this.price = price;
	}

	
	

}
