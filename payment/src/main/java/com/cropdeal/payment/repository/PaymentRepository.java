package com.cropdeal.payment.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.cropdeal.payment.model.OrderResponse;


@Repository
public interface PaymentRepository extends MongoRepository<OrderResponse, Integer> {

}
