package com.cropdeal.cropservice.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.cropdeal.cropservice.model.Crop;

public interface CropRepository extends MongoRepository<Crop ,String> {

}
