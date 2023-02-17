package com.cropdeal.CartPayService.service;

import java.util.List;
import java.util.Optional;

import com.cropdeal.CartPayService.model.Cart;
import com.cropdeal.CartPayService.model.Crop;

public interface CartService {

	public Cart save(Cart cart);

	public List<Cart> findAll();

	public String deleteById(String id);

	double getTotalPrice(String userId);

	public String deleteAllCart(String userId);

	public Optional<Cart> findByCartId(String cartId);

	public List<Optional<Cart>> findByUserId(String userId);

	


}
