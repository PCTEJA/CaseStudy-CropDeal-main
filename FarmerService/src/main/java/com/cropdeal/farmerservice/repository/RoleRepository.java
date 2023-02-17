package com.cropdeal.farmerservice.repository;

import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.cropdeal.farmerservice.model.ERole;
import com.cropdeal.farmerservice.model.Role;




public interface RoleRepository extends MongoRepository<Role, String> {
  Optional<Role> findByName(ERole name);
}
