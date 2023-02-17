package com.cropdeal.CartPayService.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.cropdeal.CartPayService.exception.CartPayRequestException;
import com.cropdeal.CartPayService.model.Cart;
import com.cropdeal.CartPayService.repository.CartRepository;

@Service
public class CartServiceImpl implements CartService {

	@Autowired
	CartRepository cartRepository;
	
	@Autowired
    private RestTemplate restTemplate;
	

	public Cart save(Cart cart) {
		Cart cart1 = cartRepository.save(cart);
		return cart1;
	}

	public List<Cart> findAll() {
		return (List<Cart>) cartRepository.findAll();
	}

	public String deleteById(String id) {
		if (!findByCartId(id).isEmpty()) {
			cartRepository.deleteById(id);
			return "Id " + id + " deleted!";
		} else {
			return "Id " + id + " is not found";
		}
	}

	@Override
	public double getTotalPrice(String userId) {
		List<Optional<Cart>> cart = cartRepository.findByUserId(userId);
		if (cart.isEmpty()) {
			return 0.0;
		} else {
			double sum = 0.0;
			for (Optional<Cart> c : cart) {
				double cartPrice = c.get().getQuantity() * c.get().getPrice();
				sum = sum + cartPrice;
			}
			return sum;
		}
	}

	@Override
	public String deleteAllCart(String userId) {
		List<Cart> cart = cartRepository.findAll();
		for (Cart cart2 : cart) {
			deleteById(cart2.getCartId());
		}
		return "All deleted";
	}

	@Override
	public Optional<Cart> findByCartId(String cartId) {
		Optional<Cart> cart = cartRepository.findById(cartId);
		if (cart.isEmpty()) {
			throw new CartPayRequestException("Id is not found");
		} else {
			return cart;
		}
	}

	@Override
	public List<Optional<Cart>> findByUserId(String userId) {
			List<Optional<Cart>> cart = cartRepository.findByUserId(userId);
			if (cart.isEmpty()) {
				throw new CartPayRequestException("UserId is not found");
			} else {
				return cart;
			}
		}

	

}