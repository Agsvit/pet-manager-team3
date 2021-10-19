package com.pet.manager.repository;

import com.pet.manager.model.Pet;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface PetRepository extends MongoRepository<Pet, String> {
}
