package com.cropdeal.payment.service;

import java.util.Random;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cropdeal.payment.model.OrderResponse;
import com.cropdeal.payment.repository.PaymentRepository;




@Service
public class PaymentService {
	
	@Autowired
	private PaymentRepository paymentRepository;
	
	public OrderResponse doPay(OrderResponse payment) {
		
		payment.setTxId(UUID.randomUUID().toString());
		return paymentRepository.save(payment);
		
	}

	private String paymentStatus() {
		// TODO Auto-generated method stub
		return new Random().nextBoolean()?"success":"failure";
	}
	
}
