package com.cropdeal.CartPayService.controller;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cropdeal.CartPayService.model.Cart;
import com.cropdeal.CartPayService.model.Crop;
import com.cropdeal.CartPayService.service.CartService;


@RestController
@RequestMapping("/cart")
@CrossOrigin(origins = "http://localhost:4200")
public class CartController {
	
	Logger log = LoggerFactory.getLogger(CartController.class);

	@Autowired
	CartService cartService;
	
	

	@PostMapping("/addCart")
	public Cart addCart(@RequestBody Cart cart) {
		log.info("cart added");
		Cart cart1 = cartService.save(cart);
		return cart1;
	}
	
	@GetMapping("/findcartId/{cartId}")
	public Optional<Cart> searchCartByCartId(@PathVariable("cartId") String cartId) {
		log.info("the cart id" +cartId+ "is available");
		Optional<Cart> cart = cartService.findByCartId(cartId);
		return cart;
	}
	
	@GetMapping("/finduserId/{userId}")
	public List<Optional<Cart>> searchCartByUserId(@PathVariable("userId") String userId) {
		log.info("the user id" +userId+ "is available");
		List<Optional<Cart>> cart2 = cartService.findByUserId(userId);
		return cart2;
	}
	
	@GetMapping("/findall")
	public List<Cart> findCart() {
		log.info("found all carts");
		return (List<Cart>) cartService.findAll();
	}
	
	@DeleteMapping("/deleteCart/{id}")
	public String deleteCartById(@PathVariable("id") String id) {
		log.info("deleted" + id);
		String result = cartService.deleteById(id);
		return result;
	}
	
	@GetMapping("/totalPrice/{userId}")
	    public double getTotalPrice(@PathVariable("userId") String userId) {
		log.info("got totalprice for" +userId);
	        double result=cartService.getTotalPrice(userId);
	    	return result;
	        }
	
	@DeleteMapping("/deleteAllCart/{userId}")
	public String deleteAllCart(@PathVariable("userId") String userId) {
		log.info("deleted all carts for" + userId);
		String result=cartService.deleteAllCart(userId);
		return result;
	}
	
	@PutMapping("/updateCart")
	public Cart updateCart(@RequestBody Cart cart) {
		log.info("updated cart");
		Cart cart1 = cartService.save(cart);
		return cart1;
	}

}
