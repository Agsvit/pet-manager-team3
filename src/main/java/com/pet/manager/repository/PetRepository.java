package com.pet.manager.repository;

import com.pet.manager.model.Pet;
import com.pet.manager.model.PetType;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;
import java.util.Optional;

public interface PetRepository extends MongoRepository<Pet, String> {

    List<Pet> findByType(PetType type);

    Optional<Pet> findByNameContaining(String name);
}
