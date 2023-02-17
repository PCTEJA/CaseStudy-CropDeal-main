package com.cropdeal.dealerservice.repository;

import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.cropdeal.dealerservice.models.ERole;
import com.cropdeal.dealerservice.models.Role;



public interface RoleRepository extends MongoRepository<Role, String> {
  Optional<Role> findByName(ERole name);
}
