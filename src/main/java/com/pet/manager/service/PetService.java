package com.pet.manager.service;

import com.pet.manager.model.Pet;
import com.pet.manager.repository.PetRepository;

import java.util.List;

public class PetService {

    private final PetRepository petRepository;

    public PetService(PetRepository petRepository) {
        this.petRepository = petRepository;
    }

    public List<Pet> findAll() {
        return petRepository.findAll();
    }

    public Pet save(Pet pet) {
        return petRepository.save(pet);
    }
}
