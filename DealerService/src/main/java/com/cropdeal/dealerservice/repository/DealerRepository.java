package com.cropdeal.dealerservice.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.cropdeal.dealerservice.models.Dealer;


@Repository
public interface DealerRepository extends MongoRepository<Dealer, String>{

	

}
