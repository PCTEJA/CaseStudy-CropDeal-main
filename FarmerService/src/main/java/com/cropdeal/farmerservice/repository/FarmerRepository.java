package com.cropdeal.farmerservice.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.cropdeal.farmerservice.model.Farmer;

@Repository
public interface FarmerRepository extends MongoRepository<Farmer, String>{

}
